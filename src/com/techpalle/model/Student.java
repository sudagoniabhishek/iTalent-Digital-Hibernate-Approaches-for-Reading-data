package com.techpalle.model;

import javax.persistence.*;

@Entity
public class Student {
	
	@Id
	private int sno;
	private String sname;
	private String sub;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public Student(int sno, String sname, String sub) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sub = sub;
	}
	public Student() {
		super();
		
	}
	
	

}
