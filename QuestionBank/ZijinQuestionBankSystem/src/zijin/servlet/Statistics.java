package zijin.servlet;

/**
 * 文件名：Statistics.java
 * 作用：teacher查看自己负责的试卷得分情况，或者查看某一张试卷的得分情况
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

import zijin.IF.ReleaseHistoryIF;
import zijin.IF.StatisticsIF;
import zijin.bean.DetailStatistics;
import zijin.bean.Paper;
import zijin.bean.StatisticsTable;
import zijin.factory.DaoFactory;

/**
 * Servlet implementation class StatisticsServlet
 */
@WebServlet("/Statistics")
public class Statistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statistics() {
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
		switch(method){
		      case "findStatistics"   : findStatistics(request, response);   break;
		      case "detailStatistics" : detailStatistics(request, response); break;
		}
	}

	private void detailStatistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int paperid = Integer.parseInt(request.getParameter("paperid"));
		StatisticsIF st = DaoFactory.getStatisticsDaoInstance();
		List<DetailStatistics> list = st.getdetailStatistics(paperid);
		request.getSession().setAttribute("detailStatistics", list);
		request.getSession().setAttribute("paperid",request.getParameter("paperid"));
		PrintWriter   out   =   response.getWriter(); 
		out.println("<script>window.location.href='/ZijinQuestionBankSystem/teacher/detailStatistics.jsp'</script>");
	}

	private void findStatistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tid = (String)request.getSession().getAttribute("tid");
		StatisticsIF st = DaoFactory.getStatisticsDaoInstance();
		List<StatisticsTable> list = st.getStatistics(tid);
		request.getSession().setAttribute("Statistics", list);
		PrintWriter   out   =   response.getWriter(); 
		out.println("<script>window.location.href='/ZijinQuestionBankSystem/teacher/Statistics.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
