package zijin.impl;

/**
 * 文件名：ManagementStudentImpl.java
 * 作用：Student（学生） 信息管理，包含add，dwl update find
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

import zijin.IF.ManagementStudentIF;
import zijin.bean.Student;
import zijin.others.myClass;
import zijin.util.DbcpPool;

public class ManagementStudentImpl implements ManagementStudentIF{

	@Override
	public boolean addstudent(Student sd) {
		String sql = "insert into student(sid,sname,classid,pwd) values(?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int r=0;
		try{
			ps.setString(1, sd.getSid());
			ps.setString(2, sd.getSname());		
			ps.setString(3, sd.getClassid());
			ps.setString(4, sd.getPwd());
			r=ps.executeUpdate();
			ps.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		if(r==0)
			return false;
		else return true;
	}

	@Override
	public List<Student> findstudent() {
		String sql = "select * from student";
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		try {
			rs=DbcpPool.executeQuery(sql);
			while(rs.next())
			{
				Student s = new Student();
				myClass mc = new myClass();
				s.setSid(rs.getString("sid"));
				s.setAddress(rs.getString("address"));
				s.setEmail(rs.getString("email"));
				s.setPhone(rs.getString("phone"));
				s.setSex(rs.getString("sex"));
				s.setSname(rs.getString("sname"));
				s.setClassid(rs.getString("classid"));
				s.setBirthdate(rs.getString("birthdate"));
				s.setClassname(mc.getClassName(Integer.parseInt(rs.getString("classid"))));
	            list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public boolean deletestudent(String sid) {
		String sql = "DELETE FROM student WHERE sid= '" + sid + "'";
		int result = 0 ;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		if(result>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updatestudent(Student sd) {
		String sql = null;
		sql = "update student set sname=?,sex=?,phone=?,address=?,birthdate=?,email=? where sid=?";
	    PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
	    int result = 0;
	    try {
		ps.setString(1, sd.getSname());
		ps.setString(2, sd.getSex());
		ps.setString(3, sd.getPhone());
		ps.setString(4, sd.getAddress());
		ps.setString(5, sd.getBirthdate());
		ps.setString(6, sd.getEmail());
		ps.setString(7, sd.getSid());
		result = ps.executeUpdate();
		ps.close();
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
