package ad.bean;

import java.util.Date;

public class AbSdkClickActionlog {
    private Integer id;
    
    private String clickUserId;

    private String equipmentId;

    private Integer adverId;

    private Integer advertiserId;
    
    private Integer actionlogId;

    private Integer clickNum;

    private Integer showNum;

    private Float earnings_amount;

    private String appName;

    private Date createTime;

    private Integer proxyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClickUserId() {
        return clickUserId;
    }

    public void setClickUserId(String clickUserId) {
        this.clickUserId = clickUserId == null ? null : clickUserId.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
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

    public Integer getActionlogId() {
		return actionlogId;
	}

	public void setActionlogId(Integer actionlogId) {
		this.actionlogId = actionlogId;
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

    public Float getEarnings_amount() {
		return earnings_amount;
	}

	public void setEarnings_amount(Float earnings_amount) {
		this.earnings_amount = earnings_amount;
	}

	public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProxyId() {
        return proxyId;
    }

    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
    }
}