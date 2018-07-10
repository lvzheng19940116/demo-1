package ad.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSONObject;
import ad.bean.AbBankCard;
import ad.bean.AbBillingCycle;
import ad.bean.AbProxyUser;
import ad.bean.AbReveOrder;
import ad.mapper.AbBankCardMapper;
import ad.mapper.AbBillingCycleMapper;
import ad.mapper.AbBillingInfoMapper;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.AbReveOrderMapper;
import ad.mapper.TablesMapper;
import ad.service.IAbProxyUserService;
import ad.util.Constends;
import ad.util.DateUtil;
import ad.util.DesCrypt;
import ad.util.Excel2007;
import ad.util.GetClassPath;
import ad.util.HttpConnection;
import ad.util.MessageUtils;
import ad.util.sixNum;

import net.sf.json.JSONSerializer;

/**
 * 代理用户相关的实现类
 * 
 * @author Administrator
 *
 */
@Service
public class AbProxyUserServiceImpl implements IAbProxyUserService {

	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	@Autowired
	AbBankCardMapper abBankCardMapper;
	@Autowired
	AbBillingCycleMapper abBillingCycleMapper;
	@Autowired
	AbReveOrderMapper abReveOrderMapper;
	@Autowired
	AbBillingInfoMapper abBillingInfoMapper;
	@Autowired
	TablesMapper ablesMapper;

	/**
	 * 按着主键查询的方法
	 */
	@Override
	public AbProxyUser queryById(int id) {
		// 按着主键查询
		AbProxyUser selectByPrimaryKey = abProxyUserMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	/**
	 * 校验用户账号是否存在
	 * @param proxyName
	 * @param req
	 * @return
	 */
	@Override
	public AbProxyUser queryByProxyName(String proxyName) {
		AbProxyUser abProxyUser = abProxyUserMapper.queryByProxyName(proxyName);
		return abProxyUser;
	}

	/**
	 * 按着手机号码查询
	 */
	@Override
	public AbProxyUser queryByProxyPhone(String proxyPhone) {
		// 按着手机号码查询
		AbProxyUser abProxyUser = abProxyUserMapper.queryByProxyPhone(proxyPhone);
		return abProxyUser;
	}

	@Override
	public List<AbProxyUser> exportQueryProxyList(AbProxyUser abProxyUser) {
		// 按着条件查询
		List<AbProxyUser> abProxyUserList = abProxyUserMapper.exportQueryProxyList(abProxyUser);
		return abProxyUserList;
	}

	/**
	 * 按着邮箱查询
	 */
	@Override
	public AbProxyUser queryByProxyEmail(String proxyEmail) {
		//按着邮箱查询
		AbProxyUser abProxyUser = abProxyUserMapper.queryByProxyEmail(proxyEmail);
		return abProxyUser;
	}

	/**
	 * 查询一共多少条数据的方法
	 */
	@Override
	public AbProxyUser selectNum() {
		// 查询一共多少条数据的方法
		AbProxyUser paneNum = abProxyUserMapper.selectNum();
		return paneNum;
	}

	/**
	 * 条件查询的方法
	 */
	@Override
	public List<AbProxyUser> queryProxyList(AbProxyUser abProxyUser) {
		// 条件查询
		List<AbProxyUser> abProxyUserList = abProxyUserMapper.queryProxyList(abProxyUser);
		return abProxyUserList;
	}

	/**
	 * 初始加载代理用户全部数据
	 */
	@Override
	public String getAllUser(AbProxyUser abProxyUser) {
		Map<String, Object> m = new HashMap<String, Object>();
		// 时间格式化
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 处理分页
			int page = abProxyUser.getPage();
			abProxyUser.setPage((page - 1) * 10);
			// 查询所有的未删除的代理
			List<AbProxyUser> abProxyUserList = abProxyUserMapper.select(abProxyUser);
			for (AbProxyUser u : abProxyUserList) {
				if (u.getCreateTime() != null) {
					// 处理成标准的时间
					u.setDate(time.format(u.getCreateTime()));
				}
				if (u.getFatherId() != null && !u.getFatherId().equals("")) {
					// 查询上线代理ID，上线名称，上线手机号
					AbProxyUser queryById = this.queryById(u.getFatherId());
					// 上线代理ID
					u.setUpperId(queryById.getId() + "");
					// 上线名称
					u.setUpperName(queryById.getProxyUserName());
					// 上线手机号
					u.setUpperPhone(queryById.getProxyPhone());
				}
			}
			// 查询一共多少条数据
			AbProxyUser totalNumber = this.selectNum();
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
			m.put("abProxyUserList", abProxyUserList);
			m.put("total", totalNumber == null ? 0 : totalNumber.getTotalNumber());// 供前台计算所有的页数用的
		} catch (Exception e) {
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}

	/**
	 * 按着主键查询出来的代理用户(代理详情接口)
	 * @param id
	 * @return
	 */
	@Override
	public String getProxyInfoById(Integer id) {
		Map<String, Object> m = new HashMap<String, Object>();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat time1 = new SimpleDateFormat("yyyy-");
		SimpleDateFormat time2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time3 = new SimpleDateFormat("yyyy");
		try {
			//按着主键查询出详细的信息
			AbProxyUser queryById = this.queryById(id);
			//根据代理ID查询出银行卡信息
			AbBankCard abBankCard = abBankCardMapper.selectByProxyId(id);
			// 查看银行卡表中是否存在该条数据
			if (abBankCard != null) {
				// 存在存放条数1
				queryById.setCardNumber(1);
			} else {
				// 不存在存放条数0
				queryById.setCardNumber(0);
			}
			// 当前收益，在累计周期内的钱
			Float currentIncome = 0f;
			// 查询计算周期
			AbBillingCycle abBillingCycle = abBillingCycleMapper.select();
			if (abBillingCycle !=null && abBillingCycle.getSettlementDate1() != null && !("").equals(abBillingCycle.getSettlementDate1())) {
				AbReveOrder abReveOrder = new AbReveOrder();
				abReveOrder.setProxyId(id);
				// 拼的当前年
				String newYear = time1.format(new Date());
				// 当前时间返回的毫秒数
				long log0 = DateUtil.getDateLong(time2.format(new Date()), "yyyy-MM-dd");
				// 分解结算日的第一个周期
				String settlementDate1Time = abBillingCycle.getSettlementDate1().replaceAll("月", "-");
				String settlementDate1Time1 = settlementDate1Time.replaceAll("日", "");
				long log1 = DateUtil.getDateLong(newYear + settlementDate1Time1, "yyyy-MM-dd");
				// 分解结算日的第二个周期
				String settlementDate2Time = abBillingCycle.getSettlementDate2().replaceAll("月", "-");
				String settlementDate2Time1 = settlementDate2Time.replaceAll("日", "");
				long log2 = DateUtil.getDateLong(newYear + settlementDate2Time1, "yyyy-MM-dd");
				// 分解结算日的第三个周期
				String settlementDate3Time = abBillingCycle.getSettlementDate3().replaceAll("月", "-");
				String settlementDate3Time1 = settlementDate3Time.replaceAll("日", "");
				long log3 = DateUtil.getDateLong(newYear + settlementDate3Time1, "yyyy-MM-dd");
				// 分解结算日的第四个周期
				String settlementDate4Time = abBillingCycle.getSettlementDate4().replaceAll("月", "-");
				String settlementDate4Time1 = settlementDate4Time.replaceAll("日", "");
				long log4 = DateUtil.getDateLong(newYear + settlementDate4Time1, "yyyy-MM-dd");
				// 判断当前时间在哪个结算周期内
				if (log0 >= log1 && log0 < log2) {
					abReveOrder.setTime1(newYear + settlementDate1Time1);
					abReveOrder.setTime2(newYear + settlementDate2Time1);
				} else if (log0 >= log2 && log0 < log3) {
					abReveOrder.setTime1(newYear + settlementDate2Time1);
					abReveOrder.setTime2(newYear + settlementDate3Time1);
				} else if (log0 >= log2 && log0 < log4) {
					abReveOrder.setTime1(newYear + settlementDate3Time1);
					abReveOrder.setTime2(newYear + settlementDate4Time1);
				} else {
					Integer year = Integer.valueOf(time3.format(new Date())) - 1;
					abReveOrder.setTime1(year + "-" + settlementDate4Time1);
					abReveOrder.setTime2(newYear + settlementDate1Time1);
				}
				//查询当前收益
				currentIncome = abReveOrderMapper.selectCurrentIncome(abReveOrder);
			}

			// 当前收益
			queryById.setCurrentIncome(currentIncome);
			// 累计总收益(计算的是所有的已经结过钱的数据，即：在结算数据表存在的数据)
			Float cumulativeIncome = abBillingInfoMapper.setCumulativeIncome(id);
			queryById.setCumulativeIncome(cumulativeIncome);
			// 上线ID存在时查询出上线名称以及手机号
			if (queryById.getFatherId() != null && !queryById.getFatherId().equals("")) {
				AbProxyUser query = this.queryById(queryById.getFatherId());
				queryById.setUpperId(queryById.getId() + "");
				queryById.setUpperName(query.getProxyUserName());
				queryById.setUpperPhone(query.getProxyPhone());
			}
			// 时间日期的格式化
			if (queryById.getCreateTime() != null) {
				queryById.setDate(time.format(queryById.getCreateTime()));
			}
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
			m.put("abProxyUser", queryById);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}

	/**
	 * 代理用户按着条件查询接口
	 * 
	 * @param abProxyUser
	 * @return
	 */
	@Override
	public String getProxyInfo(AbProxyUser abProxyUser) {
		Map<String, Object> m = new HashMap<String, Object>();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 分页查询的操作，页码的改变
			int page = abProxyUser.getPage();
			abProxyUser.setPage((page - 1) * 10);
			// 条件查询的方法
			List<AbProxyUser> abProxyUserList = this.queryProxyList(abProxyUser);
			for (AbProxyUser u : abProxyUserList) {
				if (u.getCreateTime() != null) {
					// 合适化时间
					u.setDate(time.format(u.getCreateTime()));
				}
				// 判断上线ID是否为空
				if (u.getFatherId() != null && !u.getFatherId().equals("")) {
					// 查询上线信息
					AbProxyUser queryById = this.queryById(u.getFatherId());
					// 上线ID
					u.setUpperId(queryById.getId() + "");
					// 上线昵称
					u.setUpperName(queryById.getProxyUserName());
					// 上线手机号
					u.setUpperPhone(queryById.getProxyPhone());
				}
			}
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
			m.put("abProxyUserList", abProxyUserList);
			m.put("total", abProxyUserList.size() == 0 ? 0 : abProxyUserList.get(0).getTotalNumber());// 条数
		} catch (Exception e) {
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}

	/**
	 * 下线列表接口
	 * @param abProxyUser
	 */
	@Override
	public String queryDownProxyList(AbProxyUser abProxyUser) {
		Map<String, Object> m = new HashMap<String, Object>();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 分页查询中页码的设置
			int page = abProxyUser.getPage();
			abProxyUser.setPage((page - 1) * 10);
			//获取下线列表
			List<AbProxyUser> abProxyUserList = abProxyUserMapper.queryDownProxyList(abProxyUser);
			for (AbProxyUser us : abProxyUserList) {
				if (us.getCreateTime() != null) {
					us.setDate(time.format(us.getCreateTime()));
				}
			}
			m.put("code", 200);
			m.put("message", "ok");
			m.put("success", "true");
			m.put("abProxyUser", abProxyUserList);
			m.put("total", abProxyUserList.size() == 0 ? 0 : abProxyUserList.get(0).getTotalNumber());
		} catch (Exception e) {
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}

	public Integer selectMax() {
		Integer maxId = ablesMapper.selectMaxId();
		return maxId;
	}

	/**
	 * 添加代理用户
	 * 
	 * @param abProxyUser
	 * @param serverURLRole
	 * @param token
	 * @param siteCode
	 * @return
	 */
	@Override
	public String addProxyInfo(String serverURLRole, AbProxyUser abProxyUser, String token, String siteCode) {
		/**
		 * 该方法的相关业务逻辑：
		 * 1添加的用户需要推到权限中心去
		 * 2判断添加的用户是几级的代理用户
		 * 3根据不同的权限分配不同权限的菜单
		 * 4是否存在上线ID，存在，操作改上线的下线的人数
		 */
		Map<String, Object> m = new HashMap<String, Object>();
		String userId = DateUtil.createKey();
		try {
			// 绑定角色
			String proxy_user_roleId = null;
			if (abProxyUser.getAgencyLevel() == 3) {
				// 如果是三级代理添加三级代理的菜单
				proxy_user_roleId = Constends.ab_proxy_user3_roleId;
			} else {
				proxy_user_roleId = Constends.ab_proxy_user_roleId;
			}
			proxy_user_roleId = Constends.ab_proxy_user_roleId;
			Map<String, String> rolePara = new HashMap<String, String>();
			rolePara.put("siteCode", siteCode);// 业务中心代码
			rolePara.put("userId", userId);// 用户中心代码
			rolePara.put("roleId", proxy_user_roleId);// 角色
			// rolePara.put("token", token);
			rolePara.put("userAccount", abProxyUser.getProxyPhone());// 用户账号
																		// abProxyUser.getProxyName()
			rolePara.put("mobTel", abProxyUser.getProxyPhone());// 用户手机号
			rolePara.put("email", abProxyUser.getProxyEmail());// 用户邮箱
			String userPassword = sixNum.sixNum();
			rolePara.put("userPassword", DesCrypt.encrypt(userPassword));
			// rolePara.put("userPassword", DesCrypt.encrypt("123456"));//用户账号
			String httpPOSTRole = HttpConnection.httpPost(serverURLRole, JSONSerializer.toJSON(rolePara).toString(),
					token);
			// HttpConnection.HttpGET(rolePara, serverURLRole);
			JSONObject strToJSONobjectRole = MessageUtils.strToJSONobject(httpPOSTRole);
			// 判断绑定角色是否成功
			if (strToJSONobjectRole.getString("success").equals("true")) {
				abProxyUser.setProxyPassword("123456");
				abProxyUser.setCreateTime(new Date());
				abProxyUser.setAppkey(DateUtil.createKey() + this.selectMax());
				abProxyUser.setUserid(userId);
				int type = 0;
				// 添加到数据库中
				try {
					if (abProxyUser.getFatherId() != null && !abProxyUser.getFatherId().equals("")) {
						//有上线ID
						//增加该上线ID的下线代理人数
						int typeNumber = this.updateByPrimaryId(abProxyUser);
						if (typeNumber == 1) {
							type = this.insertSelective(abProxyUser);
							if (type == 1) {
								m.put("code", 200);
								m.put("message", "添加成功");
								m.put("result", type);
							} else {
								m.put("code", 0);
								m.put("message", "添加失败");
								m.put("result", type);
							}
						}
					} else {
						//无上线ID
						type = this.insertSelective(abProxyUser);
						if (type == 1) {
							m.put("code", 200);
							m.put("message", "ok");
							m.put("success", "true");
							m.put("result", type);
						} else {
							m.put("code", 0);
							m.put("message", "fail");
							m.put("result", type);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					m.put("code", 0);
					m.put("message", "添加异常");
				}
			} else {
				m.put("code", -1);
				m.put("message", "远程推送异常");
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.put("code", 0);
			m.put("message", "fail");
		}
		return JSONSerializer.toJSON(m).toString();
	}

	/**
	 * 修改代理用户
	 * @param serverURL
	 * @param abProxyUser
	 * @param token
	 * @param siteCode
	 * @return
	 */
	@Transactional
	@Override
	public String updateProxyInfo(String serverURL, AbProxyUser abProxyUser, String token, String siteCode) {
		/**
		 * 该方法的处理的页面逻辑
		 * 1：修改权限中心中的相关信息
		 * 2：修改本地数据库的相关信息
		 * 3：如果修改了上线ID：需要把原先的上线那个下线人数-1。新的上线的下线人数+1；
		 */
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Map<String, String> rolePara = new HashMap<String, String>();
			rolePara.put("siteCode", siteCode);// 业务中心代码
			rolePara.put("userID", abProxyUser.getUserid());// 用户中心代码
			rolePara.put("token", token);// 权限中心验证
			rolePara.put("mobTel", abProxyUser.getProxyPhone());// 用户手机号
			rolePara.put("email", abProxyUser.getProxyEmail());// 用户邮箱
			String httpPOST = HttpConnection.HttpPost(rolePara, serverURL);//请求权限中心
			JSONObject strToJSONobject = MessageUtils.strToJSONobject(httpPOST);
			// 判断是否修改成功
			if (("true").equals(strToJSONobject.getString("success"))) {
				try {
					if (abProxyUser.getFatherId() == 0) {
						abProxyUser.setFatherId(null);
					}
					//根据代理ID获取数据库中的数据
					AbProxyUser queryById = this.queryById(abProxyUser.getId());
					//判断是否修改了上线ID
					if (queryById.getFatherId() == abProxyUser.getFatherId()) {
						//没有修改上线ID，直接把修改的信息传递给数据库
						int type = this.updateByPrimaryKeySelective(abProxyUser);
						if (type == 1) {
							m.put("result", 1);
							m.put("codde", 200);
							m.put("message", "修改成功");
							m.put("success", "true");
						} else {
							m.put("result", 0);
							m.put("code", 0);
							m.put("message", "修改失败");
						}
					} else {
						//修改了上线代理ID
						int typeNumber = this.updateByPrimaryId(abProxyUser);
						if (typeNumber == 1) {
							//修改下线人数信息
							int typeOfNumber = this.updateByPrimaryID(queryById);
							if (typeOfNumber == 1) {
								//修改后的信息
								int type = this.updateByPrimaryKeySelective(abProxyUser);
								if (type == 1) {
									m.put("result", 1);
									m.put("code", 200);
									m.put("message", "修改成功");
									m.put("success", "true");
								} else {
									m.put("result", 0);
									m.put("code", 0);
									m.put("message", "修改失败");
								}
							}
						} else {
							m.put("result", 0);
							m.put("code", 0);
							m.put("message", "修改失败");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					m.put("code", 0);
					m.put("message", "数据库链接异常，请联系管理员");
				}
			} else {
				m.put("code", -1);
				m.put("message", strToJSONobject.getString("message"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			m.put("code", 0);
			m.put("message", "远程网路链接异常，请稍后再试！");
		}
		return JSONSerializer.toJSON(m).toString();
	}

	/**
	 * 删除代理用户
	 * 
	 * @param ids
	 * @return
	 */
	@Override
	public String deleteProxy(String ids) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			// 可以批量删除
			List<String> idList = Arrays.asList(ids.split(","));
			int type = 0;
			for (int i = 0; i < idList.size(); i++) {
				// 判断如果存在下级代理就不可以删除
				AbProxyUser queryById = this.queryById(Integer.valueOf(idList.get(i)));
				if (queryById.getOfflineNumber() != 0) {
					m.put("result", "fail");
					return JSONSerializer.toJSON(m).toString();
				}
			}
			for (int i = 0; i < idList.size(); i++) {
				// 删除，逻辑删除
				int type1 = this.deleteByPrimaryId(idList.get(i));
				type = type + type1;
			}
			// 判断批量删除的时候是否全部删除
			if (type == idList.size()) {
				m.put("result", 1);
				m.put("code", 200);
				m.put("message", "ok");
				m.put("success", "true");
			} else {
				m.put("result", 0);
				m.put("code", 0);
				m.put("message", "fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			m.put("code", 0);
			m.put("message", "远程网路链接异常，请稍后再试！");
		}
		return JSONSerializer.toJSON(m).toString();
	}

	/**
	 * 按着条件导出(导出excel)
	 * 
	 * @param response
	 * @param abProxyUser
	 * @throws FileNotFoundException
	 */
	@Override
	public void exportProxyList(HttpServletResponse response, AbProxyUser abProxyUser) throws FileNotFoundException {
		// 获取下载地址
		String downPath = GetClassPath.ClassPath();
		// 查询导出的数据
		List<AbProxyUser> abProxyUserList = this.exportQueryProxyList(abProxyUser);
		for (AbProxyUser u : abProxyUserList) {
			if (u.getFatherId() != null && !u.getFatherId().equals("")) {
				AbProxyUser queryById = this.queryById(u.getFatherId());
				u.setUpperName(queryById.getProxyUserName());
			}
		}
		String title = "代理用户信息表";
		List<String> titleList = new ArrayList<String>();
		List<String> columnList = new ArrayList<String>();
		List<Map> dataList = new ArrayList();
		titleList.add("序号");
		titleList.add("用户ID");
		titleList.add("手机号");
		titleList.add("用户昵称");
		titleList.add("注册时间");
		titleList.add("上线ID");
		titleList.add("上线名称");
		titleList.add("与上线分佣");
		titleList.add("下线人数");
		titleList.add("销售渠道ID");
		columnList.add("index");
		columnList.add("id");
		columnList.add("proxyPhone");
		columnList.add("proxyName");
		columnList.add("createTime");
		columnList.add("fatherId");
		columnList.add("upperName");
		columnList.add("distributionRatio");
		columnList.add("offlineNumber");
		columnList.add("销售渠道ID");
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		if (abProxyUserList != null) {
			for (int i = 0; i < abProxyUserList.size(); i++) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("index", 1 + i);
				m.put("id", abProxyUserList.get(i).getId());
				m.put("proxyPhone", abProxyUserList.get(i).getProxyPhone());
				m.put("proxyName", abProxyUserList.get(i).getProxyUserName());
				m.put("createTime", abProxyUserList.get(i).getCreateTime() == null ? null
						: time.format(abProxyUserList.get(i).getCreateTime()));
				m.put("fatherId",
						abProxyUserList.get(i).getFatherId() == null ? "" : abProxyUserList.get(i).getFatherId());
				m.put("upperName",
						abProxyUserList.get(i).getUpperName() == null ? "" : abProxyUserList.get(i).getUpperName());
				m.put("distributionRatio", abProxyUserList.get(i).getDistributionRatio());
				m.put("offlineNumber", abProxyUserList.get(i).getOfflineNumber());
				m.put("销售渠道ID", abProxyUserList.get(i).getAppkey() == null ? "" : abProxyUserList.get(i).getAppkey());
				dataList.add(m);
			}
		}
		Excel2007 excel = new Excel2007();
		// 下载到服务器上的名字
		String fttpName = DateUtil.createKey() + ".xlsx";
		try {
			excel.openWorkbook(downPath + "\\" + fttpName, title, titleList.size() - 1);
			excel.addTable(titleList, columnList, dataList);
			excel.lineNum += 2;
			excel.closedObject();
			// 文件下载
			download(response, "代理信息表.xlsx", downPath, fttpName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 删除服务器上的刚才下载时的文件
			// 输入要删除的文件位置
			File f = new File(downPath + "\\" + fttpName);
			if (f.exists()) {
				f.delete();
			}
		}
	}

	protected void download(HttpServletResponse response, String filename, String downPath, String fttpName) {
		// 将数据写入模版文件
		// String filename = writeFile(taskNo);
		// 文件下载SysStatic.WEB_REAL_PATH).append("WEB-INF\\download\\"
		StringBuilder webPath = new StringBuilder();
		webPath.append(downPath);
		try {
			// 文件在服务器中的路径
			String fullFileName = webPath + "\\" + fttpName;
			System.out.println(fullFileName);
			File outfile = new File(fullFileName);
			// 设置文件MIME类型
			response.setContentType("application/octet-stream");
			// response.addHeader("Content-Disposition", "attachment;filename="
			// + new String(filename.replaceAll(" ",
			// "").getBytes("utf-8"),"iso8859-1"));
			// 设置Content-Disposition
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
			response.addHeader("Content-Length", "" + outfile.length()); // 返回头
																			// 文件大小
			// 读取目标文件，通过response将目标文件写到客户端
			// 获取目标文件的绝对路径
			InputStream in = new FileInputStream(fullFileName);
			OutputStream out = response.getOutputStream();
			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		} catch (SocketException e) {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AbProxyUser> queryUpperList(int agencyLevel) {
		List<AbProxyUser> abProxyUser = abProxyUserMapper.queryUpperList(agencyLevel);
		return abProxyUser;
	}

	@Override
	public Integer insertSelective(AbProxyUser abProxyUser) {
		Integer type = abProxyUserMapper.insertSelective(abProxyUser);
		return type;
	}

	@Override
	public Integer updateByPrimaryId(AbProxyUser abProxyUser) {
		//修改下线人数信息增加
		Integer type = abProxyUserMapper.updateByPrimaryId(abProxyUser);
		return type;
	}

	/**
	 * 修改下线人数信息
	 */
	@Override
	public Integer updateByPrimaryID(AbProxyUser abProxyUser) {
		//修改下线人数信息
		Integer type = abProxyUserMapper.updateByPrimaryID(abProxyUser);
		return type;
	}

	/**
	 * 代理修改
	 */
	@Override
	public Integer updateByPrimaryKeySelective(AbProxyUser abProxyUser) {
		Integer type = abProxyUserMapper.updateByPrimaryKeySelective(abProxyUser);
		return type;
	}

	// 删除代理方法
	@Override
	public Integer deleteByPrimaryId(String id) {
		// 逻辑删除
		Integer type = abProxyUserMapper.deleteByPrimaryId(id);
		return type;
	}

	@Override
	public List<AbProxyUser> queryRevenueChartsList(String time0, String time1) {
		List<AbProxyUser> abProxyUserList = abProxyUserMapper.queryRevenueChartsList(time0, time1);
		return abProxyUserList;
	}

	@Override
	public Integer getNewAddProxy(String yesterday) {
		Integer newAddProxy = abProxyUserMapper.getNewAddProxy(yesterday);
		return newAddProxy;
	}

	@Override
	public List<AbProxyUser> selectFirstlevel(AbProxyUser abProxyUser) {
		abProxyUser.setPage((abProxyUser.getPage() - 1) * 10);
		List<AbProxyUser> selectFirstlevel = abProxyUserMapper.selectFirstlevel(abProxyUser);
		return selectFirstlevel;
	}

	@Override
	public long queryTotal() {
		long queryTotal = abProxyUserMapper.queryTotal();
		return queryTotal;
	}

	/**
	 * 查询代理
	 * @return
	 */
	@Override
	public List<AbProxyUser> selectAgentLevelFirst() {
		List<AbProxyUser> list = abProxyUserMapper.selectAgentLevelFirst();
		return list;
	}

	/**
	 * 查询代理
	 * @return
	 */
	@Override
	public List<AbProxyUser> selectAgentLevelTwo() {
		List<AbProxyUser> list = abProxyUserMapper.selectAgentLevelTwo();
		return list;
	}

	/**
	 * 查询代理
	 * @return
	 */
	@Override
	public List<AbProxyUser> selectAgentLevelThree() {
		List<AbProxyUser> list = abProxyUserMapper.selectAgentLevelThree();
		return list;
	}

	/**
	 * 根据主键查询广告信息
	 */
	@Override
	public List<AbProxyUser> selectByInId(String id) {
		List<AbProxyUser> list = abProxyUserMapper.selectByInId(id);
		return list;
	}

	/**
	 * 查询所有广告主
	 */
	@Override
	public List<AbProxyUser> queryAllProxyUser() {
		List<AbProxyUser> list = abProxyUserMapper.queryAllProxyUser();
		return list;
	}

	@Override
	public Integer selectProxyUserByName(String name) {
		int i = abProxyUserMapper.selectAbProxyUserByProxyName(name);
		return i;
	}

	/**
	 * 查询代理
	 * @return
	 */
	@Override
	public List<AbProxyUser> getMenu() {
		List<AbProxyUser> list = abProxyUserMapper.selectMenu();
		return list;
	}

	@Override
	public List<AbProxyUser> selectAgenstByCy(Integer cy) {
		List<AbProxyUser> list = abProxyUserMapper.selectAgentByCy(cy);
		return list;
	}

	/**
	 * 查询代理
	 * @param aProxyUser
	 */
	@Override
	public List<AbProxyUser> queryAngeList(AbProxyUser aProxyUser) {
		AbProxyUser ab = abProxyUserMapper.queryAnge(aProxyUser);
		List<AbProxyUser> list = abProxyUserMapper.queryAngeList(ab);
		List<AbProxyUser> reslutlist = new ArrayList<AbProxyUser>();
		for (AbProxyUser ab1 : list) {
			reslutlist.add(ab1);
			List<AbProxyUser> allList = abProxyUserMapper.queryAngeList(ab1);
			// AbProxyUser ab2 = abProxyUserMapper.selectAnge(ab1);
			reslutlist.addAll(allList);
		}
		reslutlist.add(ab);
		return reslutlist;
	}

	@Override
	public List<AbProxyUser> selectProxyUser() {
		return abProxyUserMapper.selectProxyUser();
	}
}
