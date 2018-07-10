package ad.bean.AS_.AgentBean;

import ad.bean.BaseCommonBeen;

public class AgentsDo extends BaseCommonBeen{

	private Integer id;

    private String proxyName; //用户名称
    
    private String proxyUserName; //联系人姓名

    private String proxyPhone; //联系人电话
	
    private Integer offlineNumber; //拥有代理
    
    private Integer distributionRatio; //分佣比例
    
    private Float earningsAmount; //收益金额
    
    private Integer fatherId; //上线id

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
		this.proxyName = proxyName;
	}

	public String getProxyUserName() {
		return proxyUserName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getProxyPhone() {
		return proxyPhone;
	}

	public void setProxyPhone(String proxyPhone) {
		this.proxyPhone = proxyPhone;
	}

	public Integer getOfflineNumber() {
		return offlineNumber;
	}

	public void setOfflineNumber(Integer offlineNumber) {
		this.offlineNumber = offlineNumber;
	}

	public Float getEarningsAmount() {
		return earningsAmount;
	}

	public void setEarningsAmount(Float earningsAmount) {
		this.earningsAmount = earningsAmount;
	}

	public Integer getDistributionRatio() {
		return distributionRatio;
	}

	public void setDistributionRatio(Integer distributionRatio) {
		this.distributionRatio = distributionRatio;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}
    
    
    
}
