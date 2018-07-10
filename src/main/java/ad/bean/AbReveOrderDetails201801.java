package ad.bean;

import java.util.Date;

public class AbReveOrderDetails201801 {
    private Integer id;

    private Integer subProxyId;

    private String clickUserId;

    private Float earningsAmount;

    private Integer adverId;

    private Integer advertiserId;

    private String billingMethod;

    private String remark;

    private Date createTime;

    private String equipmentId;

    private Integer type;

    private Integer proxyId;

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

    public Float getEarningsAmount() {
        return earningsAmount;
    }

    public void setEarningsAmount(Float earningsAmount) {
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

    public String getBillingMethod() {
        return billingMethod;
    }

    public void setBillingMethod(String billingMethod) {
        this.billingMethod = billingMethod == null ? null : billingMethod.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getProxyId() {
        return proxyId;
    }

    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
    }
}