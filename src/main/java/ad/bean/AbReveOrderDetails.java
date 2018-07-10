package ad.bean;

import java.util.Date;

public class AbReveOrderDetails extends BaseCommonBeen{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private Integer id;

    private Integer subProxyId;//产生用户ID

    private String clickUserId;

    private Float earningsAmount;

    private Integer adverId;

    private Integer advertiserId;

    private String billingMethod;

    private String remark;

    private Date createTime;

    private String equipmentId;

    private Integer type;//产生钱的方式
    
    private Integer actionlogId;//SDK表的主键ID

    private Integer proxyId;//收益用户ID
    
    private String proxyName;//收益用户账号
    
    private String proxyUserName;//收益用户名称
    
    private String proxyPhone;//收益用户手机号
    
    private Float distributionRatio;//分佣比例
    
    private String subProxyUserName;//产生用户名称
    
    private String subProxyName;//产生用户名称
    
    private String subProxyPhone;//产生用户手机号
    
    private String time;//时间差生时间的标准日期
    
    private String appName;//app应用
    
    private String tableName;//动态的表名
    
    private String orderDate;//数据日期
    
    private String evenTime;//前台日期控件产生的时间
    
    private String evenStartTime;//前台日期控件产生开始的时间
    
    private String evenEndTime;//前台日期控件产生开始的时间

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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

	public String getProxyUserName() {
		return proxyUserName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getProxyName() {
		return proxyName;
	}

	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}

	public String getProxyPhone() {
		return proxyPhone;
	}

	public void setProxyPhone(String proxyPhone) {
		this.proxyPhone = proxyPhone;
	}

	public Float getDistributionRatio() {
		return distributionRatio;
	}

	public void setDistributionRatio(Float distributionRatio) {
		this.distributionRatio = distributionRatio;
	}

	public String getSubProxyUserName() {
		return subProxyUserName;
	}

	public void setSubProxyUserName(String subProxyUserName) {
		this.subProxyUserName = subProxyUserName;
	}

	public String getSubProxyName() {
		return subProxyName;
	}

	public void setSubProxyName(String subProxyName) {
		this.subProxyName = subProxyName;
	}

	public String getSubProxyPhone() {
		return subProxyPhone;
	}

	public void setSubProxyPhone(String subProxyPhone) {
		this.subProxyPhone = subProxyPhone;
	}

	public String getEvenTime() {
		return evenTime;
	}

	public void setEvenTime(String evenTime) {
		this.evenTime = evenTime;
	}

	public String getEvenStartTime() {
		return evenStartTime;
	}

	public void setEvenStartTime(String evenStartTime) {
		this.evenStartTime = evenStartTime;
	}

	public String getEvenEndTime() {
		return evenEndTime;
	}

	public void setEvenEndTime(String evenEndTime) {
		this.evenEndTime = evenEndTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getActionlogId() {
		return actionlogId;
	}

	public void setActionlogId(Integer actionlogId) {
		this.actionlogId = actionlogId;
	}
    
}