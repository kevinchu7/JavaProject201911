package zijin.impl;

/*
 * 文件名：LoginImpl.java
 * 作用：不同角色登录业务处理
 * 创建者：陈天、瞿嘉乐、季洋洋、朱凯
 * 创建时间：
 * 
 */
import java.sql.ResultSet;
import java.sql.SQLException;

import zijin.IF.LoginIF;
import zijin.bean.Admin;
import zijin.bean.Student;
import zijin.bean.Teacher;
import zijin.util.DbcpPool;

public class LoginImpl implements LoginIF{

	@Override
	
	
	/**
	 * studentLogin()
	 * 参数:std<Student>
	 * 学生登录业务处理，账号密码正确return 1  错误返回 0 
	 * 
	 */
	public int studentLogin(Student std) {
		 String sql = null;
   		 sql = "select count(*) from student where sid='"+std.getSid()+"' and pwd ='"+std.getPwd()+"'";
   	     ResultSet rs = DbcpPool.executeQuery(sql);
   	     int count = 0;
   	     try {
 			if(rs.next())
 			{
 				count = rs.getInt("count(*)");
 			}
 			rs.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		DbcpPool.close();
 		if(count>0)
 			return 1;
 		else
   	        return 0;
	}

	@Override
	
	/**
	 * adminLogin()
	 * 参数:ad<Admin>
	 * 管理员登录业务处理，账号密码正确return 1  错误返回 0 
	 * 
	 */
	public int adminLogin(Admin ad) {
		String sql = null;
  		 sql = "select count(*) from administrator where aid='"+ad.getAid()+"' and pwd ='"+ad.getPwd()+"'";
  	     ResultSet rs = DbcpPool.executeQuery(sql);
  	     int count = 0;
  	     try {
			if(rs.next())
			{
				count = rs.getInt("count(*)");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		if(count>0)
			return 1;
		else
  	        return 0;
	}

	@Override
	
	/**
	 * teacherLogin()
	 * 参数：tc<teacher>
	 * 老师登录业务处理，账号密码正确return 1  错误返回 0 
	 */
	public int teacherLogin(Teacher tc) {
		String sql = null;
  		 sql = "select count(*) from teacher where tid='"+tc.getTid()+"' and pwd ='"+tc.getPwd()+"'";
  	     ResultSet rs = DbcpPool.executeQuery(sql);
  	     int count = 0;
  	     try {
			if(rs.next())
			{
				count = rs.getInt("count(*)");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		if(count>0)
			return 1;
		else
  	        return 0;
	}

}
