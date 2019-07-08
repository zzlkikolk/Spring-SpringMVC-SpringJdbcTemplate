package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Exroom;
import com.bean.Score;

@Repository
public class ExroomDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
    public boolean Insert(Exroom room){
    	String sql="insert into exroom(rid,time,exinforation,duration,eclass) values(?,?,?,?,?)";
    	String sql2="select * from exroom where rid=?";
    	try{
    		RowMapper<Exroom> mapper=new BeanPropertyRowMapper<Exroom>(Exroom.class);
    		Exroom exroom=jdbcTemplate.queryForObject(sql, mapper,room.getRid());
    		return false;
    	}catch (Exception e) {
    		jdbcTemplate.update(sql, room.getRid(),room.getTime(),room.getExInforation(),room.getDuration(),room.getEclass());
    		return true;
		}

    	
    }
    public boolean UpdateExroom(Exroom room){
    	String sql="update exroom set time=?,duration=?,exinforation=?,rid=?where rid=?";
    	try{
    	jdbcTemplate.update(sql,room.getTime(),room.getDuration(),room.getExInforation(),room.getRid());
    	return true;
    	}catch (Exception e) {
    		return false;
		}
    	
    }
    public Exroom getExroomByRid(Integer Rid){
    	String sql="select * from exroom where rid=?";
    	try{
    		RowMapper<Exroom> mapper=new BeanPropertyRowMapper<Exroom>(Exroom.class);
    		Exroom exroom=jdbcTemplate.queryForObject(sql, mapper,Rid);
    		return exroom;
    	}catch (Exception e) {
    		return null;
		}		
    	
    }
    public Exroom getExroomByClass(String eclass,String Item){
    	String sql="select * from exroom where eclass=? and exinforation=?";
    	try{
    		RowMapper<Exroom> mapper=new BeanPropertyRowMapper<Exroom>(Exroom.class);
    		Exroom exroom=jdbcTemplate.queryForObject(sql, mapper,eclass,Item);
    		return exroom;
    	}catch (Exception e) {
    		return null;
		}		
    	
    }
    public List<Exroom> getExroomEByClass(String eclass){
    	String sql="select * from exroom where eclass=?";
    	try{
    		RowMapper<Exroom> mapper=new BeanPropertyRowMapper<Exroom>(Exroom.class);
    		List<Exroom> list=jdbcTemplate.query(sql, mapper,eclass);
    		return list;
    	}catch (Exception e) {
    		return null;
		}		
    	
    }

}
