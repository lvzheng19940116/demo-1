package ad.bean;

import java.util.Date;

public class AbOrderDetailsAssociated extends BaseCommonBeen{
    /**
	 * 
	 */
	private static final long serialVersionUID = 111L;

	private Integer id;

    private String orderId;

    private String orderDetailsTableName;

    private Integer adverId;

    private Integer proxyId;

    private Integer type;

    private Integer subProxyId;

    private Date createDate;
    
    private String appName;

    private String orderEquipIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetailsTableName() {
        return orderDetailsTableName;
    }

    public void setOrderDetailsTableName(String orderDetailsTableName) {
        this.orderDetailsTableName = orderDetailsTableName == null ? null : orderDetailsTableName.trim();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubProxyId() {
        return subProxyId;
    }

    public void setSubProxyId(Integer subProxyId) {
        this.subProxyId = subProxyId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getOrderEquipIds() {
        return orderEquipIds;
    }

    public void setOrderEquipIds(String orderEquipIds) {
        this.orderEquipIds = orderEquipIds == null ? null : orderEquipIds.trim();
    }
}