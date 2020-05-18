package zijin.impl;

/**
 * 文件名：LoadImpl.java
 * 作用：题库中题目的插入 成绩导出Excel
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zijin.IF.LoadIF;
import zijin.bean.ChoiceQuestion;
import zijin.bean.DetailStatistics;
import zijin.bean.FillQuestion;
import zijin.bean.JudgeQuestion;
import zijin.util.DbcpPool;

public class LoadImpl implements LoadIF{

	@Override
	
	/**
	 * saveCQ()
	 * 参数：CQ<ChoiceQuestion> subjectid
	 * 插入选择题到数据库
	 * return true 成功
	 * return false 失败
	 * 
	 */
	public boolean saveCQ(ChoiceQuestion CQ, int subjectid) {
		String sql_save = " INSERT INTO choicequestion(c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer,c_subjectid) VALUES(?,?,?,?,?,?,?)";  
        int i = 0;  
        try {  
        	PreparedStatement prep = null;  
        	prep = DbcpPool.executePreparedStatement(sql_save);
            prep.setString(1, CQ.getC_question());  
            prep.setString(2, CQ.getC_choiceA());  
            prep.setString(3, CQ.getC_choiceB());  
            prep.setString(4, CQ.getC_choiceC());  
            prep.setString(5, CQ.getC_choiceD());  
            prep.setString(6, CQ.getC_answer());  
            prep.setInt(7, subjectid);  
            i  = prep.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
        	DbcpPool.close();
        }  
        if(i>0)  
           return true;  
        else 
           return false; 
	}

	@Override
	
	/**
	 * saveFQ()
	 * 参数：CQ<FillQuestion> subjectid
	 * 插入判断题到数据库
	 * return true 成功
	 * return false 失败
	 * 
	 */
	public boolean saveFQ(FillQuestion FQ, int subjectid) {
		String sql_save = " INSERT INTO fillquestion(f_question,f_answer,f_subjectid) VALUES(?,?,?)";  
        int i = 0;  
        try {  
        	PreparedStatement prep = null;  
        	prep = DbcpPool.executePreparedStatement(sql_save);
            prep.setString(1, FQ.getF_question());  
            prep.setString(2, FQ.getF_answer());  
            prep.setInt(3, subjectid);  
            i  = prep.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
        	DbcpPool.close();
        }  
        if(i>0)  
           return true;  
        else 
           return false;
	}

	@Override
	
	/**
	 * saveJQ()
	 * 参数：CQ<JudgeQuestion> subjectid
	 * 插入解答题到数据库
	 * return true 成功
	 * return false 失败
	 * 
	 */
	public boolean saveJQ(JudgeQuestion JQ, int subjectid) {
		String sql_save = " INSERT INTO judgequestion(j_question,j_answer,j_subjectid) VALUES(?,?,?)";  
        int i = 0;  
        try {  
        	PreparedStatement prep = null;  
        	prep = DbcpPool.executePreparedStatement(sql_save);
            prep.setString(1, JQ.getJ_question());  
            prep.setInt(2, JQ.getJ_answer());  
            prep.setInt(3, subjectid);  
            i  = prep.executeUpdate();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
        	DbcpPool.close();
        }  
        if(i>0)  
           return true;  
        else 
           return false;
	}

	@Override
	
	/**
	 * saveExcel()
	 * 将成绩导出到Excel表 
	 * 
	 * 
	 */
	public List<DetailStatistics> saveExcel(int paperid) {
		String sql = null;
		sql = "select * from grade a,student b "
				+ "where a.sid=b.sid and a.paperid="+paperid+"";
		List<DetailStatistics> list = new ArrayList<DetailStatistics>();
		ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			DetailStatistics ds = new DetailStatistics();
			ds.setScore(rs.getInt("a.score"));
			ds.setSid(rs.getString("b.sid"));
			ds.setSname(rs.getString("b.sname"));
			list.add(ds);
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	
	
     
}
