package zijin.servlet;

/**
 * 文件名：ManagementTeacher.java
 * 作用：老师信息管理
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zijin.IF.ManagementTeacherIF;
import zijin.bean.Teacher;
import zijin.factory.DaoFactory;

/**
 * Servlet implementation class ManagementTeacher
 */
@WebServlet("/ManagementTeacher")
public class ManagementTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myway(request, response);
	}

	private void myway(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		switch(method)
		{
		      case "addTeacher"    : addTeacher(request, response);     break;
		      case "deleteTeacher" : deleteTeacher(request, response);  break;
		      case "updateTeacher" : updateTeacher(request, response);  break;
		      case "findTeacher"   : findTeacher(request, response);    break;
		}
	}

	private void findTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ManagementTeacherIF mt = DaoFactory.getManagementTeacherDaoInstance();
		List<Teacher> list = mt.findteacher();
		request.getSession().setAttribute("teacherList", list);
		response.sendRedirect("admin/findTeacher.jsp"); 
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Teacher tc = new Teacher();
		tc.setTid(request.getParameter("tid"));
		tc.setTname(request.getParameter("tname"));
		tc.setSex(request.getParameter("sex"));
		tc.setPhone(request.getParameter("phone"));
		tc.setAddress(request.getParameter("address"));
		tc.setBirthdate(request.getParameter("birthdate"));
		tc.setEmail(request.getParameter("email"));
		ManagementTeacherIF mt = DaoFactory.getManagementTeacherDaoInstance();
		boolean result = mt.updateteacher(tc);
		PrintWriter   out   =   response.getWriter(); 
		if(result){
		     List<Teacher> list = mt.findteacher();
		     request.getSession().setAttribute("teacherList", list);
		     out.println("<script>alert('修改成功!');</script>");
             out.println("<script>window.location.href='/ZijinQuestionBankSystem/admin/findTeacher.jsp'</script>");
		}
		else
		{
			out.println("<script>alert('修改失败!');history.back();</script>");
		}
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tid= request.getParameter("tid");
		ManagementTeacherIF mt = DaoFactory.getManagementTeacherDaoInstance();
		boolean result = mt.deleteteacher(tid);
		PrintWriter   out   =   response.getWriter(); 
		if(result){
		     List<Teacher> list = mt.findteacher();
		     request.getSession().setAttribute("teacherList", list);
		     out.println("<script>alert('删除成功!');</script>");
             out.println("<script>window.location.href='/ZijinQuestionBankSystem/admin/findTeacher.jsp'</script>");
		}
		else
		{
			out.println("<script>alert('删除失败!');history.back();</script>");
		}
	}

	private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Teacher tc = new Teacher();
		tc.setTname(request.getParameter("tname"));
		tc.setTid(request.getParameter("tid"));
		tc.setPwd(request.getParameter("pwd"));
		tc.setSex(request.getParameter("sex"));
		tc.setPhone(request.getParameter("phone"));
		tc.setAddress(request.getParameter("address"));
		tc.setBirthdate(request.getParameter("birthdate"));
		tc.setEmail(request.getParameter("email"));
		ManagementTeacherIF mt = DaoFactory.getManagementTeacherDaoInstance();
		boolean result = mt.addteacher(tc);
		PrintWriter   out   =   response.getWriter(); 
		if(result){
            out.println("<script>alert('添加成功!');</script>");
            out.println("<script>window.location.href='/ZijinQuestionBankSystem/admin/addTeacher.jsp'</script>");
		}
		else{
            out.println("<script>alert('添加失败!');history.back();</script>"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
