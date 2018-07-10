package ad.bean;

import java.io.Serializable;
import java.util.Date;

public class AbAdvertiser extends BaseCommonBeen implements Serializable {
 
	private static final long serialVersionUID = 1666042590517683585L;

	private Integer id;

    private String advertiserId;

    private String advertiserName;

    private String advertiserPhone;

    private String advertiserEmail;

    private String remark;

    private String advertiserProvince;

    private String advertiserCity;

    private Date createTime;

    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId == null ? null : advertiserId.trim();
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName == null ? null : advertiserName.trim();
    }

    public String getAdvertiserPhone() {
        return advertiserPhone;
    }

    public void setAdvertiserPhone(String advertiserPhone) {
        this.advertiserPhone = advertiserPhone == null ? null : advertiserPhone.trim();
    }

    public String getAdvertiserEmail() {
        return advertiserEmail;
    }

    public void setAdvertiserEmail(String advertiserEmail) {
        this.advertiserEmail = advertiserEmail == null ? null : advertiserEmail.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAdvertiserProvince() {
        return advertiserProvince;
    }

    public void setAdvertiserProvince(String advertiserProvince) {
        this.advertiserProvince = advertiserProvince == null ? null : advertiserProvince.trim();
    }

    public String getAdvertiserCity() {
        return advertiserCity;
    }

    public void setAdvertiserCity(String advertiserCity) {
        this.advertiserCity = advertiserCity == null ? null : advertiserCity.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}