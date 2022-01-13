package com.mega;

import java.sql.Timestamp;

public class MemberData {
	private int idx;
	private String userid;
	private String name;
	private String email;
	private String address;
	private Timestamp wdate;
	private int stat;
	
	public MemberData(int idx, String userid, String name, String email, String address, Timestamp wdate, int stat) {
		this.idx = idx;
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.wdate = wdate;
		this.stat = stat;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}
	
	
}
