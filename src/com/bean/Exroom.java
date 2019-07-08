package com.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Exroom {
    private Integer id;
    private Integer Rid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Time;
    private String ExInforation;
    private Integer Duration;//考试时间
    private String Eclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getExInforation() {
        return ExInforation;
    }

    public void setExInforation(String exInforation) {
        ExInforation = exInforation;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public String getEclass() {
        return Eclass;
    }

    public void setEclass(String eclass) {
        Eclass = eclass;
    }

	@Override
	public String toString() {
		return "Exroom [id=" + id + ", Rid=" + Rid + ", Time=" + Time + ", ExInforation=" + ExInforation + ", Duration="
				+ Duration + ", Eclass=" + Eclass + "]";
	}
}
