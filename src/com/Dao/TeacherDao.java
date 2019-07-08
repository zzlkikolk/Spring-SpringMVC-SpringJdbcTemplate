package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Teacher;

@Repository
public class TeacherDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
    public Teacher getTeacherByTid(Integer tid){
    	String sql="select * from teacher where tid=?";
    	try{
    		RowMapper<Teacher> mapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
    		Teacher teacher=jdbcTemplate.queryForObject(sql, mapper,tid);
    		return teacher;
    	}catch (Exception e) {
    		return null;
		}    	
    }
    public boolean teacherInsert(Teacher teacher){
    	String sql="Insert into teacher(tid,tname,tpassword,power)";
    	String sql2="select * from teacher where tid";
    	try{
    		RowMapper<Teacher> mapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
    		Teacher t=jdbcTemplate.queryForObject(sql2, mapper,teacher.getTid());
    		return false;
    	}catch (Exception e) {
    		jdbcTemplate.update(sql, teacher.getTid(),teacher.gettName(),teacher.gettPassword(),teacher.getPower());
    		return true;
		}
		
    	
    }
    public Teacher CheckTeacher(Integer Tid,String Tpassword){
    	String sql="select * from teacher where tid=? and tpassword=?";
    	try{
    		RowMapper<Teacher> mapper=new BeanPropertyRowMapper<Teacher>(Teacher.class);
    		Teacher teacher=jdbcTemplate.queryForObject(sql, mapper,Tid,Tpassword);
    		return teacher;
    	}catch (Exception e) {
    		return null;    	
    	}
    }
}
