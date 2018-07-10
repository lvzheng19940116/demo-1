package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbProxyUser extends BaseCommonBeen {
	/**
	 * 
	 */
	private static final long serialVersionUID = -708415545646621683L;

	private Integer id;

	private String proxyName;

	private String proxyPhone;

	private String proxyUserName;

	private String proxyPassword;

	private String proxyProvince;

	private String proxyCity;

	private Integer fatherId;

	private Integer agencyLevel;

	private Float distributionRatio;

	private Integer offlineNumber;

	private String salesChannelsId;

	private Date createTime;

	private String userid;

	private String proxyEmail;

	private String upperId;// 上线ID

	private String upperName;

	private String upperPhone;

	private String remark;// 备注

	private Float cumulativeIncome;// 累计总收益

	private Float currentIncome;// 当前收益

	private Integer cardNumber;// 银行卡数

	private Integer deleteFlag;// 删除标记

	private String date;// 前台的注册时间
	
	private String appkey;
	
	

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private List<AbProxyUser> children = new ArrayList<AbProxyUser>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProxyName() {
		return proxyName;
	}

	public void setProxyName(String proxyName) {
		this.proxyName = proxyName == null ? null : proxyName.trim();
	}

	public String getProxyPhone() {
		return proxyPhone;
	}

	public void setProxyPhone(String proxyPhone) {
		this.proxyPhone = proxyPhone == null ? null : proxyPhone.trim();
	}

	public String getProxyUserName() {
		return proxyUserName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword == null ? null : proxyPassword.trim();
	}

	public String getProxyProvince() {
		return proxyProvince;
	}

	public void setProxyProvince(String proxyProvince) {
		this.proxyProvince = proxyProvince == null ? null : proxyProvince.trim();
	}

	public String getProxyCity() {
		return proxyCity;
	}

	public void setProxyCity(String proxyCity) {
		this.proxyCity = proxyCity == null ? null : proxyCity.trim();
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public Integer getAgencyLevel() {
		return agencyLevel;
	}

	public void setAgencyLevel(Integer agencyLevel) {
		this.agencyLevel = agencyLevel;
	}

	public Float getDistributionRatio() {
		return distributionRatio;
	}

	public void setDistributionRatio(Float distributionRatio) {
		this.distributionRatio = distributionRatio;
	}

	public Integer getOfflineNumber() {
		return offlineNumber;
	}

	public void setOfflineNumber(Integer offlineNumber) {
		this.offlineNumber = offlineNumber;
	}

	public String getSalesChannelsId() {
		return salesChannelsId;
	}

	public void setSalesChannelsId(String salesChannelsId) {
		this.salesChannelsId = salesChannelsId == null ? null : salesChannelsId.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String getUserid() {
		return userid;
	}

	@Override
	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getProxyEmail() {
		return proxyEmail;
	}

	public void setProxyEmail(String proxyEmail) {
		this.proxyEmail = proxyEmail;
	}

	public String getUpperId() {
		return upperId;
	}

	public void setUpperId(String upperId) {
		this.upperId = upperId;
	}

	public String getUpperName() {
		return upperName;
	}

	public void setUpperName(String upperName) {
		this.upperName = upperName;
	}

	public String getUpperPhone() {
		return upperPhone;
	}

	public void setUpperPhone(String upperPhone) {
		this.upperPhone = upperPhone;
	}

	public Float getCumulativeIncome() {
		return cumulativeIncome;
	}

	public void setCumulativeIncome(Float cumulativeIncome) {
		this.cumulativeIncome = cumulativeIncome;
	}

	public Float getCurrentIncome() {
		return currentIncome;
	}

	public void setCurrentIncome(Float currentIncome) {
		this.currentIncome = currentIncome;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<AbProxyUser> getChildren() {
		return children;
	}

	public void setChildren(List<AbProxyUser> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "AbProxyUser [id=" + id + ", proxyName=" + proxyName + ", proxyPhone=" + proxyPhone + ", proxyUserName="
				+ proxyUserName + ", proxyPassword=" + proxyPassword + ", proxyProvince=" + proxyProvince
				+ ", proxyCity=" + proxyCity + ", fatherId=" + fatherId + ", agencyLevel=" + agencyLevel
				+ ", distributionRatio=" + distributionRatio + ", offlineNumber=" + offlineNumber + ", salesChannelsId="
				+ salesChannelsId + ", createTime=" + createTime + ", userid=" + userid + ", proxyEmail=" + proxyEmail
				+ ", upperId=" + upperId + ", upperName=" + upperName + ", upperPhone=" + upperPhone + ", remark="
				+ remark + ", cumulativeIncome=" + cumulativeIncome + ", currentIncome=" + currentIncome
				+ ", cardNumber=" + cardNumber + ", deleteFlag=" + deleteFlag + ", date=" + date + ", appkey=" + appkey
				+ ", children=" + children + "]";
	}
	
	
}