package ad.bean.AS_.IncomeBean;

public class Incomes {

	private String name ;
	private Integer value;
	private String col;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Incomes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Incomes(String name, Integer value, String col) {
		super();
		this.name = name;
		this.value = value;
		this.col = col;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	
	
	
}
