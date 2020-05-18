package zijin.others;


/**
 * 文件名：subject.java
 * 作用：获取课程名字by id
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import zijin.bean.Admin;
import zijin.bean.Subject;
import zijin.util.DbcpPool;

public class subject {
	public List<Subject> getSubject() {
		String sql = null;
		sql = "select * from subject";
		List<Subject> list = new ArrayList<Subject>();
		ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			Subject sj = new Subject();
			sj.setSubjectid(rs.getInt("subjectid"));
			sj.setSubjectname(rs.getString("subjectname"));
			list.add(sj);
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}
	
	public String getSubjectName(int subjectid)
	{
		String sql = null;
		sql = "select * from subject where subjectid="+subjectid+"";
		ResultSet rs = null;
        String sb = "";
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			sb = rs.getString("subjectname");
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return sb;
	}
	
}
