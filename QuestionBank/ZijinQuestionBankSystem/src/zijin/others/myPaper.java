package zijin.others;

/**
 * 文件名：myPaper.java
 * 作用：获取试卷名称by id
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
import java.sql.ResultSet;

import zijin.util.DbcpPool;

public class myPaper {
	public String getPaperName(int paperid)
	{
		String sql = null;
		sql = "select * from paper where paperid="+paperid+"";
		ResultSet rs = null;
        String sb = "";
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			sb = rs.getString("papername");
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
