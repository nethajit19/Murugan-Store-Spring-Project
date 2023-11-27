package com.example.MuruganStores.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Chair {
	
	@Id
	private Integer chairno;
	private String chairname;
	private String storename;
	
	
	public Integer getChairno() {
		return chairno;
	}
	public void setChairno(Integer chairno) {
		this.chairno = chairno;
	}
	public String getChairname() {
		return chairname;
	}
	public void setChairname(String chairname) {
		this.chairname = chairname;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	
	

}
