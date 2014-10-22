package com.tcheckit.vo;

import java.util.Date;

import com.fortutech.tcheckit.ejb.sessions.UserAccount;

public class Tchecker {
	private static Tchecker tck = null;
	
	public static Tchecker getInstance() {
		if (tck == null) {
			tck = new Tchecker();
		}
		return tck;
	}
	
	public Tchecker() {
		
	}
	
	private String id = null;
	private String first_name = null;
	private String last_name = null;
	private String mail = null;
	private String sex = null;
	private Date birth = null;
	private UserAccount UA = null;

	public UserAccount getUA() {
		return UA;
	}

	public void setUA(UserAccount uA) {
		UA = uA;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
