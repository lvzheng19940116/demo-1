package ad.bean;

import java.util.Date;

public class AbStatisticsDay {
    private Integer id;

    private Integer adverId;

    private Integer advertiserId;

    private Integer proxyId;

    private Long clickNum;

    private Long showNum;

    private Integer equipNum;

    private Float adverCosts;

    private Date createDate;

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

    public Integer getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Integer advertiserId) {
        this.advertiserId = advertiserId;
    }

    public Integer getProxyId() {
        return proxyId;
    }

    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
    }

    public Long getClickNum() {
        return clickNum;
    }

    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    public Long getShowNum() {
        return showNum;
    }

    public void setShowNum(Long showNum) {
        this.showNum = showNum;
    }

    public Integer getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(Integer equipNum) {
        this.equipNum = equipNum;
    }

    public Float getAdverCosts() {
        return adverCosts;
    }

    public void setAdverCosts(Float adverCosts) {
        this.adverCosts = adverCosts;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}