package ad.bean;

import java.util.Date;

public class AbReveOrder extends BaseCommonBeen {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String orderNumber;
    
    private String proxyName;//用户账号
    
    private String proxyUserName;//用户名称
    
    private String proxyPhone;

    private Integer proxyId;

    private Float earningsAmount;

    private Integer adverId;

    private Integer advertiserId;

    private String billingMethod;

    private String remark;

    private Date createTime;

    private Integer type;

    private Integer subProxyId;
    
    private String appName;
    
    private String appPackageName;
    
    private String orderDetailsTableName;
    
    private Date orderDate;
    
    private String bankCardNumber;//银行卡号
    
    private String orderDateTime;//标准时间格式时间
    
    private String time;//订单产生时间的标准时间
    
    private String earningsAmountFlag;//金额标记
    
    private String regionFlag;//手机号，名称，ID标记
    
    private String regionName;//手机号，名称，ID输入的内容
    
    private String time1;//日期控件的启示日期(和计算当前收益的时候时间范围共用一个：开始的时间)
    
    private String time2;//日期控件的终止日期(和计算当前收益的时候时间范围共用一个：结束的时间)
    
    private String orderTime;//日期控件传过来的值
    
    private Float currentIncome;//佣金金额
    
    private Integer timeFlag;//4个时间摁钮的标记(0:昨日，1:前日，2:7天前，3:30天前)
    
    private String color;//颜色值
    
    private String adverTitle;//广告标题

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getProxyId() {
        return proxyId;
    }

    public void setProxyId(Integer proxyId) {
        this.proxyId = proxyId;
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

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppPackageName() {
		return appPackageName;
	}

	public void setAppPackageName(String appPackageName) {
		this.appPackageName = appPackageName;
	}

	public String getOrderDetailsTableName() {
		return orderDetailsTableName;
	}

	public void setOrderDetailsTableName(String orderDetailsTableName) {
		this.orderDetailsTableName = orderDetailsTableName;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProxyName() {
		return proxyName;
	}

	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}
	
	public String getProxyUserName() {
		return proxyUserName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getProxyPhone() {
		return proxyPhone;
	}

	public void setProxyPhone(String proxyPhone) {
		this.proxyPhone = proxyPhone;
	}

	public String getEarningsAmountFlag() {
		return earningsAmountFlag;
	}

	public void setEarningsAmountFlag(String earningsAmountFlag) {
		this.earningsAmountFlag = earningsAmountFlag;
	}

	public String getRegionFlag() {
		return regionFlag;
	}

	public void setRegionFlag(String regionFlag) {
		this.regionFlag = regionFlag;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Float getCurrentIncome() {
		return currentIncome;
	}

	public void setCurrentIncome(Float currentIncome) {
		this.currentIncome = currentIncome;
	}

	public Integer getTimeFlag() {
		return timeFlag;
	}

	public void setTimeFlag(Integer timeFlag) {
		this.timeFlag = timeFlag;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getAdverTitle() {
		return adverTitle;
	}

	@Override
	public void setAdverTitle(String adverTitle) {
		this.adverTitle = adverTitle;
	}
    
	
}