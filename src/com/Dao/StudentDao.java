package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Students;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    public Students getStudentBySid(Integer sid){
    	String sql="select * from students where sid=?";
    	try{
    		RowMapper<Students> mapper=new BeanPropertyRowMapper<Students>(Students.class);
    		Students student=jdbcTemplate.queryForObject(sql, mapper,sid);
    		return student;
    	}catch (Exception e) {
    		return null;
		}
		
    	
    }
    public boolean Update(Students student){
    	String sql="update students set sPassword=? where sid=?";
    	try{
    	jdbcTemplate.update(sql, student.getsPassword(),student.getSid());
    	return true;
    	}catch (Exception e) {
    		return false;
		}
		
    	
    }
    public Students checkStudent(Integer sid,String password){
    	String sql="select * from students where sid=? and spassword=?";
    	try{
    		RowMapper<Students> mapper=new BeanPropertyRowMapper<Students>(Students.class);
    		Students student=jdbcTemplate.queryForObject(sql, mapper,sid,password);
    		return student;
    	}catch (Exception e) {
			return null;
		}
    	
    }
    public boolean studentInsert(Students student){
    	String sql="insert into students(sid,sname,spassword,sclass) values(?,?,?,?)";
    	String sql2="select sid from students where sid=?";
    	RowMapper<Students> mapper=new BeanPropertyRowMapper<Students>(Students.class);
    	try{
    		Students stu=jdbcTemplate.queryForObject(sql2,mapper,student.getSid());
    	}catch (Exception e) {
			jdbcTemplate.update(sql, student.getSid(),student.getsName(),student.getsPassword(),student.getsClass());
			return true;
		}
		return false;
    	
    }

}
