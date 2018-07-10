package ad.bean;

import java.io.Serializable;
import java.util.Date;

/*
 * page
 */
public class BaseCommonBeen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5507301837361506893L;
	private Integer page;
	private Integer pageSize;
	private Integer totalNumber;
	private Integer flag;
	private String adTitle;
	private String agencyName;
	private Integer adverPosition;
	
	// 展示次数
	private Long adverDisplayNum;
	// 点击次数
	private Long adverClick;
	// 展示设备次数
	private Long adverClickdevice;
	// 广告费用
	private Long advertisingExpenses;
	//广告标题
	private String adverTitle;
    //广告主
	private String adverMain;	
	//广告位
	private String adverPosition1;
	//点击率
	private String adverDisplay;
	public String getAdverDisplay() {
		return adverDisplay;
	}

	public void setAdverDisplay(String adverDisplay) {
		this.adverDisplay = adverDisplay;
	}

	public String getAdverTitle() {
		return adverTitle;
	}

	public void setAdverTitle(String adverTitle) {
		this.adverTitle = adverTitle;
	}

	public String getAdverMain() {
		return adverMain;
	}

	public void setAdverMain(String adverMain) {
		this.adverMain = adverMain;
	}

	// 代理
	private String adverAgent;

	public Long getAdverDisplayNum() {
		return adverDisplayNum;
	}

	public void setAdverDisplayNum(Long adverDisplayNum) {
		this.adverDisplayNum = adverDisplayNum;
	}

	public Long getAdverClick() {
		return adverClick;
	}

	public void setAdverClick(Long adverClick) {
		this.adverClick = adverClick;
	}

	public Long getAdverClickdevice() {
		return adverClickdevice;
	}

	public void setAdverClickdevice(Long adverClickdevice) {
		this.adverClickdevice = adverClickdevice;
	}

	public Long getAdvertisingExpenses() {
		return advertisingExpenses;
	}

	public void setAdvertisingExpenses(Long advertisingExpenses) {
		this.advertisingExpenses = advertisingExpenses;
	}

	public String getAdverAgent() {
		return adverAgent;
	}

	public void setAdverAgent(String adverAgent) {
		this.adverAgent = adverAgent;
	}

	public String getAdverPosition1() {
		return adverPosition1;
	}

	public void setAdverPosition1(String adverPosition1) {
		this.adverPosition1 = adverPosition1;
	}

	private String[] startEndTime;
	private Date startDate;
	private Date endDate;
	private String startTempTime;
	// 点击率
	private float clickingRate;
	// 广告主id
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String[] getStartEndTime() {
		return startEndTime;
	}

	public void setStartEndTime(String[] startEndTime) {
		this.startEndTime = startEndTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartTempTime() {
		return startTempTime;
	}

	public void setStartTempTime(String startTempTime) {
		this.startTempTime = startTempTime;
	}

	public Integer getAdverPosition() {
		return adverPosition;
	}

	public void setAdverPosition(Integer adverPosition) {
		this.adverPosition = adverPosition;
	}

	public float getClickingRate() {
		return clickingRate;
	}

	public void setClickingRate(float clickingRate) {
		this.clickingRate = clickingRate;
	}

}
