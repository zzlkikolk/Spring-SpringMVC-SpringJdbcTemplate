package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Dao.ExroomDao;
import com.Dao.ItemsDao;
import com.Dao.ScoreDao;
import com.Dao.StudentDao;
import com.Dao.TeacherDao;
import com.bean.Exroom;
import com.bean.Items;
import com.bean.Score;
import com.bean.Students;

public class Main {
	public static void main(String[] args) {
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
//		ExroomDao dao=ctx.getBean(ExroomDao.class);
//		ScoreDao scoreDao=ctx.getBean(ScoreDao.class);
//		//Exroom exroom=dao.getExroomByClass("计应4班");
//		List<Score> list=scoreDao.getScoreByRid(exroom.getRid(),exroom.getExInforation());
//		System.out.println(list);
		
	}
}
