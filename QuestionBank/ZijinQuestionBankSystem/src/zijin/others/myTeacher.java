package zijin.others;

/**
 * 文件名：myTeacher.java
 * 作用：获取老师名字by id
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
import java.sql.ResultSet;

import zijin.util.DbcpPool;

public class myTeacher {
	public String getTeacherName(String tid)
	{
		String sql = null;
		sql = "select * from teacher where tid='"+tid+"'";
		ResultSet rs = null;
        String sb = "";
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			sb = rs.getString("tname");
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
