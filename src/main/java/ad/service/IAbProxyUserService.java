package ad.service;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ad.bean.AbProxyUser;

public interface IAbProxyUserService {

	public AbProxyUser queryById(int id);

	public AbProxyUser queryByProxyName(String proxyName);
	
	//按着手机号码查询
	public AbProxyUser queryByProxyPhone(String proxyPhone);

	//按着邮箱查询
	public AbProxyUser queryByProxyEmail(String proxyEmail);

	//初始加载代理用户全部数据
	public String getAllUser(AbProxyUser abProxyUser);

	public AbProxyUser selectNum();

	public List<AbProxyUser> queryProxyList(AbProxyUser abProxyUser);

	//条件查询
	public String getProxyInfo(AbProxyUser abProxyUser);
	
	//删除代理用户
	public String deleteProxy(String ids);
	
	//查询代理详情
	public String getProxyInfoById(Integer id);
	
	public List<AbProxyUser> exportQueryProxyList(AbProxyUser abProxyUser);
	
	//按着条件导出(导出excel)
	public void exportProxyList(HttpServletResponse response,AbProxyUser abProxyUser) throws FileNotFoundException;

	//下线列表接口
	public String queryDownProxyList(AbProxyUser abProxyUser);
	
	//添加代理用户
	public String addProxyInfo(String serverURLRole,AbProxyUser abProxyUser,String token,String siteCode);

	//修改代理用户
	public String updateProxyInfo(String serverURL,AbProxyUser abProxyUser,String token,String siteCode);
	
	public List<AbProxyUser> queryUpperList(int agencyLevel);

	public Integer updateByPrimaryId(AbProxyUser abProxyUser);

	public Integer updateByPrimaryID(AbProxyUser abProxyUser);

	public Integer insertSelective(AbProxyUser abProxyUser);

	public Integer updateByPrimaryKeySelective(AbProxyUser abProxyUser);

	public Integer deleteByPrimaryId(String id);

	public List<AbProxyUser> queryRevenueChartsList(String time0, String time1);

	public Integer getNewAddProxy(String yesterday);

	List<AbProxyUser> selectFirstlevel(AbProxyUser abProxyUser);

	long queryTotal();

	List<AbProxyUser> selectAgentLevelFirst();

	List<AbProxyUser> selectAgentLevelTwo();

	List<AbProxyUser> selectAgentLevelThree();

	List<AbProxyUser> selectByInId(String id);

	List<AbProxyUser> queryAllProxyUser();

	Integer selectProxyUserByName(String name);
	
	List<AbProxyUser> getMenu();
	
	List<AbProxyUser> selectAgenstByCy(Integer cy);
	
	List<AbProxyUser> queryAngeList(AbProxyUser aProxyUser);
	
	List<AbProxyUser> selectProxyUser();

}
