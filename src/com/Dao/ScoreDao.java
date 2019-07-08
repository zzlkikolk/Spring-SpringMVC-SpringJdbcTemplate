package com.Dao;

import com.bean.Score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class ScoreDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Score score=null;
    public List<Score> getScoreByRid(Integer Rid,String ItemName){
    	String sql="select * from score where rid=? and ItemName=?";
    	try{
    	RowMapper<Score> mapper=new BeanPropertyRowMapper<Score>(Score.class);
    	List<Score> list=jdbcTemplate.query(sql, mapper,Rid,ItemName);
    	return list;
    	}catch (Exception e) {
    		return null;
		}
    }
        public List<Score> getScoreBysid(Integer sid){
        	String sql="select * from score where sid=?";
        	try{
        	RowMapper<Score> mapper=new BeanPropertyRowMapper<Score>(Score.class);
        	List<Score> list=jdbcTemplate.query(sql, mapper,sid);
        	return list;
        	}catch (Exception e) {
        		return null;
    		}
    }
    public Score getScoreBySid(Integer Sid){
    	String sql="select * from score where sid=?";
    	try{
    		RowMapper<Score> mapper=new BeanPropertyRowMapper<Score>(Score.class);
    		 score=jdbcTemplate.queryForObject(sql, mapper,Sid);
    		return score;
    	}catch (Exception e) {
    		return null;
		}
		
    	//通过学号来查找成绩
    }
    public boolean InsertScore(Score score){
    	String sql="select * from score where sid=? and ItemName=?";
    	String sql2="insert into score(sid,rid,score,ItemName) values(?,?,?,?)";
    	try{
    		RowMapper<Score> mapper=new BeanPropertyRowMapper<Score>(Score.class);
    		this.score=jdbcTemplate.queryForObject(sql, mapper,score.getSid(),score.getItemName());
    		return false;
    	}catch (Exception e) {
    		jdbcTemplate.update(sql2,score.getSid(),score.getRid(),score.getScore(),score.getItemName());
			return true;
		}
		
    	//添加一条成绩
    }
}
