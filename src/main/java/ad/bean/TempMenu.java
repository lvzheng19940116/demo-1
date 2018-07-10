package ad.bean;

import net.sf.json.JSONArray;

public class TempMenu {
	private Integer id;

	private String path;

	private String name;

	private String component;

	private String roleId;

	private String modularName;

	private JSONArray list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component == null ? null : component.trim();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public String getModularName() {
		return modularName;
	}

	public void setModularName(String modularName) {
		this.modularName = modularName == null ? null : modularName.trim();
	}

	public JSONArray getList() {
		return list;
	}

	public void setList(JSONArray list) {
		this.list = list;
	}
}