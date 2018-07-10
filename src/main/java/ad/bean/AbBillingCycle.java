package ad.bean;

import java.util.Date;

public class AbBillingCycle {
    private Integer id;
    
    private Integer agentNumber;

    private Integer billingType;

    private Integer billingDay;

    private String settlementDate1;

    private String settlementDate2;

    private String settlementDate3;

    private String settlementDate4;
    
    private String remark;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(Integer agentNumber) {
		this.agentNumber = agentNumber;
	}

	public Integer getBillingType() {
        return billingType;
    }

    public void setBillingType(Integer billingType) {
        this.billingType = billingType;
    }

    public Integer getBillingDay() {
        return billingDay;
    }

    public void setBillingDay(Integer billingDay) {
        this.billingDay = billingDay;
    }

    public String getSettlementDate1() {
        return settlementDate1;
    }

    public void setSettlementDate1(String settlementDate1) {
        this.settlementDate1 = settlementDate1 == null ? null : settlementDate1.trim();
    }

    public String getSettlementDate2() {
        return settlementDate2;
    }

    public void setSettlementDate2(String settlementDate2) {
        this.settlementDate2 = settlementDate2 == null ? null : settlementDate2.trim();
    }

    public String getSettlementDate3() {
        return settlementDate3;
    }

    public void setSettlementDate3(String settlementDate3) {
        this.settlementDate3 = settlementDate3 == null ? null : settlementDate3.trim();
    }

    public String getSettlementDate4() {
        return settlementDate4;
    }

    public void setSettlementDate4(String settlementDate4) {
        this.settlementDate4 = settlementDate4 == null ? null : settlementDate4.trim();
    }
    
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}