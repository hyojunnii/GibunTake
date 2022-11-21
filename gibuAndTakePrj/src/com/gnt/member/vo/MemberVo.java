package com.gnt.member.vo;

import java.sql.Timestamp;

public class MemberVo {
	
	
	public MemberVo() {
	
	}
	
	
	public MemberVo(int no, int clas, String regnum, String name, String id, String pwd, String nick, String email,
			String addr, String phone, Timestamp date, String del, String ban, Timestamp mod) {
		this.no = no;
		this.clas = clas;
		this.regnum = regnum;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.email = email;
		this.addr = addr;
		this.phone = phone;
		this.date = date;
		this.del = del;
		this.ban = ban;
		this.mod = mod;
	}


	private int no;
	private int clas;
	private String regnum;
	private String name;
	private String id;
	private String pwd;
	private String nick;
	private String email;
	private String addr;
	private String phone;
	private Timestamp date;
	private String del;
	private String ban;
	private Timestamp mod;
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getClas() {
		return clas;
	}


	public void setClas(int clas) {
		this.clas = clas;
	}


	public String getRegnum() {
		return regnum;
	}


	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp enrolDate) {
		this.date = enrolDate;
	}


	public String getDel() {
		return del;
	}


	public void setDel(String del) {
		this.del = del;
	}


	public String getBan() {
		return ban;
	}


	public void setBan(String ban) {
		this.ban = ban;
	}


	public Timestamp getMod() {
		return mod;
	}


	public void setMod(Timestamp mod) {
		this.mod = mod;
	}

	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", clas=" + clas + ", regnum=" + regnum + ", name=" + name + ", id=" + id
				+ ", pwd=" + pwd + ", nick=" + nick + ", email=" + email + ", addr=" + addr + ", phone=" + phone
				+ ", date=" + date + ", del=" + del + ", ban=" + ban + ", mod=" + mod + "]";
	}
	
	 
	
	
	
	
}


