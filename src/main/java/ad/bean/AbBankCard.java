package ad.bean;

import java.util.Date;

public class AbBankCard {
    private Integer id;

    private Integer proxyId;

    private String bankCardNumber;

    private String bankAccountName;

    private String bankName;

    private String bankBranchesName;

    private String bankReservePhone;

    private Date createTime;
    
    private Integer deleteFlag;
    
    private String date;//前台的时间
    
    private String proxyUserId;//身份证号
    
    private String proxyUserContacts;//所属人

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProxyId() {
        return proxyId;
    }

    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankBranchesName() {
        return bankBranchesName;
    }

    public void setBankBranchesName(String bankBranchesName) {
        this.bankBranchesName = bankBranchesName == null ? null : bankBranchesName.trim();
    }

    public String getBankReservePhone() {
        return bankReservePhone;
    }

    public void setBankReservePhone(String bankReservePhone) {
        this.bankReservePhone = bankReservePhone == null ? null : bankReservePhone.trim();
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProxyUserId() {
		return proxyUserId;
	}

	public void setProxyUserId(String proxyUserId) {
		this.proxyUserId = proxyUserId == null ? null : proxyUserId.trim();
	}

	public String getProxyUserContacts() {
		return proxyUserContacts;
	}

	public void setProxyUserContacts(String proxyUserContacts) {
		this.proxyUserContacts = proxyUserContacts == null ? null : proxyUserContacts.trim();
	}
	
	
    
}