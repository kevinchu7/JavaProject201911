package zijin.servlet;


/**
 * 文件名：ManagementStudent.java
 * 作用：学生信息管理
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zijin.IF.ManagementStudentIF;
import zijin.IF.ManagementSubjectIF;
import zijin.bean.Classbean;
import zijin.bean.Student;
import zijin.factory.DaoFactory;

/**
 * Servlet implementation class ManagementStudent
 */
@WebServlet("/ManagementStudent")
public class ManagementStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementStudent() {
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
		      case "addStudent"    : addStudent(request, response);     break;
		      case "deleteStudent" : deleteStudent(request, response);  break;
		      case "updateStudent" : updateStudent(request, response);  break;
		      case "findStudent"   : findStudent(request, response);    break;
		}
	}
	private void findStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ManagementStudentIF ms = DaoFactory.getManagementStudentDaoInstance();
		List<Student> list = ms.findstudent();
		request.getSession().setAttribute("studentList", list);
		response.sendRedirect("admin/findStudent.jsp");	
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ManagementStudentIF ms = DaoFactory.getManagementStudentDaoInstance();
		Student s=new Student();
		s.setSid(request.getParameter("sid"));
		s.setNewsid(request.getParameter("newsid"));
		s.setSname(request.getParameter("sname"));
		s.setSex(request.getParameter("ssex"));
		s.setPhone(request.getParameter("sphone"));
		s.setAddress(request.getParameter("saddress"));
		s.setBirthdate(request.getParameter("sbirthdate"));
		s.setEmail(request.getParameter("semail"));
		boolean result=ms.updatestudent(s);
		PrintWriter   out   = response.getWriter(); 
		if(result){
		     List<Student> list = ms.findstudent();
		     request.getSession().setAttribute("studentList", list);
		     out.println("<script>alert('修改成功!');</script>");
             out.println("<script>window.location.href='/ZijinQuestionBankSystem/admin/findStudent.jsp'</script>");
		}
		else
		{
			out.println("<script>alert('修改失败!');history.back();</script>");
		}	
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ManagementStudentIF ms = DaoFactory.getManagementStudentDaoInstance();
		String sid = request.getParameter("sid");
		boolean result = ms.deletestudent(sid);
		PrintWriter   out   =   response.getWriter(); 
		if(result){
		     List<Student> list = ms.findstudent();
		     request.getSession().setAttribute("studentList", list);
		     out.println("<script>alert('删除成功!');</script>");
             out.println("<script>window.location.href='/ZijinQuestionBankSystem/admin/findStudent.jsp'</script>");
		}
		else
		{
			out.println("<script>alert('删除失败!');history.back();</script>");
		}
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ManagementStudentIF ms = DaoFactory.getManagementStudentDaoInstance();
		Student s=new Student();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setClassid(request.getParameter("classid"));
		s.setPwd(request.getParameter("pwd"));
		s.setSex(request.getParameter("sex"));
		s.setPhone(request.getParameter("phone"));
		s.setAddress(request.getParameter("address"));
		s.setBirthdate(request.getParameter("birthdate"));
		s.setEmail(request.getParameter("email"));
		boolean r=ms.addstudent(s);
		PrintWriter   out   =   response.getWriter(); 
		if(r==true)
		{
            out.println("<script>alert('添加成功!');</script>");
            out.println("<script>window.location.href='/ZijinQuestionBankSystem/admin/addStudent.jsp'</script>");
        }
		else 
		{
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
