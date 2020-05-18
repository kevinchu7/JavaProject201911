package zijin.impl;

/**
 * 文件名：MyScoreImpl.java
 * 作用：getScore 根据输入sid查看该同学成绩  返回list<scoreTable>
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 * 
 */
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import zijin.IF.MyScoreIF;
import zijin.bean.ScoreTable;
import zijin.util.DbcpPool;

public class MyScoreImpl implements MyScoreIF{

	@Override
	public List<ScoreTable> getMyScore(String sid) {
		String sql = null;
		sql = "select * from student a, paper b, teacher c, grade d, subject e "
				+ "where a.sid=d.sid and d.paperid= b.paperid and b.tid=c.tid "
				+ "and b.subjectid=e.subjectid and a.sid='"+sid+"'";
		List< ScoreTable> list = new ArrayList< ScoreTable>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			ScoreTable st = new  ScoreTable();
			st.setPapername(rs.getString("b.papername"));
			String endtime = dateFormat.format( rs.getTimestamp("b.endtime") );
			String starttime = dateFormat.format( rs.getTimestamp("b.starttime") );
			st.setEndtime(endtime);
			st.setStarttime(starttime);
			st.setSubjectname(rs.getString("e.subjectname"));
			st.setTeachername(rs.getString("c.tname"));
			st.setScore(rs.getInt("d.score"));
			list.add(st);
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
