package zijin.impl;

/**
 * 文件名：ManagementTeacherImpl.java
 * 作用：Teacher（老师） 信息管理，包含add，dwl update find
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 * 
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zijin.IF.ManagementTeacherIF;
import zijin.bean.Subject;
import zijin.bean.Teacher;
import zijin.util.DbcpPool;

public class ManagementTeacherImpl implements ManagementTeacherIF{

	@Override
	public boolean addteacher(Teacher tc) {
		String sql = "INSERT INTO teacher (tid,tname,pwd,sex,phone,address,birthdate,email) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, tc.getTid());
			ps.setString(2, tc.getTname());
			ps.setString(3, tc.getPwd());
			ps.setString(4, tc.getSex());
			ps.setString(5, tc.getPhone());
			ps.setString(6, tc.getAddress());
			ps.setString(7, tc.getBirthdate());
			ps.setString(8, tc.getEmail());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		if(result>0)
			return true;
		else
			return false;
	}

	@Override
	public List<Teacher> findteacher() {
		String sql = null;
		sql = "select * from teacher";
		List<Teacher> list = new ArrayList<Teacher>();
		ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			Teacher tc = new Teacher();
			tc.setAddress(rs.getString("tid"));
			tc.setBirthdate(rs.getString("birthdate"));
			tc.setEmail(rs.getString("email"));
			tc.setPhone(rs.getString("phone"));
			tc.setPwd(rs.getString("pwd"));
			tc.setSex(rs.getString("sex"));
			tc.setTname(rs.getString("tname"));
			tc.setTid(rs.getString("tid"));
			list.add(tc);
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public boolean deleteteacher(String tid) {
		int result = 0;
		String sql = "delete from teacher where tid='"+tid+"'";
		result = DbcpPool.executeUpdate(sql);
		if(result>0)
			return true;
		else 
		    return false;
	}

	@Override
	public boolean updateteacher(Teacher tc) {
		String sql = "UPDATE teacher SET tname=?,sex=?,phone=?,address=?,birthdate=?,email=? WHERE tid=?";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
        int result = 0;
		try {
			ps.setString(1, tc.getTname());
			ps.setString(2, tc.getSex());
			ps.setString(3, tc.getPhone());
			ps.setString(4, tc.getAddress());
			ps.setString(5, tc.getBirthdate());
			ps.setString(6, tc.getEmail());
			ps.setString(7, tc.getTid());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		if(result>0)
			return true;
		else
			return false;
	}

}
