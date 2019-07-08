package com.Dao;

import com.bean.Items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ItemsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
    public List<Items> getItems(String ItemName){
    	String sql="select * from items where itemName=?";
    	RowMapper<Items> rowMapper=new BeanPropertyRowMapper<Items>(Items.class);
    	try{
    	List<Items> list=jdbcTemplate.query(sql, rowMapper,ItemName);
    	return list;
    	}catch (Exception e) {
			return null;
		}
    }
    public boolean Insert(Items iteam){
    	String sql="insert into items(iteamName,item,Achoice,Bchoice,Cchoice,rightKey) values(?,?,?,?,?)";
    	try{
    		jdbcTemplate.update(sql, iteam.getItemName(),iteam.getItem(),iteam.getAchoice(),iteam.getBchoice(),iteam.getCchoice(),iteam.getRightKey());
    		return true;
    	}catch (Exception e) {
			return false;
		}
    }
}
