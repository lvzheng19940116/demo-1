package ad.bean.AS_.AgentBean;

public class BTListIncome {
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
	public BTListIncome(String name, Float value ,String col) {
		super();
		this.name = name;
		this.value = value;
		this.col = col;
	}
	public BTListIncome() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
