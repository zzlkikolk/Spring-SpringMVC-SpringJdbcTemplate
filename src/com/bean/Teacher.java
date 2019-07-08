package com.bean;

public class Teacher {
    private Integer id;
    private Integer Tid;
    private String tName;
    private String tPassword;
    private Integer Power;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return Tid;
    }

    public void setTid(Integer tid) {
        Tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    public Integer getPower() {
        return Power;
    }

    public void setPower(Integer power) {
        Power = power;
    }

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", Tid=" + Tid + ", tName=" + tName + ", tPassword=" + tPassword + ", Power="
				+ Power + "]";
	}
    
}
