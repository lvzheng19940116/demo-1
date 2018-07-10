package ad.bean.AS_.AgentBean;

public class BTListAgent {

	private String name;
	private Float value;
	private String col;
	private String detailName;
	
	
	
	
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	public BTListAgent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BTListAgent(String proxyName, Float earningsAmount ,String col) {
		super();
		this.name = proxyName;
		this.value = earningsAmount;
		this.col = col;
	}
	
	
	
}
