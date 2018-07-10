package ad.bean;

import java.util.Date;

public class AbBillingInfo extends BaseCommonBeen {
	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;

	private Integer id;

	private String billingNumber;

	private Integer billingUserId;

	private Integer bankCardId;

	private Float settlementAmount;

	private Integer billingStatus;

	private Date startTime;

	private Date endTime;

	private Integer flag;

	private Date createTime;

	private String bankCardNumber;// 结算银行卡号

	private String creatTime; // String类型创建时间

	private String proxyName;// 结算用户账号

	private String proxyUserName;// 结算用户名称

	private String proxyPhone;// 结算用户手机号

	private String time1;// 日期控件的启示日期

	private String time2;// 日期控件的终止日期

	private String amountFlag;// 金钱标记

	private String regionFlag;// 手机号，名称，ID标记

	private String clearingName;// 手机号，名称，ID输入的内容

	private String timeFlag;// 结算记录生成时间，结算起始时间，结算完成时间的标记

	private String completeDate;// 日期控件传过来的值

	private String clearTime;// 结算记录生成时间

	private String clearStartTime;// 结算记录起始时间

	private String clearEndTime;// 结算记录完成时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(String billingNumber) {
		this.billingNumber = billingNumber == null ? null : billingNumber.trim();
	}

	public Integer getBillingUserId() {
		return billingUserId;
	}

	public void setBillingUserId(Integer billingUserId) {
		this.billingUserId = billingUserId;
	}

	public Integer getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Integer bankCardId) {
		this.bankCardId = bankCardId;
	}

	public Float getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(Float settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public Integer getBillingStatus() {
		return billingStatus;
	}

	public void setBillingStatus(Integer billingStatus) {
		this.billingStatus = billingStatus;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public Integer getFlag() {
		return flag;
	}

	@Override
	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getProxyUserName() {
		return proxyUserName;
	}

	public String getProxyName() {
		return proxyName;
	}

	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getProxyPhone() {
		return proxyPhone;
	}

	public void setProxyPhone(String proxyPhone) {
		this.proxyPhone = proxyPhone;
	}

	public String getAmountFlag() {
		return amountFlag;
	}

	public void setAmountFlag(String amountFlag) {
		this.amountFlag = amountFlag;
	}

	public String getRegionFlag() {
		return regionFlag;
	}

	public void setRegionFlag(String regionFlag) {
		this.regionFlag = regionFlag;
	}

	public String getClearingName() {
		return clearingName;
	}

	public void setClearingName(String clearingName) {
		this.clearingName = clearingName;
	}

	public String getTimeFlag() {
		return timeFlag;
	}

	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getClearTime() {
		return clearTime;
	}

	public void setClearTime(String clearTime) {
		this.clearTime = clearTime;
	}

	public String getClearStartTime() {
		return clearStartTime;
	}

	public void setClearStartTime(String clearStartTime) {
		this.clearStartTime = clearStartTime;
	}

	public String getClearEndTime() {
		return clearEndTime;
	}

	public void setClearEndTime(String clearEndTime) {
		this.clearEndTime = clearEndTime;
	}

}