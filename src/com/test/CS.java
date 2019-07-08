package com.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bean.Items;

public class CS {

	private ApplicationContext ctx=null;
	private JdbcTemplate jdbcTemplate=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate=ctx.getBean(JdbcTemplate.class);
	}
	@Test
	public void test(){
		String sql="select * from items where ItemName=?";
		RowMapper<Items> rowMapper=new BeanPropertyRowMapper<Items>(Items.class);
		Items items=jdbcTemplate.queryForObject(sql, rowMapper,"Java");
		System.out.println(items);
	}
	

}
