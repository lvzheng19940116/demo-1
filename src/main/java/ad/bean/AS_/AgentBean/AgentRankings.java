package ad.bean.AS_.AgentBean;

public class AgentRankings {
	
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
	public AgentRankings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AgentRankings(String topid, String topname, Integer topmn) {
		super();
		this.topid = topid;
		this.topname = topname;
		this.topmn = topmn;
	}
	

      
}
