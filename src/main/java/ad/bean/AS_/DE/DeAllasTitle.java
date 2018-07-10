package ad.bean.AS_.DE;

import java.util.Date;

public class DeAllasTitle {
	private Integer id;
	private Date CreateDate ;
	private Integer EarningsAmount;
	private String IncomeSource;
	private String AgentSource;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Integer getEarningsAmount() {
		return EarningsAmount;
	}
	public void setEarningsAmount(Integer earningsAmount) {
		EarningsAmount = earningsAmount;
	}
	
	public String getIncomeSource() {
		return IncomeSource;
	}
	public void setIncomeSource(String incomeSource) {
		IncomeSource = incomeSource;
	}
	public String getAgentSource() {
		return AgentSource;
	}
	public void setAgentSource(String agentSource) {
		AgentSource = agentSource;
	}
	public DeAllasTitle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
