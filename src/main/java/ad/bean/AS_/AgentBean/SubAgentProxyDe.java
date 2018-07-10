package ad.bean.AS_.AgentBean;

import java.util.Date;

import ad.bean.BaseCommonBeen;

public class SubAgentProxyDe extends BaseCommonBeen{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4482550955180650397L;

	private Integer id;
	
	private Date createTime;
	private String creatTime;
	
	private Float earningsAmount;
	
	private String adverTitle;
	
	private String advertiserName;
	
	private Integer proxyId;

	@Override
	public String getAdverTitle() {
		return adverTitle;
	}
	@Override
	public void setAdverTitle(String adverTitle) {
		this.adverTitle = adverTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public Float getEarningsAmount() {
		return earningsAmount;
	}

	public void setEarningsAmount(Float earningsAmount) {
		this.earningsAmount = earningsAmount;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public Integer getProxyId() {
		return proxyId;
	}

	public void setProxyId(Integer proxyId) {
		this.proxyId = proxyId;
	}
	
	
	
}
