package com.bean;

public class Students {

    private Integer id;
    private  Integer sid;
    private String sName;
    private String sPassword;
    private String sClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

	@Override
	public String toString() {
		return "Students [id=" + id + ", sid=" + sid + ", sName=" + sName + ", sPassword=" + sPassword + ", sClass="
				+ sClass + "]";
	}

	public Students(Integer sid, String sName, String sPassword, String sClass) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.sPassword = sPassword;
		this.sClass = sClass;
	}

	public Students() {
		super();
	}
    
}
