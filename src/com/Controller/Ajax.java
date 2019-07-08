package com.Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.Dao.StudentDao;
import com.Dao.TeacherDao;

/**
 * Servlet implementation class Ajax
 */
@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		ServletContext application = getServletContext();
		ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(application);
		StudentDao studentDao=ctx.getBean(StudentDao.class);
		TeacherDao teacherDao=ctx.getBean(TeacherDao.class);
		String a=request.getParameter("sid");				
		String b=request.getParameter("tid");
		if(a!=null||" ".equals(a)){
			Integer sid=Integer.valueOf(a);
			//System.out.println(sid);
			if(studentDao.getStudentBySid(sid)==null)
				response.getWriter().print("<font color='green'>可以使用</font>");
			else if(studentDao.getStudentBySid(sid)!=null)
				response.getWriter().print("<font color='red'>已经存在</font>");
		}
		if(b!=null||" ".equals(b)){
			Integer tid=Integer.valueOf(b);
			System.out.println(tid);
			if(teacherDao.getTeacherByTid(tid)==null)
				response.getWriter().print("<font color='green'>可以使用</font>");
			else if(teacherDao.getTeacherByTid(tid)!=null)
				response.getWriter().print("<font color='red'>已经存在</font>");
		}
	}

}
