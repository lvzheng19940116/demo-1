package ad.bean;

import java.io.Serializable;
import java.util.Date;

public class AbAdvertProxyAssociation extends BaseCommonBeen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6126962872666803255L;

	private Integer id;

	private Integer adverId;

	private Integer proxyId;

	private Integer proxyGrade;

	private Integer fatherProxyId;

	private Date createTime;

	private Float distributionRatio;

	private String name;
	
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdverId() {
		return adverId;
	}

	public void setAdverId(Integer adverId) {
		this.adverId = adverId;
	}

	public Integer getProxyId() {
		return proxyId;
	}

	public void setProxyId(Integer proxyId) {
		this.proxyId = proxyId;
	}

	public Integer getProxyGrade() {
		return proxyGrade;
	}

	public void setProxyGrade(Integer proxyGrade) {
		this.proxyGrade = proxyGrade;
	}

	public Integer getFatherProxyId() {
		return fatherProxyId;
	}

	public void setFatherProxyId(Integer fatherProxyId) {
		this.fatherProxyId = fatherProxyId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Float getDistributionRatio() {
		return distributionRatio;
	}

	public void setDistributionRatio(Float distributionRatio) {
		this.distributionRatio = distributionRatio;
	}
}