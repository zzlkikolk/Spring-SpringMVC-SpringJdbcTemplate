package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Dao.ExroomDao;
import com.Dao.ScoreDao;
import com.Dao.StudentDao;
import com.Dao.TeacherDao;
import com.bean.Exroom;
import com.bean.Items;
import com.bean.Score;
import com.bean.Students;
import com.bean.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 
 * @author 智霸霸
 *
 */
@SessionAttributes(value="x")
@Controller
public class Handler {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private ExroomDao exroomDao;
	@Autowired
	private ScoreDao scoreDao;
	@Autowired
	private Random random;
	private List<Items> list;
	
	/**
	 * 登录验证
	 * @param id
	 * @param password
	 * @param level
	 * @param map
	 * @return
	 */
    @RequestMapping("/Login")
    public String Login(Integer id,String password,String level,Map<String,Object> map){
    	if("1".equals(level)){
    		if(studentDao.checkStudent(id, password)!=null)
    		{
    			map.put("x",studentDao.checkStudent(id, password));
    			return "Sinterface";
    		}
    		else
    			return "redirect:/index.jsp";
    	}
    	else if("2".equals(level)){
    		if(teacherDao.CheckTeacher(id, password)!=null){
    			map.put("x",teacherDao.CheckTeacher(id, password));
    			return "Tinterface";
    			}
    		else
    			return "redirect:/index.jsp";
    		}
    	else{
    		Teacher teacher=teacherDao.CheckTeacher(id, password);
    		if(teacher.getPower()==1)
    		return "Ginterface";
    		else
    			return "redirect:/index.jsp";
    	}
    }
    /**
     * 老师安排考场
     * @return
     */
    @RequestMapping("/plan")
    public String Test2(Exroom exroom){
    	exroomDao.Insert(exroom);
    	return "Tinterface";
    }
    /**
     * 老师查询成绩(根据班级)
     * @param Class
     * @param map
     * @return
     */
    @RequestMapping("/look")
    public String Test3(String Class,String Item,Map<String,Object> map){
    	Exroom exroom=exroomDao.getExroomByClass(Class,Item);
    	System.out.println(exroom);
    	if(exroom!=null){
    	List<Score> list=scoreDao.getScoreByRid(exroom.getRid(),exroom.getExInforation());
    	if(list!=null)
    	map.put("ClassScore",list);
    	}
    	else
    		map.put("ClassScore",null);
    	return "Tinterface";
    }
    /**
     * 学生查询成绩
     * @param sid
     * @param map
     * @return
     */
    @RequestMapping("/slook")
    public String STest(Integer sid,Map<String,Object> map){
    	List<Score> list=scoreDao.getScoreBysid(sid);
    	if(list!=null)
    		map.put("studentScore",list);
    	else
    		map.put("studentScore", null);
    	return "Sinterface";
    }
    /**
     * 
     * 学生查询未考科目
     * 如果错过考试时间，将不允许参加考试
     * @param sid
     * @param sClass
     * @param map
     * @return
     */
    @RequestMapping("/nolook")
    public String STest2(Integer sid,String sClass,Map<String,Object> map){
    	List<Score> list_1=scoreDao.getScoreBysid(sid);
    	List<Exroom> list_2=exroomDao.getExroomEByClass(sClass);
    	for(int i=0;i<list_1.size();i++){
    		for(int j=0;j<list_2.size();j++)
    			if(list_1.get(i).getItemName().equals(list_2.get(j).getExInforation()))
    				list_2.remove(j);
    	}
    	map.put("nottest",list_2);
    	return "Sinterface";
    }
    
    /**
     * 计算考试成绩
     * @param request
     * @param sClass
     * @param ItemName
     * @param Rid
     * @param sid
     * @return
     */
    @RequestMapping("/count")
    public String online(HttpServletRequest request,String sClass,String ItemName,Integer Rid,Integer sid){
    	int COUNT=0;
    	List<String> list=new ArrayList<String>();
    	List<String> right=new ArrayList<String>();
    	for(int i=0;i<5;i++){
    		String a=request.getParameter("A"+i);
    		String b=request.getParameter("B"+i);
    		list.add(a);
    		right.add(b);
    	}
    	for(int i=0;i<list.size();i++)
    	if(list.get(i).equals(right.get(i))){
    		COUNT++;
    	}
    	int score=COUNT*20;
    	Score sc=new Score(sid,Rid,score,ItemName);
    	scoreDao.InsertScore(sc);
    	return "Sinterface";
    }
    
    /**
     * 跳转至考试页面
     * @param rid
     * @param map
     * @return
     */
    @RequestMapping("/onlineTest/{id}")
    public String onlineTest(@PathVariable(value="id") Integer rid,Map<String,Object> map){
    	String ItemName=exroomDao.getExroomByRid(rid).getExInforation();
    	 list=random.getItems(ItemName);
    	map.put("items", list);
    	map.put("rid",rid);
    	return "onlineTest";
    }
    
}
