package ad.bean;

import java.io.Serializable;
import com.alibaba.fastjson.JSONArray;

public class BaseBeen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2989690892156708947L;
	private Integer page;
	private Integer pageSize;
	private String[] imgList;
	private String[] startEndTime;
	private int[] agentFirst;// 一级代理
	private int[] agencyLevel;// 代理等级
	private float[] distribution;// 分成比例distribution
	private int[] agencyTwo;// 二级代理
	private int[] agencyThree;// 三级代理
	private String[] prv;// 省

	private JSONArray imgListTemp;// 回显照片
	private JSONArray agencyFirstTemp; // 一级代理临时字段
	private JSONArray agencyTwoTemp; // 二级代理一级字段
	private JSONArray agencyThreeTemp; // 三级代理临时字段
	private JSONArray prvTemp; // 省临时字段
	private JSONArray daliDistribution; // 代理分成比例关联字段
	private String[] agentTemp;// 代理详情临时字段
	private JSONArray agencyTemp;// 代理详情

	// 广告sdk获取临时字段 代理id
	private Integer proxyId;

	// 广告主识别id
	private String userid;

	// 图片分辨率
	private String[] pixel;

	// 已经消耗广告费用
	private Float consume;

	public Float getConsume() {
		return consume;
	}

	public void setConsume(Float consume) {
		this.consume = consume;
	}

	public String[] getPixel() {
		return pixel;
	}

	public void setPixel(String[] pixel) {
		this.pixel = pixel;
	}

	public JSONArray getImgListTemp() {
		return imgListTemp;
	}

	public void setImgListTemp(JSONArray imgListTemp) {
		this.imgListTemp = imgListTemp;
	}

	public JSONArray getAgencyTemp() {
		return agencyTemp;
	}

	public void setAgencyTemp(JSONArray agencyTemp) {
		this.agencyTemp = agencyTemp;
	}

	public String[] getAgentTemp() {
		return agentTemp;
	}

	public void setAgentTemp(String[] agentTemp) {
		this.agentTemp = agentTemp;
	}

	public JSONArray getAgencyFirstTemp() {
		return agencyFirstTemp;
	}

	public void setAgencyFirstTemp(JSONArray agencyFirstTemp) {
		this.agencyFirstTemp = agencyFirstTemp;
	}

	public JSONArray getAgencyTwoTemp() {
		return agencyTwoTemp;
	}

	public void setAgencyTwoTemp(JSONArray agencyTwoTemp) {
		this.agencyTwoTemp = agencyTwoTemp;
	}

	public JSONArray getAgencyThreeTemp() {
		return agencyThreeTemp;
	}

	public void setAgencyThreeTemp(JSONArray agencyThreeTemp) {
		this.agencyThreeTemp = agencyThreeTemp;
	}

	public JSONArray getPrvTemp() {
		return prvTemp;
	}

	public void setPrvTemp(JSONArray prvTemp) {
		this.prvTemp = prvTemp;
	}

	public JSONArray getDaliDistribution() {
		return daliDistribution;
	}

	public void setDaliDistribution(JSONArray daliDistribution) {
		this.daliDistribution = daliDistribution;
	}

	public int[] getAgentFirst() {
		return agentFirst;
	}

	public void setAgentFirst(int[] agentFirst) {
		this.agentFirst = agentFirst;
	}

	public int[] getAgencyLevel() {
		return agencyLevel;
	}

	public void setAgencyLevel(int[] agencyLevel) {
		this.agencyLevel = agencyLevel;
	}

	public float[] getDistribution() {
		return distribution;
	}

	public void setDistribution(float[] distribution) {
		this.distribution = distribution;
	}

	public int[] getAgencyTwo() {
		return agencyTwo;
	}

	public void setAgencyTwo(int[] agencyTwo) {
		this.agencyTwo = agencyTwo;
	}

	public int[] getAgencyThree() {
		return agencyThree;
	}

	public void setAgencyThree(int[] agencyThree) {
		this.agencyThree = agencyThree;
	}

	public String[] getPrv() {
		return prv;
	}

	public void setPrv(String[] prv) {
		this.prv = prv;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String[] getImgList() {
		return imgList;
	}

	public void setImgList(String[] imgList) {
		this.imgList = imgList;
	}

	public String[] getStartEndTime() {
		return startEndTime;
	}

	public void setStartEndTime(String[] startEndTime) {
		this.startEndTime = startEndTime;
	}

	public Integer getProxyId() {
		return proxyId;
	}

	public void setProxyId(Integer proxyId) {
		this.proxyId = proxyId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
