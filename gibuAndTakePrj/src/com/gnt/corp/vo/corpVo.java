package com.gnt.corp.vo;

import java.sql.Timestamp;

public class corpVo {

	public corpVo() {}
	
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
	private int cno;
	private String content;
	private String classs;
	
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
	public void setDate(Timestamp date) {
		this.date = date;
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
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	
	@Override
	public String toString() {
		return "corpVo [no=" + no + ", clas=" + clas + ", regnum=" + regnum + ", name=" + name + ", id=" + id + ", pwd="
				+ pwd + ", nick=" + nick + ", email=" + email + ", addr=" + addr + ", phone=" + phone + ", date=" + date
				+ ", del=" + del + ", ban=" + ban + ", mod=" + mod + ", cno=" + cno + ", content=" + content
				+ ", classs=" + classs + "]";
	}
	
}
