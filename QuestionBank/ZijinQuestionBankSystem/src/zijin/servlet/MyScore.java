package zijin.servlet;

/**
 * 文件名：MyScore.java
 * 作用：学生查看成绩的页面展示
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

import zijin.IF.MyScoreIF;
import zijin.bean.ScoreTable;
import zijin.factory.DaoFactory;

/**
 * Servlet implementation class StudentScore
 */
@WebServlet("/MyScore")
public class MyScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyScore() {
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
		myScore(request, response);
	}

	private void myScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sid = (String)request.getSession().getAttribute("sid");
		MyScoreIF ms = DaoFactory.getMyScoreDaoInstance();
		List<ScoreTable> list = ms.getMyScore(sid);
		request.getSession().setAttribute("myScore", list);		
		PrintWriter   out   =   response.getWriter(); 
		out.println("<script>window.location.href='/ZijinQuestionBankSystem/student/myScore.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
