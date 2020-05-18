package zijin.factory;



import zijin.impl.ExamOnlineImpl;
import zijin.impl.LoadImpl;
import zijin.impl.LoginImpl;
import zijin.impl.MakePaperImpl;
import zijin.impl.ManagementClassImpl;
import zijin.impl.ManagementQuestionImpl;
import zijin.impl.ManagementStudentImpl;
import zijin.impl.ManagementSubjectImpl;
import zijin.impl.ManagementTeacherImpl;
import zijin.impl.MyMistakeImpl;
import zijin.impl.ReleaseHistoryImpl;
import zijin.impl.StatisticsImpl;
import zijin.impl.MyScoreImpl;
import zijin.impl.PersonalInfoImpl;
import zijin.impl.UpdatePWIpml;
import zijin.IF.ExamOnlineIF;
import zijin.IF.LoadIF;
import zijin.IF.LoginIF;
import zijin.IF.MakePaperIF;
import zijin.IF.ManagementClassIF;
import zijin.IF.ManagementQuestionIF;
import zijin.IF.ManagementStudentIF;
import zijin.IF.ManagementSubjectIF;
import zijin.IF.ManagementTeacherIF;
import zijin.IF.MyMistakeIF;
import zijin.IF.MyScoreIF;
import zijin.IF.PersonalInfoIF;
import zijin.IF.ReleaseHistoryIF;
import zijin.IF.StatisticsIF;
import zijin.IF.UpdatePWIF;

public class DaoFactory {
	public static LoginIF getUserDaoInstance()
	{
		return new LoginImpl();
	}
	
	public static ManagementQuestionIF getTeacherDaoInstance()
	{
		return new ManagementQuestionImpl();
	}
	
	public static MakePaperIF getMakePaperDaoInstance()
	{
		return new MakePaperImpl();
	}
	
	public static ReleaseHistoryIF getReleaseHistoryDaoInstance()
	{
		return new ReleaseHistoryImpl();
	}
	
	public static StatisticsIF getStatisticsDaoInstance()
	{
		return new StatisticsImpl();
	}
	
	public static UpdatePWIF getUpdatePWDaoInstance()
	{
		return new UpdatePWIpml();
	}
	
	public static ManagementSubjectIF getManagementSubjectDaoInstance()
	{
		return new ManagementSubjectImpl();
	}
	
	public static ManagementTeacherIF getManagementTeacherDaoInstance()
	{
		return new ManagementTeacherImpl();
	}
	
	public static ManagementClassIF getManagementClassDaoInstance()
	{
		return new ManagementClassImpl();
	}
	
	public static ManagementStudentIF getManagementStudentDaoInstance()
	{
		return new ManagementStudentImpl();
	}
	
	public static ExamOnlineIF getExamOnlineDaoInstance()
	{
		return new ExamOnlineImpl();
	}
	
	public static MyScoreIF getMyScoreDaoInstance()
	{
		return new MyScoreImpl();
	}
	
	public static PersonalInfoIF getPersonalInfoDaoInstance()
	{
		return new PersonalInfoImpl();
	}
	
	public static MyMistakeIF getMyMistakeDaoInstance()
	{
		return new MyMistakeImpl();
	}
	
	public static LoadIF getLoadDaoInstance()
	{
		return new LoadImpl();
	}
}
