package ad.bean;

import java.util.Date;

public class AbAdvertAroxyAssociation {
    private Integer id;

    private Integer adverId;

    private Integer proxyId;

    private Integer proxyGrade;

    private Integer fatherProxyId;

    private Date createTime;

    private Float distributionRatio;

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