package ad.bean;

import java.io.Serializable;
import java.util.Date;

public class AbAdver extends BaseBeen implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 537586429261433679L;

	private Integer id;

    private String adverId;

    private String adverTitle;

    private Integer adverStatus;

    private String advertiserId;

    private String remark;

    private Integer adverPosition;

    private String billingMethod;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Float totalAdverPrice;
    
    private Float surplusAdverPrice;//剩余总额

    private Float adUnitPrice;

    private Long numberClicks;

    private Long surplusNumberClicks;
    
    private Long impressions;

    private Float dividedProp;

    private String adverType;

    private String adverFile1Url;

    private String adverFile2Url;

    private String adverFile3Url;

    private String imgResolution1;

    private String imgResolution2;

    private String imgResolution3;

    private String jumpLink;

    private String thirdMonitor;

    private Integer status;

    private String auditReasons;

    private Float remainingPrice;

    private Integer ftpStatus;

    private Integer deleteFlag;

    private Integer islink;

    private Integer billingMethodWay;

    private String name;

    private String provCn;

    private String agency;
    
    private Integer changeFlag;//上线后的广告是否存在变动

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdverId() {
        return adverId;
    }

    public void setAdverId(String adverId) {
        this.adverId = adverId == null ? null : adverId.trim();
    }

    public String getAdverTitle() {
        return adverTitle;
    }

    public void setAdverTitle(String adverTitle) {
        this.adverTitle = adverTitle == null ? null : adverTitle.trim();
    }

    public Integer getAdverStatus() {
        return adverStatus;
    }

    public void setAdverStatus(Integer adverStatus) {
        this.adverStatus = adverStatus;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId == null ? null : advertiserId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAdverPosition() {
        return adverPosition;
    }

    public void setAdverPosition(Integer adverPosition) {
        this.adverPosition = adverPosition;
    }

    public String getBillingMethod() {
        return billingMethod;
    }

    public void setBillingMethod(String billingMethod) {
        this.billingMethod = billingMethod == null ? null : billingMethod.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getTotalAdverPrice() {
        return totalAdverPrice;
    }

	public Float getSurplusAdverPrice() {
		return surplusAdverPrice;
	}

	public void setSurplusAdverPrice(Float surplusAdverPrice) {
		this.surplusAdverPrice = surplusAdverPrice;
	}

	public void setTotalAdverPrice(Float totalAdverPrice) {
        this.totalAdverPrice = totalAdverPrice;
    }

    public Float getAdUnitPrice() {
        return adUnitPrice;
    }

    public void setAdUnitPrice(Float adUnitPrice) {
        this.adUnitPrice = adUnitPrice;
    }

    public Long getNumberClicks() {
        return numberClicks;
    }

    public void setNumberClicks(Long numberClicks) {
        this.numberClicks = numberClicks;
    }

    public Long getSurplusNumberClicks() {
		return surplusNumberClicks;
	}

	public void setSurplusNumberClicks(Long surplusNumberClicks) {
		this.surplusNumberClicks = surplusNumberClicks;
	}

	public Long getImpressions() {
        return impressions;
    }

    public void setImpressions(Long impressions) {
        this.impressions = impressions;
    }

    public Float getDividedProp() {
        return dividedProp;
    }

    public void setDividedProp(Float dividedProp) {
        this.dividedProp = dividedProp;
    }

    public String getAdverType() {
        return adverType;
    }

    public void setAdverType(String adverType) {
        this.adverType = adverType == null ? null : adverType.trim();
    }

    public String getAdverFile1Url() {
        return adverFile1Url;
    }

    public void setAdverFile1Url(String adverFile1Url) {
        this.adverFile1Url = adverFile1Url == null ? null : adverFile1Url.trim();
    }

    public String getAdverFile2Url() {
        return adverFile2Url;
    }

    public void setAdverFile2Url(String adverFile2Url) {
        this.adverFile2Url = adverFile2Url == null ? null : adverFile2Url.trim();
    }

    public String getAdverFile3Url() {
        return adverFile3Url;
    }

    public void setAdverFile3Url(String adverFile3Url) {
        this.adverFile3Url = adverFile3Url == null ? null : adverFile3Url.trim();
    }

    public String getImgResolution1() {
        return imgResolution1;
    }

    public void setImgResolution1(String imgResolution1) {
        this.imgResolution1 = imgResolution1 == null ? null : imgResolution1.trim();
    }

    public String getImgResolution2() {
        return imgResolution2;
    }

    public void setImgResolution2(String imgResolution2) {
        this.imgResolution2 = imgResolution2 == null ? null : imgResolution2.trim();
    }

    public String getImgResolution3() {
        return imgResolution3;
    }

    public void setImgResolution3(String imgResolution3) {
        this.imgResolution3 = imgResolution3 == null ? null : imgResolution3.trim();
    }

    public String getJumpLink() {
        return jumpLink;
    }

    public void setJumpLink(String jumpLink) {
        this.jumpLink = jumpLink == null ? null : jumpLink.trim();
    }

    public String getThirdMonitor() {
        return thirdMonitor;
    }

    public void setThirdMonitor(String thirdMonitor) {
        this.thirdMonitor = thirdMonitor == null ? null : thirdMonitor.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditReasons() {
        return auditReasons;
    }

    public void setAuditReasons(String auditReasons) {
        this.auditReasons = auditReasons == null ? null : auditReasons.trim();
    }

    public Float getRemainingPrice() {
        return remainingPrice;
    }

    public void setRemainingPrice(Float remainingPrice) {
        this.remainingPrice = remainingPrice;
    }

    public Integer getFtpStatus() {
        return ftpStatus;
    }

    public void setFtpStatus(Integer ftpStatus) {
        this.ftpStatus = ftpStatus;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getIslink() {
        return islink;
    }

    public void setIslink(Integer islink) {
        this.islink = islink;
    }

    public Integer getBillingMethodWay() {
        return billingMethodWay;
    }

    public void setBillingMethodWay(Integer billingMethodWay) {
        this.billingMethodWay = billingMethodWay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvCn() {
        return provCn;
    }

    public void setProvCn(String provCn) {
        this.provCn = provCn == null ? null : provCn.trim();
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency == null ? null : agency.trim();
    }

	public Integer getChangeFlag() {
		return changeFlag;
	}

	public void setChangeFlag(Integer changeFlag) {
		this.changeFlag = changeFlag;
	}
    
    
}