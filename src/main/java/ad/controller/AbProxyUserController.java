package ad.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import ad.bean.AbProxyUser;
import ad.service.IAbBankCardService;
import ad.service.IAbBillingCycleService;
import ad.service.IAbBillingInfoService;
import ad.service.IAbProxyUserService;
import ad.service.IAbReveOrderService;
import ad.util.Constends;
import ad.util.DateUtil;
import ad.util.ExcelUtil07;
import ad.util.GetClassPath;
import ad.util.HttpConnection;
import ad.util.MessageUtils;
import ad.util.MsExcelW;

import net.sf.json.JSONSerializer;

/**
 * 代理用户类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/abProxeyUser")
public class AbProxyUserController {

	@Autowired
	IAbProxyUserService abProxyUserService;
	@Autowired
	IAbBankCardService abBankCardService;
	@Autowired
	IAbBillingInfoService abBillingInfoService;
	@Autowired
	IAbBillingCycleService abBillingCycleService;
	@Autowired
	IAbReveOrderService abReveOrderService;
	/**
	 * 按着主键查询出来的代理用户(代理详情接口)
	 * @param req
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/GetProxyInfo", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryById(HttpServletRequest req,HttpServletResponse response,int id){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			//查询代理详情
			String result = abProxyUserService.getProxyInfoById(id);
			return result;
		}catch(Exception e){
			m.put("code", 0);
			m.put("message", "fail");
			e.printStackTrace();
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 初始加载代理用户全部数据
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/GetAllUser", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String getAllUser(HttpServletRequest req,HttpServletResponse response,AbProxyUser abProxyUser){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			//查询所有未删除的代理用户
			String result = abProxyUserService.getAllUser(abProxyUser);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 代理用户按着条件查询接口
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/QueryProxyList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryProxyList(HttpServletRequest req,HttpServletResponse response,AbProxyUser abProxyUser){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			//条件查询
			String result = abProxyUserService.getProxyInfo(abProxyUser);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 按着条件导出(导出excel)
	 * @param req
	 * @param response
	 * @param abProxyUser
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/ExportQueryProxyList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public void exportQueryProxyList(HttpServletRequest req,HttpServletResponse response,AbProxyUser abProxyUser) throws FileNotFoundException{
		abProxyUserService.exportProxyList(response,abProxyUser);
	}
	
	/**
	 * 下载
	 * @param req
	 * @param response
	 * @param abProxyUser
	 */
	@RequestMapping(value = "/ExportQueryProxyList1", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	@Deprecated
	public void exportQueryProxyList1(HttpServletRequest req,HttpServletResponse response,AbProxyUser abProxyUser) throws FileNotFoundException{
		String filename =null;
		//下载路径
		String downPath = GetClassPath.ClassPath() ; 
		try {
			List<AbProxyUser> abProxyUserList = abProxyUserService.exportQueryProxyList(abProxyUser);
			for(AbProxyUser u:abProxyUserList){
				if(u.getFatherId() !=null && !u.getFatherId().equals("")){
					AbProxyUser queryById = abProxyUserService.queryById(u.getFatherId());
					u.setUpperName(queryById.getProxyUserName());
				}
			}
			// 将数据写入模版文件
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
			String time = formatter.format(new Date());
			   filename = writeAllProxyTemplate(time,abProxyUserList,downPath);
			if (filename == null) {
				return ;
			}
	        // 文件下载
			download(response,"代理用户.xlsx",downPath,filename);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			File f = new File(downPath+"\\"+filename);  // 输入要删除的文件位置
			if(f.exists()){
				f.delete();
			}
		}
	}
	/**ORDER PARTS LIST
	 * 将数据写入模版文件
	 * @return 文件名称
	 */
	private String writeAllProxyTemplate(String time,List<AbProxyUser> abProxyUserList,String downPath) throws FileNotFoundException{
		File path = new File(ResourceUtils.getURL("file:").getPath());
		//模板路径
		String classPath = path.getAbsolutePath()+GetClassPath.printPath;
		// 获取数据结构
		String printTemplateName = "代理用户.xlsx";
		// 源模板路径
		String sourcePath = classPath;
		String sourcePathFileName = sourcePath + printTemplateName;
		// 目标路径（下载路径）
		String targetPath =downPath ;
		//下载到服务器上的名字
        String fttpName = DateUtil.createKey()+".xlsx";
		String targetFileName = fttpName;
		ExcelUtil07 excelx = new ExcelUtil07();
		try {
			if (!excelx.init(sourcePathFileName)){
				return null;
			}
			// 写用户自定义变量信息
			writeTemplateContent(excelx,abProxyUserList);
			//
			excelx.writeExcelx(targetPath +"\\"+ targetFileName);
			return targetFileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private static void writeTemplateContent(MsExcelW excelx, List<AbProxyUser> abProxyUserList) {
		//此处是增加excel列的问题模块
		if(abProxyUserList !=null && abProxyUserList.size()-2>0){
			excelx.insertRow(0, 3,abProxyUserList.size()-2);//增加所有的行
		}
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		for (int i = 0; i < abProxyUserList.size(); i++) {
			excelx.gotoCellWriteText(0, i + 2, 0, i+1+"", false); // 序号
			excelx.gotoCellWriteText(0, i + 2, 1, abProxyUserList.get(i).getProxyName()+"", false); // 用户ID
			excelx.gotoCellWriteText(0, i + 2, 2, abProxyUserList.get(i).getProxyPhone()+"", false); // 手机号
			excelx.gotoCellWriteText(0, i + 2, 3, abProxyUserList.get(i).getProxyUserName()+"", false); // 用户昵称
			excelx.gotoCellWriteText(0, i + 2, 4, abProxyUserList.get(i).getCreateTime()==null?"":time.format(abProxyUserList.get(i).getCreateTime()), false); // 注册时间
			excelx.gotoCellWriteText(0, i + 2, 5, abProxyUserList.get(i).getFatherId()==null?"":String.valueOf(abProxyUserList.get(i).getFatherId()), false); // 上线ID
			excelx.gotoCellWriteText(0, i + 2, 6, abProxyUserList.get(i).getUpperName()==null?"":abProxyUserList.get(i).getUpperName()+"", false); // 上线名称
			excelx.gotoCellWriteText(0, i + 2, 7, abProxyUserList.get(i).getDistributionRatio()==null?"":abProxyUserList.get(i).getDistributionRatio()+"", false); // 与上线分佣
			excelx.gotoCellWriteText(0, i + 2, 8, abProxyUserList.get(i).getOfflineNumber()==null?"":abProxyUserList.get(i).getOfflineNumber()+"", false); // 下线人数
			excelx.gotoCellWriteText(0, i + 2, 9, abProxyUserList.get(i).getSalesChannelsId()==null?"":abProxyUserList.get(i).getSalesChannelsId()+"", false); // 销售渠道ID
//			excelx.setColumnWidth(0, 11+i, 5);//设置每一列的宽度
		}
	}
	protected void download(HttpServletResponse response, String filename,String downPath,String fttpName) {
		// 将数据写入模版文件
		//String filename = writeFile(taskNo);
        // 文件下载SysStatic.WEB_REAL_PATH).append("WEB-INF\\download\\"
		StringBuilder webPath = new StringBuilder();
		webPath.append(downPath);
        try {
        	//文件在服务器中的路径
        	String fullFileName = webPath+"\\" + fttpName;
            System.out.println(fullFileName);
            File outfile = new File(fullFileName);
        	//设置文件MIME类型
            response.setContentType("application/octet-stream");
            //response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
            //设置Content-Disposition
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
            response.addHeader("Content-Length", "" + outfile.length());  //返回头 文件大小
            //读取目标文件，通过response将目标文件写到客户端
            //获取目标文件的绝对路径
	        InputStream in = new FileInputStream(fullFileName);
	        OutputStream out = response.getOutputStream();
	        //写文件
	        int b;
	        while((b=in.read())!= -1)
	        {
	            out.write(b);
	        }
	        in.close();
	        out.close();
        } catch (SocketException e) {

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	/**
	 * 下线列表接口
	 * @param req
	 * @param response
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/QueryDownProxyList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String queryDownProxyList(HttpServletRequest req,HttpServletResponse response,AbProxyUser abProxyUser){
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			String result = abProxyUserService.queryDownProxyList(abProxyUser);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 获取上线ID接口(编辑页的接口)
	 * @param req
	 * @param response
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/QueryEditUpperList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public List<AbProxyUser> queryEditUpperList(HttpServletRequest req,HttpServletResponse response,int id){
		AbProxyUser queryById = abProxyUserService.queryById(id);
		List<AbProxyUser> abProxyUser = abProxyUserService.queryUpperList(queryById.getAgencyLevel()-1);
		return abProxyUser;
	}
	
	/**
	 * 获取上线ID接口(添加页的接口)
	 * @param req
	 * @param response
	 * @param agencyLevel
	 * @return
	 */
	@RequestMapping(value = "/QueryAddUpperList", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public List<AbProxyUser> queryAddUpperList(HttpServletRequest req,HttpServletResponse response,int agencyLevel){
		List<AbProxyUser> abProxyUser = abProxyUserService.queryUpperList(agencyLevel-1);
		return abProxyUser;
	}
	
	/**
	 * 校验用户账号是否存在
	 * @param proxyName
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/CheckProxyName", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String CheckProxyName(String proxyName,HttpServletRequest req){
		Map<String, Object> m = new HashMap<String, Object>();
		try{
			AbProxyUser abProxyUser = abProxyUserService.queryByProxyName(proxyName);
			if(abProxyUser != null){
				m.put("code", 1);
				m.put("message", "该用户账号已存在");
			}else{
				m.put("code", 2);
				m.put("message", "该用户账号可以注册");
			}
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 校验用户手机号是否存在
	 * @param proxyName
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/CheckProxyPhone", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String CheckProxyPhone(String proxyPhone,HttpServletRequest req){
		Map<String, Object> m = new HashMap<String, Object>();
		try{
			AbProxyUser abProxyUser = abProxyUserService.queryByProxyPhone(proxyPhone);
			if(abProxyUser != null){
				m.put("code", 1);
				m.put("message", "该用户手机号已存在");
			}else{
				m.put("code", 2);
				m.put("message", "该用户手机号可以注册");
			}
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 校验用户手机号是否存在(编辑时验证)
	 * @param proxyName
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/EditUserCheckProxyPhone", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String EditUserCheckProxyPhone(String proxyPhone,String userId,HttpServletRequest req){
		Map<String, Object> m = new HashMap<String, Object>();
		try{
			//按着手机号码查询
			AbProxyUser abProxyUser = abProxyUserService.queryByProxyPhone(proxyPhone);
			if(abProxyUser != null && !userId.endsWith(abProxyUser.getUserid())){
				m.put("code", 1);
				m.put("message", "该用户手机号已存在");
			}else{
				m.put("code", 2);
				m.put("message", "该用户手机号可以注册");
			}
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 校验用户邮箱是否存在
	 * @param proxyName
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/CheckProxyEmail", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String CheckProxyEmail(String proxyEmail,HttpServletRequest req){
		Map<String, Object> m = new HashMap<String, Object>();
		try{
			//按着邮箱查询
			AbProxyUser abProxyUser = abProxyUserService.queryByProxyEmail(proxyEmail);
			if(abProxyUser != null){
				m.put("code", 1);
				m.put("message", "该用户邮箱已存在");
			}else{
				m.put("code", 2);
				m.put("message", "该用户邮箱可以注册");
			}
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 校验用户邮箱是否存在(编辑时页面的验证)
	 * @param proxyName
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/EditCheckProxyEmail", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String EditCheckProxyEmail(String proxyEmail,String userId,HttpServletRequest req){
		Map<String, Object> m = new HashMap<String, Object>();
		try{
			AbProxyUser abProxyUser = abProxyUserService.queryByProxyEmail(proxyEmail);
			if(abProxyUser != null && !userId.endsWith(abProxyUser.getUserid())){
				m.put("code", 1);
				m.put("message", "该用户邮箱已存在");
			}else{
				m.put("code", 2);
				m.put("message", "该用户邮箱可以注册");
			}
		}catch(Exception e){
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 添加代理用户
	 * @param abProxyUser
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/AddProxyInfo", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	@Transactional
	public String AddProxyInfo(AbProxyUser abProxyUser,HttpServletRequest req){
		Map<String, Object> m = new HashMap<String, Object>();
		//远程绑定角色的网址
		String serverURLRole = HttpConnection.serverURL + "/updateUserRole.action";
		String token = req.getParameter("token");
		String siteCode = req.getParameter("siteCode");
		try{
			String result = abProxyUserService.addProxyInfo(serverURLRole,abProxyUser,token,siteCode);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
			m.put("code", -1);
			m.put("message", "远程推送异常");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 修改代理用户
	 * @param abProxyUser
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/UpdateProxyInfo", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	@Transactional
	public String updateProxyInfo(AbProxyUser abProxyUser,HttpServletRequest req){
		Map<String,Object> m = new HashMap<String,Object>();
		//推送远程的url
		String serverURL = HttpConnection.serverURL + "/updateUserInfo.action";
		String token = req.getParameter("token");
		String siteCode = req.getParameter("siteCode");
		try{
			//修改代理用户
			String result = abProxyUserService.updateProxyInfo(serverURL,abProxyUser,token,siteCode);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
			m.put("code", 0);
			m.put("message", "远程网路链接异常，请稍后再试！");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 删除代理用户
	 * @param ids
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/DeleteProxy", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	@Transactional
	public String deleteProxy(String ids,HttpServletRequest req) {
		Map<String,Object> m = new HashMap<String,Object>();
		try{
			//删除代理用户 
			String result = abProxyUserService.deleteProxy(ids);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}
	/**
	 * 广告管理-代理分成比例查询
	 * @param abProxyUser
	 * @return
	 */
	@RequestMapping(value = "/QueryDistribution", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	public String selectFirstlevelUser(AbProxyUser abProxyUser){
		try{
			List<AbProxyUser> list = abProxyUserService.selectFirstlevel(abProxyUser);
			long total = abProxyUserService.queryTotal();
			return MessageUtils.jsonRetrunListTotalMessage(1, "success", list, total);
		}catch(Exception e){
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	/**
	 * 添加代理用户
	 * @param abProxyUser
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/AddProxyInfo1", produces = {"application/json; charset=utf-8"})
	@ResponseBody
	@Transactional
	@Deprecated
	public String AddProxyInfo1(AbProxyUser abProxyUser,HttpServletRequest req){
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Object> m = new HashMap<String, Object>();
			//远程推送的网址
			String serverURL = HttpConnection.serverURL + "/addUserInfo.action";
			//远程绑定角色的网址
			String serverURLRole = HttpConnection.serverURL + "/updateUserRole.action";
			String token = req.getParameter("token");
			String siteCode = req.getParameter("siteCode");
			String userId = DateUtil.createKey();
			map.put("siteCode", siteCode);
			map.put("token", token);
			map.put("userID", userId);
			map.put("username", abProxyUser.getProxyName());
			map.put("mobTel", abProxyUser.getProxyPhone());
			map.put("email", abProxyUser.getProxyEmail());
			map.put("password", "123456");
			try{
				//添加远程
				String httpPOST = HttpConnection.HttpPost(map,serverURL);
//						HttpConnection.HttpGET(map, serverURL);
				JSONObject strToJSONobject = MessageUtils.strToJSONobject(httpPOST);
				//判断远程添加是否成功
				if (strToJSONobject.getString("success").equals("true")){
					// 绑定角色
					String proxy_user_roleId = null;
					if(abProxyUser.getAgencyLevel() ==3){
						//如果是三级代理添加三级代理的菜单
						proxy_user_roleId = Constends.ab_proxy_user3_roleId;
					}else{
						proxy_user_roleId = Constends.ab_proxy_user_roleId;
					}
					Map<String, String> rolePara = new HashMap<String, String>();
					rolePara.put("siteCode", siteCode);//业务中心代码
					rolePara.put("userId", userId);//用户中心代码
					rolePara.put("roleId", proxy_user_roleId);//角色
//					rolePara.put("token", token);
					rolePara.put("userAccount", abProxyUser.getProxyName());//用户账号
					rolePara.put("mobTel", abProxyUser.getProxyPhone());//用户手机号
					rolePara.put("email", abProxyUser.getProxyEmail());//用户邮箱
					rolePara.put("userPassword", "123456");//用户账号
					try{
						String httpPOSTRole = HttpConnection.httpPost(serverURLRole,JSONSerializer.toJSON(rolePara).toString(),token);
//						HttpConnection.HttpGET(rolePara, serverURLRole);
						JSONObject strToJSONobjectRole = MessageUtils.strToJSONobject(httpPOSTRole);
						//判断绑定角色是否成功
						if(strToJSONobjectRole.getString("success").equals("true")){
							abProxyUser.setProxyPassword("123456");
							abProxyUser.setCreateTime(new Date());
							abProxyUser.setUserid(userId);
							abProxyUser.setAppkey(DateUtil.createKey());
							int type=0;
							//添加到数据库中
							try{
								if(abProxyUser.getFatherId() !=null && !abProxyUser.getFatherId().equals("") ){
									int typeNumber = abProxyUserService.updateByPrimaryId(abProxyUser);
									if(typeNumber ==1){
										type = abProxyUserService.insertSelective(abProxyUser);
										if(type !=1){
											m.put("code", 0);
											m.put("message", "添加失败");
											m.put("result", type);
											return JSONSerializer.toJSON(m).toString();
										}
										
									}
								}else{
									type = abProxyUserService.insertSelective(abProxyUser);
									if(type ==1){
										m.put("code", 200);
										m.put("message", "ok");
										m.put("success", "true");
										m.put("result", type);
									}else{
										m.put("code", 0);
										m.put("message", "fail");
										m.put("result", type);
									}
								}
							}catch(Exception e){
								e.printStackTrace();
								TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
								m.put("code", 0);
								m.put("message", "添加异常");
							}
						}
					}catch(Exception e){
						e.printStackTrace();
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
						m.put("code", 0);
						m.put("message", "远程绑定异常");
					}
				}else{
					m.put("code", -1);
					m.put("message", "远程添加失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 
				m.put("code", -1);
				m.put("message", "远程推送异常");
			}
			return JSONSerializer.toJSON(m).toString();
	}
	
  
	
	
	
	/**
	 * 查询一级代理以及联系人姓名
	 *
	 * @return
	 */
	@RequestMapping("/selectProxyUser")
	public String selectProxyUser() {	
		Map<String, Object> m = new HashMap<String,Object>();
		try {
			List<AbProxyUser> userList = abProxyUserService.selectProxyUser();
			m.put("code", 200);
			m.put("result",userList);
		} catch (Exception e) {
			
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "此操作异常");
		}
			
		return JSONSerializer.toJSON(m).toString();
	}
	
}
