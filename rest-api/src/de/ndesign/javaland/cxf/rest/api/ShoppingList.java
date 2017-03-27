package de.ndesign.javaland.cxf.rest.api;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShoppingList {
	private Integer id;
	private String user;
	private String description;
	private List<ListEntry> entries;

	@SuppressWarnings("unused")
	private ShoppingList() {
	}

	public ShoppingList(Integer id, String user, String description) {
		this.id = id;
		this.user = user;
		this.description = description;
		this.entries = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = new Integer(id);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ListEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ListEntry> entries) {
		this.entries = entries;
	}

}
