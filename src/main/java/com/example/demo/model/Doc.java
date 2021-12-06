package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="docs")
public class Doc {
	@Id
	private Integer id;
	
	private String docName;
	private String docType;
	private String channel;
	
	@Lob
	private byte[] data;
	
	public Doc() {}

	public Doc(String channel,Integer id, String docName, String docType, byte[] data) {
		super();
		this.channel=channel;
		this.id=id;
		this.docName = docName;
		this.docType = docType;
		this.data = data;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
