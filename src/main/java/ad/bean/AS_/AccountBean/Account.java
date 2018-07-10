package ad.bean.AS_.AccountBean;

public class Account {

	private Float CurrentEarnings;//当前收益
	private Float SettlementRevenue;//本次结算收益
	private String Datetime; //本次结算日期
	public Float getCurrentEarnings() {
		return CurrentEarnings;
	}
	public void setCurrentEarnings(Float currentEarnings) {
		CurrentEarnings = currentEarnings;
	}
	public Float getSettlementRevenue() {
		return SettlementRevenue;
	}
	public void setSettlementRevenue(Float settlementRevenue) {
		SettlementRevenue = settlementRevenue;
	}
	public String getDatetime() {
		return Datetime;
	}
	public void setDatetime(String datetime) {
		Datetime = datetime;
	}
	
	
	
}
