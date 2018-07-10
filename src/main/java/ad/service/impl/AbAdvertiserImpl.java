package ad.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ad.bean.AbAdver;
import ad.bean.AbAdvertiser;
import ad.bean.StatusBeen;
import ad.mapper.AbAdverMapper;
import ad.mapper.AbAdvertiserMapper;
import ad.service.IAbAdvertiserService;
import ad.service.IAdvertisingManService;
import ad.util.Constends;
import ad.util.DateUtil;
import ad.util.DesCrypt;
import ad.util.HttpConnection;
import ad.util.IdUtil;
import ad.util.MessageUtils;
import ad.util.sixNum;

@Service
public class AbAdvertiserImpl implements IAbAdvertiserService {
	@Autowired
	private AbAdvertiserMapper abAdvertiserMapper;
	@Autowired
	private IAdvertisingManService iAdvertisingManService;
	@Autowired
	private AbAdverMapper abAdverMapper;

	@Override
	public int saveObject(AbAdvertiser abAdvertiser) {
		int insertSelective = abAdvertiserMapper.insertSelective(abAdvertiser);
		return insertSelective;
	}

	/**
	 * 查询最大id
	 */
	@Override
	public AbAdvertiser selectMaxId() {
		AbAdvertiser maxId = abAdvertiserMapper.selectMaxId();
		return maxId;
	}

	@Override
	public int updateObject(AbAdvertiser abAdvertiser) {
		int updateByPrimaryKeySelective = abAdvertiserMapper.updateByPrimaryKeySelective(abAdvertiser);
		return updateByPrimaryKeySelective;
	}

	/**
	 * 删除广告
	 */
	@Override
	public int deleteObject(AbAdvertiser abAdvertiser) {
		abAdvertiser.setStatus(StatusBeen.DELETE);
		int updateByPrimaryKeySelective = abAdvertiserMapper.updateByPrimaryKeySelective(abAdvertiser);
		return updateByPrimaryKeySelective;
	}

	@Override
	public List<AbAdvertiser> queryList(AbAdvertiser abAdvertiser) {
		abAdvertiser.setPage((abAdvertiser.getPage() - 1) * 10);
		List<AbAdvertiser> selectByCondtionAll = abAdvertiserMapper.selectByCondtionAll(abAdvertiser);

		return selectByCondtionAll;
	}

	/**
	 * 查询广告主,广告id
	 * 
	 * @param record
	 * @return
	 */
	@Override
	public List<AbAdvertiser> queryAdvertiserIdList() {
		List<AbAdvertiser> selectAdvertiserIdList = abAdvertiserMapper.selectAdvertiserIdList();
		return selectAdvertiserIdList;
	}

	/**
	 * 根据主键查询广告主信息
	 */
	@Override
	public AbAdvertiser queryByKek(Integer id) {
		AbAdvertiser been = abAdvertiserMapper.selectByPrimaryKey(id);
		return been;
	}

	/**
	 * 查询userId
	 */
	@Override
	public AbAdvertiser queryByUserId(AbAdvertiser abAdvertiser) {
		AbAdvertiser been = abAdvertiserMapper.queryByUserId(abAdvertiser);
		return been;
	}

	/**
	 * 查询广告主信息
	 */
	@Override
	public AbAdvertiser queryByuserAccount(AbAdvertiser abAdvertiser) {
		AbAdvertiser been = abAdvertiserMapper.queryByuserAccount(abAdvertiser);
		return been;
	}

	@Override
	public long queryTotal() {
		long selecTotal = abAdvertiserMapper.selecTotal();
		return selecTotal;
	}

	@Override
	public Integer getByName(AbAdvertiser record) {
		// TODO Auto-generated method stub
		Integer count = abAdvertiserMapper.getByName(record);
		return count;
	}

	@Override
	public AbAdvertiser queryByuserAccountId(AbAdvertiser abAdvertiser) {
		AbAdvertiser been = abAdvertiserMapper.queryByuserAccountId(abAdvertiser);
		return been;
	}
	
	/**
	 * 查询分页
	 */
	@Override
	public String queryAbAdvertiserList(AbAdvertiser record) {
		try {
			List<AbAdvertiser> queryList = this.queryList(record);
			//查询总条数
			long total = this.queryTotal();
			return MessageUtils.jsonRetrunListTotalMessage(1, "success", queryList, total);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 新增广告主
	 */
	@Override
	public String saveAbAdvertiserObject(AbAdvertiser record, HttpServletRequest req) {
		try {
			// 校验广告主是否存在
			// Integer byName = iAbAdvertiserService.getByName(record);
			// if(byName != 0){
			// return MessageUtils.commonReturnMessage(2, "用户存在请重新添加");
			// }
			// return MessageUtils.commonReturnMessage(1, "successs");
			String token = req.getParameter("token");
			String siteCode = req.getParameter("siteCode");
			AbAdvertiser beenResult = this.queryByuserAccount(record);
			if (beenResult != null && beenResult.getAdvertiserName().equals(record.getAdvertiserName())) {
				return MessageUtils.commonReturnMessage(2, "广告主存在请重新添加");
			}
			AbAdvertiser selectMaxId = this.selectMaxId();
			if (selectMaxId == null) {
				record.setAdvertiserId(IdUtil.setIdNf("GGZ", 0));
			} else {
				record.setAdvertiserId(IdUtil.setIdNf("GGZ", selectMaxId.getId()));
			}
			String serverURLRole = HttpConnection.serverURL + "/updateUserRole.action";
			String userId = DateUtil.createKey();
			String advertiser_roleId = Constends.ab_advertiser_roleId;
			Map<String, String> rolePara = new HashMap<String, String>();
			rolePara.put("userId", userId);
			// rolePara.put("token", token);
			rolePara.put("siteCode", siteCode);
			rolePara.put("roleId", advertiser_roleId);
			rolePara.put("userAccount", record.getAdvertiserPhone());//record.getAdvertiserName()
			rolePara.put("mobTel", record.getAdvertiserPhone());
			rolePara.put("email", record.getAdvertiserEmail());
			String userPassword = sixNum.sixNum();
			rolePara.put("userPassword", DesCrypt.encrypt(userPassword));
			String httpGETRole = HttpConnection.httpPost(serverURLRole, JSON.toJSONString(rolePara), token);
			try {
				JSONObject strToJSONobjectRole = MessageUtils.strToJSONobject(httpGETRole);
				if ("true".equals(strToJSONobjectRole.getString("success"))) {
					record.setStatus(StatusBeen.NORMAL);
					record.setUserid(userId);
					record.setCreateTime(new Date());
					int saveObject = this.saveObject(record);
//					String URL = "https://wedrive.mapbar.com/sendbox/sms/send.do";
//					HttpConnection.HttpGET(rolePara, serverURLRole);
					return MessageUtils.commonReturnMessage(1, "添加成功");
				} else {
					return MessageUtils.commonReturnMessage(0, strToJSONobjectRole.getString("message"));
				}
			} catch (Exception e) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return MessageUtils.commonReturnMessage(0, "fail");
			}
		} catch (Exception e) {
			return MessageUtils.commonReturnMessage(0, "远程添加异常");
		}
		// String serverURLRole = HttpConnection.serverURL +
		// "/updateUserRole.action";
		// String userId = DateUtil.createKey();
		// String advertiser_roleId = Constends.ab_advertiser_roleId;
		// Map<String, String> rolePara = new HashMap<String, String>();
		// rolePara.put("userId", userId);
		// // rolePara.put("token", token);
		// rolePara.put("siteCode", siteCode);
		// rolePara.put("roleId", advertiser_roleId);
		// rolePara.put("userAccount", record.getAdvertiserName());
		// rolePara.put("mobTel", record.getAdvertiserPhone());
		// rolePara.put("email", record.getAdvertiserEmail());
		// rolePara.put("userPassword", "123456");
		// String httpGETRole = HttpConnection.httpPost(serverURLRole,
		// JSON.toJSONString(rolePara), token);
		// JSONObject strToJSONobjectRole =
		// MessageUtils.strToJSONobject(httpGETRole);
		//
		// if ("true".equals(strToJSONobjectRole.getString("success"))) {
		// record.setStatus(StatusBeen.NORMAL);
		// record.setUserid(userId);
		// record.setCreateTime(new Date());
		// int saveObject = iAbAdvertiserService.saveObject(record);
		// return MessageUtils.commonReturnMessage(saveObject, "success");
		//
		// }

		// Map map = new HashMap();
		// String userId = DateUtil.createKey();
		// map.put("siteCode", siteCode);
		// map.put("token", token);
		// map.put("userID", userId);
		// map.put("username", record.getAdvertiserName());
		// map.put("mobTel", record.getAdvertiserPhone());
		// map.put("email", record.getAdvertiserEmail());
		// map.put("password", "123456");
		//// String serverURL = HttpConnection.serverURL +
		// "/addUserInfo.action";
		// String serverURLRole = HttpConnection.serverURL +
		// "/updateUserRole.action";
		// try {
		// String httpGET = HttpConnection.HttpPost(map, serverURL);
		// JSONObject strToJSONobject = MessageUtils.strToJSONobject(httpGET);
		// if (strToJSONobject.getString("success").equals("true")) {
		// record.setUserid(userId);
		// // 绑定角色
		// String advertiser_roleId = Constends.ab_advertiser_roleId;
		// Map<String, String> rolePara = new HashMap<String, String>();
		// rolePara.put("userId", userId);
		// // rolePara.put("token", token);
		// rolePara.put("siteCode", siteCode);
		// rolePara.put("roleId", advertiser_roleId);
		// rolePara.put("userAccount", record.getAdvertiserName());
		// rolePara.put("mobTel", record.getAdvertiserPhone());
		// rolePara.put("email", record.getAdvertiserEmail());
		// rolePara.put("userPassword", "123456");
		// String httpGETRole = HttpConnection.httpPost(serverURLRole,
		// JSON.toJSONString(rolePara), token);
		// JSONObject strToJSONobjectRole =
		// MessageUtils.strToJSONobject(httpGETRole);
		// try {
		// if ("true".equals(strToJSONobjectRole.getString("success"))) {
		// record.setStatus(StatusBeen.NORMAL);
		// record.setUserid(userId);
		// record.setCreateTime(new Date());
		// int saveObject = iAbAdvertiserService.saveObject(record);
		// return MessageUtils.commonReturnMessage(saveObject, "success");
		// } else {
		// return MessageUtils.commonReturnMessage(0, "远程添加失败");
		// }
		// } catch (Exception e) {
		// TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
		// return MessageUtils.commonReturnMessage(0, "fail");
		// }
		// } else {
		// TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
		// return MessageUtils.commonReturnMessage(0, "远程添加用户失败");
		// }
		// } catch (Exception e) {
		// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		// return MessageUtils.commonReturnMessage(0, "远程添加异常");
		// }
	}
	
	/**
	 * 修改广告主
	 */
	@Override
	public String updateAbAdvertiserObject(AbAdvertiser record, HttpServletRequest req) {
		try {
			// 通过id 查询广告主
			// AbAdvertiser beenResultId =
			// iAbAdvertiserService.queryByuserAccountId(record);
			AbAdvertiser been = this.queryByKek(record.getId());
			if (been.getAdvertiserName().equals(record.getAdvertiserName())) {
				// 本条记录修改
				// int updateObject = iAbAdvertiserService.updateObject(record);
				// return MessageUtils.commonReturnMessage(updateObject,
				// "success");
				Map<String, String> map = new HashMap<String, String>();
				String token = req.getParameter("token");
				String siteCode = req.getParameter("siteCode");
				map.put("siteCode", siteCode);
				map.put("userAccount", record.getAdvertiserName());
				map.put("token", token);
				map.put("userID", been.getUserid());
				map.put("mobTel", record.getAdvertiserPhone());
				map.put("email", record.getAdvertiserEmail());
				String serverURL = HttpConnection.serverURL + "/updateUserInfo.action";
				String httpGET = HttpConnection.HttpPost(map, serverURL);
				JSONObject strToJSONobject = MessageUtils.strToJSONobject(httpGET);
				if ("true".equals(strToJSONobject.getString("success"))) {
					try {
						int updateObject = this.updateObject(record);
						return MessageUtils.commonReturnMessage(updateObject, "修改成功");
					} catch (Exception e) {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return MessageUtils.commonReturnMessage(0, "修改失败");
					}
				} else {
					return MessageUtils.commonReturnMessage(0, "fail");
				}

			} else {
				AbAdvertiser beenResult = this.queryByuserAccount(record);
				if (beenResult != null && beenResult.getAdvertiserName().equals(record.getAdvertiserName())) {
					return MessageUtils.commonReturnMessage(2, "广告主已经存在请重新添加");
				}
				Map<String, String> map = new HashMap<String, String>();
				String token = req.getParameter("token");
				String siteCode = req.getParameter("siteCode");
				map.put("siteCode", siteCode);
				map.put("userAccount", record.getAdvertiserName());
				map.put("token", token);
				map.put("userID", been.getUserid());
				map.put("mobTel", record.getAdvertiserPhone());
				map.put("email", record.getAdvertiserEmail());
				String serverURL = HttpConnection.serverURL + "/updateUserInfo.action";
				String httpGET = HttpConnection.HttpPost(map, serverURL);
				JSONObject strToJSONobject = MessageUtils.strToJSONobject(httpGET);
				if ("true".equals(strToJSONobject.getString("success"))) {
					try {
						int updateObject = this.updateObject(record);
						return MessageUtils.commonReturnMessage(updateObject, "修改成功");
					} catch (Exception e) {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return MessageUtils.commonReturnMessage(0, "修改失败");
					}
				} else {
					return MessageUtils.commonReturnMessage(0, "fail");
				}
			}

			// AbAdvertiser been =
			// iAbAdvertiserService.queryByKek(record.getId());
			// // int updateObject = iAbAdvertiserService.updateObject(record);
			// // return MessageUtils.commonReturnMessage(updateObject,
			// "success");
			// Map<String, String> map = new HashMap<String, String>();
			// String token = req.getParameter("token");
			// String siteCode = req.getParameter("siteCode");
			// map.put("siteCode", siteCode);
			// map.put("userAccount", record.getAdvertiserName());
			// map.put("token", token);
			// map.put("userID", been.getUserid());
			// map.put("mobTel", record.getAdvertiserPhone());
			// map.put("email", record.getAdvertiserEmail());
			// String serverURL = HttpConnection.serverURL +
			// "/updateUserInfo.action";
			// String httpGET = HttpConnection.HttpPost(map, serverURL);
			// JSONObject strToJSONobject =
			// MessageUtils.strToJSONobject(httpGET);
			// if ("true".equals(strToJSONobject.getString("success"))) {
			// try {
			// int updateObject = iAbAdvertiserService.updateObject(record);
			// return MessageUtils.commonReturnMessage(updateObject, "修改成功");
			// } catch (Exception e) {
			// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			// return MessageUtils.commonReturnMessage(0, "修改失败");
			// }
			// } else {
			// return MessageUtils.commonReturnMessage(0, "fail");
			// }
		} catch (Exception e) {
			return MessageUtils.commonReturnMessage(0, "远程添加异常");
		}
	}
	
	/**
	 * 删除广告主
	 */
	@Override
	public String deleteAbAdvertiserObject(AbAdvertiser record) {
		try {
			String advertiserId = record.getAdvertiserId();
			// 判断广告主，是否存在广告
			AbAdver been = new AbAdver();
			been.setAdvertiserId(advertiserId);
			if (record != null && advertiserId != null) {
				int selectIsGetAdver = abAdverMapper.selectIsGetAdver(been);
				if (selectIsGetAdver > 0) {
					return MessageUtils.commonReturnMessage(2, "请先删除广告主名下的广告，在删除广告主");
				}
				int updateObject = this.deleteObject(record);
				return MessageUtils.commonReturnMessage(updateObject, "删除成功");
			}
			return MessageUtils.commonReturnMessage(0, "删除失败");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "删除失败");
		}
	}
}
