package ad.bean;

import java.io.Serializable;

public class TreeBeen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -101259141647220422L;
	public String id;
	
	@Override
	public String toString() {
		return "TreeBeen [id=" + id + ", label=" + label + "]";
	}
	public String label;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
