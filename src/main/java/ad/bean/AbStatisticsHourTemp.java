package ad.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AbStatisticsHourTemp extends BaseCommonBeen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6866834948450885558L;

	private Integer id;

	private Integer subProxyId;

	private String clickUserId;

	private BigDecimal earningsAmount;

	private Integer adverId;

	private Integer advertiserId;

	private Date createTime;

	private Integer actionlogId;

	private String equipmentId;

	private Integer proxyId;

	private BigDecimal agencyAmount;
	
	private Float agencyNameOfAmount;

	private Integer clickNum;

	private Integer showNum;

	private String appName;
	
	private String userid;

	private String appPackageName;

	private String name;
	
	private String time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private List<AbProxyUser> abProxyUserList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppPackageName() {
		return appPackageName;
	}

	public void setAppPackageName(String appPackageName) {
		this.appPackageName = appPackageName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubProxyId() {
		return subProxyId;
	}

	public void setSubProxyId(Integer subProxyId) {
		this.subProxyId = subProxyId;
	}

	public String getClickUserId() {
		return clickUserId;
	}

	public void setClickUserId(String clickUserId) {
		this.clickUserId = clickUserId == null ? null : clickUserId.trim();
	}

	public BigDecimal getEarningsAmount() {
		return earningsAmount;
	}

	public void setEarningsAmount(BigDecimal earningsAmount) {
		this.earningsAmount = earningsAmount;
	}

	public Integer getAdverId() {
		return adverId;
	}

	public void setAdverId(Integer adverId) {
		this.adverId = adverId;
	}

	public Integer getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(Integer advertiserId) {
		this.advertiserId = advertiserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getActionlogId() {
		return actionlogId;
	}

	public void setActionlogId(Integer actionlogId) {
		this.actionlogId = actionlogId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId == null ? null : equipmentId.trim();
	}

	public Integer getProxyId() {
		return proxyId;
	}

	public void setProxyId(Integer proxyId) {
		this.proxyId = proxyId;
	}

	public BigDecimal getAgencyAmount() {
		return agencyAmount;
	}

	public void setAgencyAmount(BigDecimal agencyAmount) {
		this.agencyAmount = agencyAmount;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Integer getShowNum() {
		return showNum;
	}

	public void setShowNum(Integer showNum) {
		this.showNum = showNum;
	}

	public Float getAgencyNameOfAmount() {
		return agencyNameOfAmount;
	}

	public void setAgencyNameOfAmount(Float agencyNameOfAmount) {
		this.agencyNameOfAmount = agencyNameOfAmount;
	}

	public List<AbProxyUser> getAbProxyUserList() {
		return abProxyUserList;
	}

	public void setAbProxyUserList(List<AbProxyUser> abProxyUserList) {
		this.abProxyUserList = abProxyUserList;
	}

	@Override
	public String getUserid() {
		return userid;
	}

	@Override
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}