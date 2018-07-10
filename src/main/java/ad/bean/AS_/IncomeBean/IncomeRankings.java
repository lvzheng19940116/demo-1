package ad.bean.AS_.IncomeBean;

public class IncomeRankings {
	
	private String topid;
	private String topname;
	private Integer topmn;
	public String getTopid() {
		return topid;
	}
	public void setTopid(String topid) {
		this.topid = topid;
	}
	public String getTopname() {
		return topname;
	}
	public void setTopname(String topname) {
		this.topname = topname;
	}
	public Integer getTopmn() {
		return topmn;
	}
	public void setTopmn(Integer topmn) {
		this.topmn = topmn;
	}
	public IncomeRankings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IncomeRankings(String topid, String topname, Integer topmn) {
		super();
		this.topid = topid;
		this.topname = topname;
		this.topmn = topmn;
	}
	

      
}
