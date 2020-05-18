package zijin.servlet;

/**
 * 文件名：ExamOnline。java
 * 作用：考试界面前后的操作通道  包含了试卷列表呈现-试题呈现-分数计算写入等操作    studentHome。jsp(点击查看考试列表)-examList。jsp(点击进入考试)-enterExam.jsp(提交试卷)
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zijin.IF.ExamOnlineIF;
import zijin.IF.ReleaseHistoryIF;
import zijin.bean.ChoiceQuestion;
import zijin.bean.FillQuestion;
import zijin.bean.JudgeQuestion;
import zijin.bean.Paper;
import zijin.factory.DaoFactory;

/**
 * Servlet implementation class ExamOnline
 */
@WebServlet("/ExamOnline")
public class ExamOnline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamOnline() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	/**
	 * doGet()
	 * 当jsp页面向这个文件发送GET请求执行这个函数
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				myway(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	/**
	 * myway()
	 * 实现不同功能,执行不同的函数
	 */
		public void myway(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException
		{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String method = request.getParameter("method");
			switch(method){
			     case "examList"  : examList(request, response);   break;
			     case "enterExam" : enterExam(request, response);  break;
			     case "countScore": countScore(request, response); break;
			}
		}

		/**
		 * countScore()
		 * from enterExam的form 考试界面  to studentHome.jsp
		 * request中包含答案信息，session（试卷号学号）
		 * 算出成绩并存入数据库
		 */
	private void countScore(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		    ExamOnlineIF eo = DaoFactory.getExamOnlineDaoInstance();
		    int paperid = Integer.parseInt(request.getParameter("paperid"));
			String sid = (String)request.getSession().getAttribute("sid");
		    String Q[] = new String[25];
			System.out.println(sid);
		    for(int i=1;i<21;i++){
			   Q[i] = request.getParameter(i+"");
		    }
            int Scoce = eo.getScore(Q,paperid,sid);
    		PrintWriter   out   =   response.getWriter(); 
            out.println("<script>alert('请到个人成绩查看成绩!');</script>"); 
    		out.println("<script>window.location.href='/ZijinQuestionBankSystem/student/studentHome.jsp'</script>");

		}

	/**
	 * enterExam()
	 * 考试答题  from examList.jsp的a标签  to enterExam.jsp
	 * 是examList.jsp文件中考试答题案件的点击事件
	 * 判断是否在考试时间，如已考过或者不在考试时间 不能参加    否则展示试卷开始考试
	 */
	private void enterExam(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
			int paperid = Integer.parseInt(request.getParameter("paperid"));
			String sid = (String)request.getSession().getAttribute("sid");
		    ExamOnlineIF eo = DaoFactory.getExamOnlineDaoInstance();
			int result = eo.checkState(paperid,sid);
    		PrintWriter   out   =   response.getWriter(); 
		    if(result==1)
		    {
		    	out.println("<script>alert('本次考试您已经考过，不能再考一次!');history.back();</script>"); 
		    }
		    else if(result==2)
		    {
		    	out.println("<script>alert('考试时间已过，下次要来早一点哦!');</script>"); 
		    	examList(request, response);
		    }
		    else{
			ReleaseHistoryIF rh = DaoFactory.getReleaseHistoryDaoInstance();
			List<ChoiceQuestion> choiceQPaper = rh.getChoiceQPaper(paperid);
			request.getSession().setAttribute("choiceQPaper", choiceQPaper);
			List<FillQuestion> fillQPaper = rh.getFillQPaper(paperid);
			request.getSession().setAttribute("fillQPaper", fillQPaper);
			List<JudgeQuestion> judgeQPaper = rh.getJudgeQPaper(paperid);
			request.getSession().setAttribute("judgeQPaper", judgeQPaper);
			request.getSession().setAttribute("paperid", request.getParameter("paperid"));
			response.sendRedirect("student/enterExam.jsp");
		    }
		}

	/**
	 * examList()
	 * 考试答题  from studentHome.jsp的a标签  to examList.jsp
	 * 生成试卷列表放入session中
	 */
	private void examList(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String sid = (String)request.getSession().getAttribute("sid");
			ExamOnlineIF eo = DaoFactory.getExamOnlineDaoInstance();
			List<Paper> list = eo.examlist(sid);
			request.getSession().setAttribute("paperList", list);
    		PrintWriter   out   =   response.getWriter(); 
    		out.println("<script>window.location.href='/ZijinQuestionBankSystem/student/examList.jsp'</script>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * doPost()
	 * 当jsp页面向这个文件发送POST请求执行这个函数
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
