package ad.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ad.bean.AbAdver;
import ad.bean.AbAdvertProxyAssociation;
import ad.bean.AbAdvertiser;
import ad.bean.AbProxyUser;
import ad.bean.StatusBeen;
import ad.mapper.AbAdverMapper;
import ad.mapper.AbAdvertProxyAssociationMapper;
import ad.mapper.AbAdvertiserMapper;
import ad.mapper.AbProxyUserMapper;
import ad.mapper.TablesMapper;
import ad.service.IAbAdvertProxyAssociationService;
import ad.service.IAbAdvertiserService;
import ad.service.IAbProxyUserService;
import ad.service.IAdvertisingManService;
import ad.util.DateUtil;
import ad.util.IdUtil;
import ad.util.MessageUtils;

import net.sf.json.JSONSerializer;

@Service
public class AdvertisingManServiceImpl implements IAdvertisingManService {
	@Autowired
	private AbAdverMapper abAdverMapper;
	@Autowired
	private IAbAdvertiserService iAbAdvertiserService;
	@Autowired
	private IAbAdvertProxyAssociationService iiAbAdvertProxyAssociationService;
	@Autowired
	private IAbProxyUserService iiAbProxyUserService;
	@Autowired
	TablesMapper ablesMapper;
	@Autowired
	private AbProxyUserMapper abProxyUserMapper;
	@Autowired
	private AbAdvertiserMapper abAdvertiserMapper;
	@Autowired
	private AbAdvertProxyAssociationMapper abAdvertProxyAssociationMapper;
	
	private final static int STATUS = 4;
	private final static int PAGESIZE = 10;

	@Override
	public int saveObject(AbAdver been) {
		int code = abAdverMapper.insertSelective(been);
		return code;
	}

	@Override
	public int deleteByKey(AbAdver been) {
		int code = abAdverMapper.updateByPrimaryKeySelective(been);
		return code;
	}

	@Override
	public AbAdver queryBykey(Integer id) {
		AbAdver been = abAdverMapper.selectByPrimaryKey(id);
		return been;
	}
	
	@Override
	public int updateBykey(AbAdver been) {
		int code = abAdverMapper.updateByPrimaryKeySelective(been);
		return code;
	}
	
	/**
	 * 根据主键查询广告信息
	 */
	@Override
	public AbAdver checkAdverPrice(Integer id) {
		 AbAdver bean = abAdverMapper.selectBykey(id);
		return bean;
	}

	@Override
	public AbAdver selectMaxId() {
		AbAdver been = abAdverMapper.selectMaxId();
		return been;
	}

	@Override
	public List<AbAdver> selectByPage(AbAdver been) {
		List<AbAdver> list = abAdverMapper.selectByPage(been);
		return list;
	}
	@Override
	public List<AbAdver> selectByPage1(AbAdver been) {
		List<AbAdver> list = abAdverMapper.selectByPage1(been);
		return list;
	}

	@Override
	public long selectTotal(AbAdver been) {
		long total = abAdverMapper.selecTotal(been);
		return total;
	}

	/**
	 * 查询广告
	 */
	@Override
	public List<AbAdver> getAdverIdList() {
		List<AbAdver> list = abAdverMapper.getAdverIdList();
		return list;
	}

	/**
	 * 根据userid得到广告信息
	 */
	@Override
	public List<AbAdver> queryByAdvertiserId(String id) {
		List<AbAdver> queryByAdvertiserId = abAdverMapper.queryByAdvertiserId(id);
		return queryByAdvertiserId;
	}

	@Override
	public List<AbAdver> listAbAdver(AbAdver been) {
		return abAdverMapper.listAbAdver(been);
	}

	/**
	 * 查询此广告主下的广告条数
	 */
	@Override
	public int selectIsGetAdver(AbAdver been) {
		int code = abAdverMapper.selectIsGetAdver(been);
		return code;
	}

	@Override
	public AbAdver getByName(AbAdver been) {
		AbAdver result = abAdverMapper.getByName(been);
		return result;
	}

	/**
	 * 查询广告条数
	 */
	@Override
	public Integer getNameCount(AbAdver been) {
		Integer byNameCount = abAdverMapper.getByNameCount(been);
		return byNameCount;
	}
	
	/**
	 * 根据userid获取对应广告
	 */
	@Override
	public List<AbAdver> queryByProxyUserId(List<AbProxyUser> proxyUserId) {
		System.out.println("AdvertisingManServiceImpl"+proxyUserId.toString());
		List<AbAdver> list=abAdverMapper.queryByProxyUserId(proxyUserId);
		return list;
	}
	
	@Override
	public List<AbAdver> queryByUserId(String userId) {
		List<AbAdver> list=abAdverMapper.queryByUserId(userId);
		return list;
	}
	
	/**
	 * 获取具体哪个代理下的广告
	 */
	@Override
	public List<AbAdver> selectByProxyUserId(String proxyUserId) {
		System.out.println("service-----"+proxyUserId);
		List<AbAdver> list=abAdverMapper.selectByProxyUserId(proxyUserId);
		return list;
	}
	
	/**
	 * 管理员查询列表
	 * 
	 * @param been
	 * @return
	 */
	//modified by caiqp
	@Override
	public String queryByPage(AbAdver been) {
		try {
			// 判断用户是管理员还是广告主
			// 查询广告主表是否存在
			AbAdvertiser adver = new AbAdvertiser();
			adver.setUserid(been.getUserid());
			AbAdvertiser advertiserBeen = abAdvertiserMapper.queryByUserId(adver);
			// 广告主如果不存在，是管理员操作，存在是广告主操作
			if (advertiserBeen == null) {
				// 管理员操作用户userid清空,查询所有
				been.setUserid(null);
			}
			Integer page = been.getPage();
			Integer pageTemp = (page - 1) * PAGESIZE;
			//设置分页
			been.setPage(pageTemp);
			Calendar instance = Calendar.getInstance();
			instance.set(Calendar.HOUR_OF_DAY, 0);
			instance.set(Calendar.MINUTE, 0);
			instance.set(Calendar.SECOND, 0);
			long currentTime = instance.getTime().getTime();
			//获取广告列表数据
			List<AbAdver> list = this.selectByPage1(been);
			long total = this.selectTotal(been);
			for (int i = 0; i < list.size(); i++) {
				AbAdver abAdver = list.get(i);
				if (abAdver.getSurplusAdverPrice() != null && abAdver.getSurplusAdverPrice() > 0) {
					abAdver.setConsume((abAdver.getTotalAdverPrice() - abAdver.getSurplusAdverPrice()));
				} else if (abAdver.getSurplusAdverPrice() != null && abAdver.getSurplusAdverPrice() < 0) {
					abAdver.setConsume(abAdver.getTotalAdverPrice());
				} else if (abAdver.getSurplusAdverPrice() == null) {
					abAdver.setConsume(0F);
				}
				Integer status2 = abAdver.getStatus();
				Date startTime = abAdver.getStartTime();
				long startDateLongValue = startTime.getTime();
				Date endTime = abAdver.getEndTime();
				long endDateLongValue = endTime.getTime();
				// 状态等于4或5, 不改变状态，
				/*if (status2 != 4 && status2 != 5) {
					// 当前时间大于截止时间修改状态为下线
					if (currentTime >= startDateLongValue && currentTime <= endDateLongValue) {
						// 已上线状态
						abAdver.setStatus(1);
					}
					if (currentTime > endDateLongValue) {
						// 已下线状态
						abAdver.setStatus(2);
					}
				}*/
			}
			String strResult = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
			JSONArray result = JSONArray.parseArray(strResult);
			return MessageUtils.jsonRetrunListTotalMessage(1, "success", result, total);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 添加广告
	 * @param been
	 * @return
	 */
	@Override
	public String addAdverInfo(AbAdver been) {
		try {
			// 通过广告标题
			// AbAdver byName = iAdvertisingManService.getByName(been);
			Integer count = this.getNameCount(been);
			if (count != 0) {
				return MessageUtils.commonReturnMessage(2, "提示广告名称已存在，并保存失败");
			}
			been.setStatus(STATUS);
			AbAdver maxId = this.selectMaxId();
			if (maxId == null) {
				String setIdNf = IdUtil.setIdNf("AD", 0);
				been.setAdverId(setIdNf);
			} else {
				String setIdNf = IdUtil.setIdNf("AD", maxId.getId());

				been.setAdverId(setIdNf);
			}
			// 添加代理
			int[] agentFirst = been.getAgentFirst();// 一级代理id
			int[] agencyTwo = been.getAgencyTwo();// 二级代理id
			int[] agencyThree = been.getAgencyThree();// 三级代理id
			float[] distribution = been.getDistribution();
			// 获得图片 或 视频
			String[] imgList = been.getImgList();
			// 获得图片像素 格式 宽 X高
			String[] array = been.getPixel();
			int b =array.length;
			List<String> result = new ArrayList<>();
			List<String> result1 = new ArrayList<>();
			boolean flag;  
			for(int i=0;i<array.length;i++){  
			    flag = false;  
			    for(int j=i+1;j<array.length;j++){  
			        if(array[i].equals(array[j])){  
			            flag = true;  
			            break;  
			        }  
			    }  
			    if(!flag){  
			        result.add(array[i]);
			        result1.add(imgList[i]);
			    }  
			}  
			String[] arrayResult = (String[]) result.toArray(new String[result.size()]); 
			String[] imgListResult = (String[]) result1.toArray(new String[result1.size()]);
			String pixelArr = JSON.toJSONString(arrayResult);
			if (arrayResult.length==0) {
				String img = JSON.toJSONString(imgList);
				been.setAdverFile1Url(img);
			}else{
				String img = JSON.toJSONString(imgListResult);
				been.setAdverFile1Url(img);
			}
			// 添加像素
			been.setImgResolution1(pixelArr);
			String first = JSON.toJSONString(agentFirst);
			String two = JSON.toJSONString(agencyTwo);
			String three = JSON.toJSONString(agencyThree);
			String daliRadio = JSON.toJSONString(distribution);
			String agency = first.concat("=" + two).concat("=" + three).concat("=" + daliRadio);
			// 添加代理用户id
			been.setAgency(agency);
			// 添加区域
			String[] prv = been.getPrv();
			String prov = JSON.toJSONString(prv);
			been.setProvCn(prov);
			// 添加广告
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String[] startEndTime = been.getStartEndTime();
			Date start = sdf.parse(startEndTime[0]);
			Date end = sdf.parse(startEndTime[1]);
			// 初始添加 ，广告状态待审核
			been.setStatus(4);
			been.setStartTime(start);
			been.setEndTime(end);
			been.setCreateTime(new Date());
			been.setDeleteFlag(StatusBeen.NORMAL);
			
			Integer proxyId = null;
			// 添加代理分成比例关联表 广告id 一级代理id 分成比例 添加时间
			Integer maxIdByAbAdver=ablesMapper.selectMaxIdByAbAdver();
			/*if (maxId == null) {
				proxyId = 0;
			} else {
				proxyId = maxId.getId();
			}*/
			List<AbAdvertProxyAssociation> proxyListBeen = new ArrayList<AbAdvertProxyAssociation>();
			AbAdvertProxyAssociation proxyBeen = null;
			Date data = new Date();
			for (int i = 0; i < agentFirst.length; i++) {
				proxyBeen = new AbAdvertProxyAssociation();
				proxyBeen.setAdverId(maxIdByAbAdver);
				proxyBeen.setCreateTime(data);
				proxyBeen.setProxyId(agentFirst[i]);
				proxyBeen.setDistributionRatio(distribution[i]);
				proxyBeen.setProxyGrade(1);
				proxyListBeen.add(proxyBeen);
			}
			for (int j = 0; j < agencyTwo.length; j++) {
				proxyBeen = new AbAdvertProxyAssociation();
				proxyBeen.setProxyGrade(2);
				proxyBeen.setAdverId(maxIdByAbAdver);
				proxyBeen.setProxyId(agencyTwo[j]);
				proxyBeen.setCreateTime(data);
				proxyListBeen.add(proxyBeen);
			}
			for (int k = 0; k < agencyThree.length; k++) {
				proxyBeen = new AbAdvertProxyAssociation();
				proxyBeen.setProxyGrade(3);
				proxyBeen.setAdverId(maxIdByAbAdver);
				proxyBeen.setProxyId(agencyThree[k]);
				proxyBeen.setCreateTime(data);
				proxyListBeen.add(proxyBeen);
			}
			for (int i = 0; i < proxyListBeen.size(); i++) {
				AbAdvertProxyAssociation abAdvertProxyAssociation = proxyListBeen.get(i);
				int saveObject1 = iiAbAdvertProxyAssociationService.saveObject(abAdvertProxyAssociation);
			}
			int saveObject = this.saveObject(been);
			return MessageUtils.commonReturnMessage(1, "success");
			// 添加代理

		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 根据主键查询广告信息
	 */
	@Override
	public String queryAbAdverByKey(Integer id) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String start = null;
			String end = null;
			AbAdver result = this.queryBykey(id);
			if(result.getSurplusAdverPrice() !=null){
				result.setTotalAdverPrice(result.getSurplusAdverPrice());
			}
			if(result.getStatus() ==1 || result.getStatus() ==3){
				start = sdf.format(sdf1.parse(DateUtil.getCurrentDatePreDays(DateUtil.getCurrentDateTime("yyyy-MM-dd"),"yyyy-MM-dd",-1)));	
			}
			else{
				start = sdf.format(result.getStartTime());
			}
//			String start = sdf.format(result.getStartTime());
			end = sdf.format(result.getEndTime());
			String[] strArray = new String[2];
			strArray[0] = start;
			strArray[1] = end;
			result.setStartEndTime(strArray);
			// 回显代理
			String agency = result.getAgency();
			String[] split = agency.split("=");
			JSONArray firstAgency = JSONObject.parseArray(split[0]);
			JSONArray twoAgency = JSONObject.parseArray(split[1]);
			JSONArray threeAgency = JSONObject.parseArray(split[2]);
			firstAgency.addAll(twoAgency);
			firstAgency.addAll(threeAgency);
			result.setImgListTemp(JSONArray.parseArray(result.getAdverFile1Url()));
			result.setAgencyFirstTemp(firstAgency);
			// result.setAgencyTwoTemp(twoAgency);
			// result.setAgencyThreeTemp(threeAgency);
			String provCn = result.getProvCn();
			JSONArray prv = JSONObject.parseArray(provCn);
			result.setPrvTemp(prv);
			// 清空无用数据
			result.setAdverFile1Url(null);
			result.setAgency(null);
			result.setProvCn(null);
			result.setAdverFile1Url(null);
			result.setStartTime(null);
			result.setEndTime(null);
			List<AbAdvertProxyAssociation> queryByAdverId = abAdvertProxyAssociationMapper.selectByAdverId(id);
			// 处理代理
			// List<AbProxyUser> firstList =
			// iiAbProxyUserService.selectAgentLevelFirst();
			// List<AbProxyUser> twoList =
			// iiAbProxyUserService.selectAgentLevelTwo();
			// List<AbProxyUser> threeList =
			// iiAbProxyUserService.selectAgentLevelThree();
			// 代理树
			// 广告关联代理表-》临时修改代理分成数据
			JSONArray tempAgency = new JSONArray();
			List<AbProxyUser> menu = abProxyUserMapper.selectMenu();
			for (AbProxyUser key : menu) {
				Integer id2 = key.getId();
				for (AbAdvertProxyAssociation key1 : queryByAdverId) {
					Integer proxyId = key1.getProxyId();
					if (id2.equals(proxyId)) {
						AbProxyUser apu = new AbProxyUser();
						key.setDistributionRatio(key1.getDistributionRatio());
						apu.setProxyName(key.getProxyName());
						apu.setId(key.getId());
						apu.setDistributionRatio(key1.getDistributionRatio());
						tempAgency.add(apu);
					}
				}
			}
			// 清空无效数据
			result.setCreateTime(null);
			// 响应参数广告结果 / menu菜单/ 一级id/ 二级id/ 三级id
			JSONObject json = new JSONObject();
			json.put("list", result);
			json.put("menu", menu);
			json.put("checkedTempFirst", tempAgency);
			// return MessageUtils.jsonRetrunMessage(1, "success", result,
			// queryByAdverId, firstList, twoList, threeList);
			return MessageUtils.jsonRetrunListMessage(1, "success", json);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 修改广告
	 */
	@Override
	public String updateAbAdverByKey(AbAdver been) {
		try {
			// 通过idchaxun
			AbAdver queryBykey = this.queryBykey(been.getId());
			System.out.println(been.getAdverTitle()+"----"+queryBykey.getAdverTitle());
			if (been.getAdverTitle().equals(queryBykey.getAdverTitle())) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String[] startEndTime = been.getStartEndTime();
				Date start = sdf.parse(startEndTime[0]);
				Date end = sdf.parse(startEndTime[1]);
				if(been.getStatus() ==1 || been.getStatus() ==3){
					//前台控制 1为上线，此时编辑剩余总价时可以为0; 其余状态不行
					if(been.getTotalAdverPrice()==0){
						been.setStatus(2);
						been.setChangeFlag(1);
						/*Date date=new Date();
						String endTime=sdf.format(new Date(date.getTime() - 1 * 24 * 60 * 60 * 1000L));
						been.setEndTime(sdf.parse(endTime));*/
					}else{
						been.setStatus(4);
						//改动标记
						been.setChangeFlag(1);
						been.setEndTime(end);
					}
				}else if(been.getStatus() == 2){
					been.setStatus(4);
					been.setChangeFlag(0);
					been.setEndTime(end);
				}else{
					been.setChangeFlag(0);
					been.setEndTime(end);
				}
				if(queryBykey.getSurplusAdverPrice() != null){
					been.setTotalAdverPrice(queryBykey.getTotalAdverPrice());
					been.setSurplusAdverPrice(been.getTotalAdverPrice());
				}
				// 添加代理
				int[] agentFirst = been.getAgentFirst();// 一级代理id
				int[] agencyTwo = been.getAgencyTwo();// 二级代理id
				int[] agencyThree = been.getAgencyThree();// 三级代理id
				float[] distribution = been.getDistribution();
				// 获得图片 或 视频
				String[] imgList = been.getImgList();
				// 获得图片像素 格式 宽 X高
				String[] array = been.getPixel();
				int b =array.length;
				List<String> result = new ArrayList<>();
				List<String> result1 = new ArrayList<>();
				boolean flag;  
				for(int i=0;i<array.length;i++){  
				    flag = false;  
				    for(int j=i+1;j<array.length;j++){  
				        if(array[i].equals(array[j])){  
				            flag = true;  
				            break;  
				        }  
				    }  
				    if(!flag){  
				        result.add(array[i]);
				        result1.add(imgList[i]);
				    }  
				}  
				String[] arrayResult = (String[]) result.toArray(new String[result.size()]); 
				String[] imgListResult = (String[]) result1.toArray(new String[result1.size()]);
				String pixelArr = JSON.toJSONString(arrayResult);
				if (arrayResult.length==0) {
					String img = JSON.toJSONString(imgList);
					been.setAdverFile1Url(img);
				}else{
					String img = JSON.toJSONString(imgListResult);
					been.setAdverFile1Url(img);
				}
				// 添加像素
				been.setImgResolution1(pixelArr);

				String img = JSON.toJSONString(imgListResult);
				// 图片
				been.setAdverFile1Url(img);
				String first = JSON.toJSONString(agentFirst);
				String two = JSON.toJSONString(agencyTwo);
				String three = JSON.toJSONString(agencyThree);
				String daliRadio = JSON.toJSONString(distribution);
				String agency = first.concat("=" + two).concat("=" + three).concat("=" + daliRadio);
				// 添加代理用户id
				been.setAgency(agency);
				// 添加区域
				String[] prv = been.getPrv();
				String prov = JSON.toJSONString(prv);
				been.setProvCn(prov);
				// 添加广告
				been.setStartTime(start);
				been.setCreateTime(new Date());
				been.setDeleteFlag(StatusBeen.NORMAL);
				int saveObject = this.updateBykey(been);
				int deleteByAdverId = abAdvertProxyAssociationMapper.deleteByAdverId(been.getId());
				List<AbAdvertProxyAssociation> proxyListBeen = new ArrayList<AbAdvertProxyAssociation>();
				AbAdvertProxyAssociation proxyBeen = null;
				for (int i = 0; i < agentFirst.length; i++) {
					proxyBeen = new AbAdvertProxyAssociation();
					proxyBeen.setProxyGrade(1);
					proxyBeen.setAdverId(been.getId());
					proxyBeen.setCreateTime(new Date());
					proxyBeen.setProxyId(agentFirst[i]);
					proxyBeen.setDistributionRatio(distribution[i]);
					proxyListBeen.add(proxyBeen);
				}
				for (int j = 0; j < agencyTwo.length; j++) {
					proxyBeen = new AbAdvertProxyAssociation();
					proxyBeen.setProxyGrade(2);
					proxyBeen.setAdverId(been.getId());
					proxyBeen.setCreateTime(new Date());
					proxyBeen.setProxyId(agencyTwo[j]);
					proxyListBeen.add(proxyBeen);
				}
				for (int k = 0; k < agencyThree.length; k++) {
					proxyBeen = new AbAdvertProxyAssociation();
					proxyBeen.setProxyGrade(3);
					proxyBeen.setAdverId(been.getId());
					proxyBeen.setCreateTime(new Date());
					proxyBeen.setProxyId(agencyThree[k]);
					proxyListBeen.add(proxyBeen);
				}
				for (int i = 0; i < proxyListBeen.size(); i++) {
					AbAdvertProxyAssociation abAdvertProxyAssociation = proxyListBeen.get(i);
					int saveObject1 = abAdvertProxyAssociationMapper.insertSelective(abAdvertProxyAssociation);
				}
				return MessageUtils.commonReturnMessage(1, "success");
			} else {
				been.setStatus(4);
				been.setChangeFlag(1);
				Integer count = this.getNameCount(been);
				if (count != 0) {
					return MessageUtils.commonReturnMessage(2, "提示广告名称已存在，并保存失败");
				}
				// 添加代理
				int[] agentFirst = been.getAgentFirst();// 一级代理id
				int[] agencyTwo = been.getAgencyTwo();// 二级代理id
				int[] agencyThree = been.getAgencyThree();// 三级代理id
				float[] distribution = been.getDistribution();
				// 获得图片 或 视频
				String[] imgList = been.getImgList();
				// 获得图片像素 格式 宽 X高
				String[] pixel = been.getPixel();
				String pixelArr = JSON.toJSONString(pixel);
				// 添加像素
				been.setImgResolution1(pixelArr);
				String img = JSON.toJSONString(imgList);
				// 图片
				been.setAdverFile1Url(img);
				String first = JSON.toJSONString(agentFirst);
				String two = JSON.toJSONString(agencyTwo);
				String three = JSON.toJSONString(agencyThree);
				String daliRadio = JSON.toJSONString(distribution);
				String agency = first.concat("=" + two).concat("=" + three).concat("=" + daliRadio);
				// 添加代理用户id
				been.setAgency(agency);
				// 添加区域
				String[] prv = been.getPrv();
				String prov = JSON.toJSONString(prv);
				been.setProvCn(prov);
				// 添加广告
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String[] startEndTime = been.getStartEndTime();
				Date start = sdf.parse(startEndTime[0]);
				Date end = sdf.parse(startEndTime[1]);
				been.setStartTime(start);
				been.setEndTime(end);
				been.setCreateTime(new Date());
				been.setDeleteFlag(StatusBeen.NORMAL);
				int saveObject = this.updateBykey(been);
				int deleteByAdverId = abAdvertProxyAssociationMapper.deleteByAdverId(been.getId());
				List<AbAdvertProxyAssociation> proxyListBeen = new ArrayList<AbAdvertProxyAssociation>();
				AbAdvertProxyAssociation proxyBeen = null;
				for (int i = 0; i < agentFirst.length; i++) {
					proxyBeen = new AbAdvertProxyAssociation();
					proxyBeen.setProxyGrade(1);
					proxyBeen.setAdverId(been.getId());
					proxyBeen.setCreateTime(new Date());
					proxyBeen.setProxyId(agentFirst[i]);
					proxyBeen.setDistributionRatio(distribution[i]);
					proxyListBeen.add(proxyBeen);
				}
				for (int j = 0; j < agencyTwo.length; j++) {
					proxyBeen = new AbAdvertProxyAssociation();
					proxyBeen.setProxyGrade(2);
					proxyBeen.setAdverId(been.getId());
					proxyBeen.setCreateTime(new Date());
					proxyBeen.setProxyId(agencyTwo[j]);
					proxyListBeen.add(proxyBeen);
				}

				for (int k = 0; k < agencyThree.length; k++) {
					proxyBeen = new AbAdvertProxyAssociation();
					proxyBeen.setProxyGrade(3);
					proxyBeen.setAdverId(been.getId());
					proxyBeen.setCreateTime(new Date());
					proxyBeen.setProxyId(agencyThree[k]);
					proxyListBeen.add(proxyBeen);
				}
				for (int i = 0; i < proxyListBeen.size(); i++) {
					AbAdvertProxyAssociation abAdvertProxyAssociation = proxyListBeen.get(i);
					int saveObject1 = abAdvertProxyAssociationMapper.insertSelective(abAdvertProxyAssociation);
				}
				return MessageUtils.commonReturnMessage(1, "success");
			}

			// 添加代理

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 获取广告明细
	 * @param id
	 * @return
	 */
	@Override
	public String selectByKey(Integer id) {
		try {
			AbAdver result = this.queryBykey(id);
			String agency = result.getAgency();
			String[] split = agency.split("=");
			JSONArray first = JSONArray.parseArray(split[0]);
			JSONArray twoArray = JSONArray.parseArray(split[1]);
			JSONArray threeArray = JSONArray.parseArray(split[2]);
			first.addAll(twoArray);
			first.addAll(threeArray);
			StringBuffer sb = new StringBuffer(0);
			for (int i = 0; i < first.size(); i++) {
				if (i == first.size() - 1) {
					sb.append(first.get(i));
				} else {
					sb.append(first.get(i) + ",");
				}
			}
			List<AbProxyUser> selectByInId = abProxyUserMapper.selectByInId(sb.toString());
			System.out.println(JSON.toJSONString(selectByInId));
			result.setAgencyTemp(JSONArray.parseArray(JSON.toJSONString(selectByInId)));
			result.setPrvTemp(JSONArray.parseArray(result.getProvCn()));
			result.setImgListTemp(JSONArray.parseArray(result.getAdverFile1Url()));
			// 清空无用字段数据
			result.setAdverFile1Url(null);
			result.setAgency(null);
			result.setProvCn(null);
			String jsonStringWithDateFormat = JSON.toJSONStringWithDateFormat(result, "yyyy年MM月dd日");
			JSONObject parseObject = JSONObject.parseObject(jsonStringWithDateFormat);
			return MessageUtils.jsonRetrunListMessage(1, "success", parseObject);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 删除广告
	 */
	@Override
	public String deleteAbAdverByKey(AbAdver been) {
		try {
			Calendar instance = Calendar.getInstance();
			instance.set(Calendar.HOUR_OF_DAY, 0);
			instance.set(Calendar.MINUTE, 0);
			instance.set(Calendar.SECOND, 0);
			long currentLongValue = instance.getTime().getTime();
			AbAdver queryBykey = this.queryBykey(been.getId());
			long startDateLongValue = queryBykey.getStartTime().getTime();
			long endDateLongValue = queryBykey.getEndTime().getTime();
			//判断广告是否上线
			if (currentLongValue >= startDateLongValue && currentLongValue < endDateLongValue
					&& queryBykey.getStatus() == 3 || queryBykey.getStatus() == 1) {
				return MessageUtils.commonReturnMessage(2, "广告已经上线，不能删除");
			}
			been.setDeleteFlag(StatusBeen.DELETE);
			int code = this.deleteByKey(been);
			return MessageUtils.commonReturnMessage(code, "success");
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return MessageUtils.commonReturnMessage(0, "fail");
		}
	}
	
	/**
	 * 判断时间格式
	 */
	@Override
	public String checkStartEndTime(String startEndTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> m = new HashMap<String, Object>();
		String[] endTime = startEndTime.split(",");
		Date time;
		try {
			time = sdf.parse(endTime[0]);
			if((sdf.parse(DateUtil.getCurrentDatePreDays(DateUtil.getCurrentDateTime("yyyy-MM-dd"),"yyyy-MM-dd",-1))).getTime()>time.getTime()){
				m.put("code", 1);
				m.put("message", "输入值错误");
			}else{
				m.put("code", 2);
				m.put("message", "ok");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 校验广告单价
	 */
	@Override
	public String checkAdUnitPrice(String billingMethodWay, Integer id, Integer flag) {
		Map<String, Object> m = new HashMap<String, Object>();
		AbAdver bean = this.checkAdverPrice(id);
		if (flag == 1) {
			m.put("code", 2);
			m.put("message", "ok");
		} else {
			if (bean.getSurplusNumberClicks() == null) {
				m.put("code", 2);
				m.put("message", "ok");
			} else {
				if(Integer.valueOf(billingMethodWay)- bean.getNumberClicks() !=0){
					if (Integer.valueOf(billingMethodWay) - bean.getNumberClicks() >= bean.getSurplusNumberClicks()) {
						m.put("code", 2);
						m.put("message", "ok");
					} else {
						m.put("code", 1);
						m.put("message", "输入值错误");
					}
				}
			}
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 校验广告金额
	 */
	@Override
	public String checkAdverPrice(String totalAdverPrice, Integer id) {
		Map<String, Object> m = new HashMap<String, Object>();
		AbAdver bean = this.checkAdverPrice(id);
		if(bean.getSurplusAdverPrice() ==null){
				m.put("code", 2);
				m.put("message", "ok");
		}else{
			if(Integer.valueOf(totalAdverPrice)>=bean.getSurplusAdverPrice()){
				m.put("code", 2);
				m.put("message", "ok");
			}else{
				m.put("code", 1);
				m.put("message", "输入值错误");
			}
		}
		return JSONSerializer.toJSON(m).toString();
	}
	
	/**
	 * 修改广告标题后判断时候已经存在
	 */
	@Override
	public String checkUpdateAdverTitle(AbAdver been, Integer id) {
		Integer count = this.getNameCount(been);
		AbAdver ad = this.checkAdverPrice(id);
		if(ad.getAdverTitle().equals(been.getAdverTitle())){
			return MessageUtils.commonReturnMessage(3, "提示没有修改广告名称");
		}else{
			if (count != 0) {
				return MessageUtils.commonReturnMessage(1, "提示广告名称已存在，并保存失败");
			}else{
				return MessageUtils.commonReturnMessage(2, "提示广告名称新建成功");
			}
		}
	}
}
