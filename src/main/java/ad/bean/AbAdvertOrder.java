package ad.bean;

import java.io.Serializable;
import java.util.Date;

public class AbAdvertOrder extends BaseBeen implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1667643201045592487L;

	private Integer id;

    private String orderName;

    private String salesUser;

    private String advertiserId;

    private Integer adverPosition;

    private Date startTime;

    private Date endTime;

    private String billingMethod;

    private Float totalAdverSales;

    private Float totalAdverManage;

    private String attachmentAddress;

    private Date createTime;

    private Integer deleteFlag;

    private String orderId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getSalesUser() {
        return salesUser;
    }

    public void setSalesUser(String salesUser) {
        this.salesUser = salesUser == null ? null : salesUser.trim();
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId == null ? null : advertiserId.trim();
    }

    public Integer getAdverPosition() {
        return adverPosition;
    }

    public void setAdverPosition(Integer adverPosition) {
        this.adverPosition = adverPosition;
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

    public String getBillingMethod() {
        return billingMethod;
    }

    public void setBillingMethod(String billingMethod) {
        this.billingMethod = billingMethod == null ? null : billingMethod.trim();
    }

    public Float getTotalAdverSales() {
        return totalAdverSales;
    }

    public void setTotalAdverSales(Float totalAdverSales) {
        this.totalAdverSales = totalAdverSales;
    }

    public Float getTotalAdverManage() {
        return totalAdverManage;
    }

    public void setTotalAdverManage(Float totalAdverManage) {
        this.totalAdverManage = totalAdverManage;
    }

    public String getAttachmentAddress() {
        return attachmentAddress;
    }

    public void setAttachmentAddress(String attachmentAddress) {
        this.attachmentAddress = attachmentAddress == null ? null : attachmentAddress.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}