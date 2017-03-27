package de.ndesign.javaland.cxf.rest.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListEntry {

	private String entry;
	private Date creationDate;

	@SuppressWarnings("unused")
	private ListEntry() {

	}

	public ListEntry(String entry, Date date) {
		this.setEntry(entry);
		this.setCreationDate(date);
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
