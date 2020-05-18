<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="java.sql.*"
    import="zijin.bean.*"
    import="zijin.others.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>紫金试题库系统</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery-2.1.4.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style>
body{background-image: url(../picture/bg3.jpg);
	background-size: cover;
}
</style>
</head>
<body>		
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="adminHome.jsp">紫金试题库系统</a>
    </div>
     <div>
        <ul class="nav navbar-nav">
            <li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">班级管理<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="addClass.jsp">添加班级</a>
								</li>
								<li>
									 <a href="../ManagementClass?method=findClass">班级维护</a>
								</li>
							</ul>
			</li>
			<li class="dropdown active">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">学生管理<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="addStudent.jsp">添加学生</a>
								</li>
								<li>
									 <a href="../ManagementStudent?method=findStudent">学生维护</a>
								</li>
							</ul>
			</li>
			<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">教师管理<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="addTeacher.jsp">添加教师</a>
								</li>
								<li>
									 <a href="../ManagementTeacher?method=findTeacher">教师维护</a>
								</li>
							</ul>
			</li>
			<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">学科管理<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="addSubject.jsp">添加学科</a>
								</li>
								<li>
									 <a href="../ManagementSubject?method=findSubject">学科维护</a>
								</li>
							</ul>
			</li>
        </ul>
    </div>
    <ul class="nav navbar-nav navbar-right">
           <li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>我的<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="../PersonalInfo?method=findAdminInfo">个人信息</a>
								</li>
								<li>
									 <a href="updateAPW.jsp">修改密码</a>
								</li>
								<li>
									 <a href="../LoginServlet?usertype=logout">注销</a>
								</li>
							</ul>
			</li>
    </ul>
  </div>
</nav>
</div>
<span style="color:red;">*如果删除或修改学生，与该学生相关的信息（如该班的学生个人信息、成绩和错题等）也会做出相应的删除或者修改</span>
<%
List<Student> record = (List<Student>)session.getAttribute("studentList");
%>
<%if (record == null || record.size() == 0) {
		out.println("<center><strong>还没有学生信息~</strong></center>");						
		}
	else {%>
	
	
			<table class="table table-hover table-bordered" id="table">
			<thead>
			<tr>
			<th>学号</th>
            <th>姓名</th>
            <th>班级</th>
            <th>性别</th> 
            <th>手机</th>
            <th>地址</th>
            <th>出生日期（yyyy-MM-dd）</th>
            <th>邮件</th>
            <th>操作</th>
			</tr>
			</thead>
			<tbody>
			<% for (Student r : record) {	
	%>
					<tr  class="success">
					<td><%=r.getSid() %></td>
     <td><%=r.getSname() %></td>
     <td><%=r.getClassname() %></td>  
     <td><%if(r.getSex()==null) out.print("-"); else out.print(r.getSex()); %></td>
     <td><%if(r.getPhone()==null) out.print("-"); else out.print(r.getPhone()); %></td>
     <td><%if(r.getAddress()==null) out.print("-"); else out.print(r.getAddress()); %></td>
     <td><%if(r.getBirthdate()==null) out.print("-"); else out.print(r.getBirthdate()); %></td>
     <td><%if(r.getEmail()==null) out.print("-"); else out.print(r.getEmail()); %></td>
         
     <td>
         <a href="#" data-toggle="modal" data-target="#myModal" onclick="values(<%=r.getSid()%>)">修改</a>
         <a href="../ManagementStudent?method=deleteStudent&sid=<%=r.getSid() %>">删除</a>
     </td>
	</tr>

		
   <!--orderList/-->
   <%
		}}
   %>
   	</tbody>
</table>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">学生信息修改</h4>
        	</div>
			<form class="form-horizontal" role="form" method="post" method="post" action="../ManagementStudent?method=updateStudent">
            	<div class="modal-body">
								<div class="form-group">
									<label for="firstname" class="col-sm-2 control-label">学号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="sid" id="sid" readonly="readonly">											
									</div>
								</div>
								<div class="form-group">
									<label for="lastname" class="col-sm-2 control-label">姓名</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="sname" id="sname" placeholder="请输入姓名">
									</div>
								</div>
								<div class="form-group">
									<label for="sex" class="col-sm-2 control-label">性别</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="ssex" id="ssex"
											placeholder="请输入性别（男/女）">
									</div>
								</div>
								<div class="form-group">
									<label for="phone" class="col-sm-2 control-label">电话号码</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="sphone" id="sphone" placeholder="请输入电话号码">
									</div>
								</div>
								<div class="form-group">
									<label for="address" class="col-sm-2 control-label">地址</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="saddress" id="saddress"
											placeholder="请输入地址">
									</div>
								</div>
								<div class="form-group">
									<label for="birthdate" class="col-sm-2 control-label">生日（yyyy-MM-dd）</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="sbirthdate" id="sbirthdate"
											placeholder="请输入生日(yyyy-MM-dd)">
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="col-sm-2 control-label">邮箱</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="semail" id="semail"
											placeholder="请输入邮箱">
									</div>
								</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">提交更改</button>
						</div>
            </div>
                   </form>
    </div>
    </div>
    </div>
    
	</div>
</div>

<script type="text/javascript">
function values(sid) {  
    var id=0;  
    while(1)
    	{
    	if(sid==document.getElementById("table").rows[id].cells[0].innerText)
    		break;
    	id++;
    	}
    //获取表格中的一行数据  
    var sid= document.getElementById("table").rows[id].cells[0].innerText;  
    var sname = document.getElementById("table").rows[id].cells[1].innerText;  
    var ssex = document.getElementById("table").rows[id].cells[3].innerText;  
    var sphone = document.getElementById("table").rows[id].cells[4].innerText; 
    var saddress = document.getElementById("table").rows[id].cells[5].innerText;
    var sbirthdate = document.getElementById("table").rows[id].cells[6].innerText;  
    var semail = document.getElementById("table").rows[id].cells[7].innerText;  
     
    
    //alert(j_answer);
    //向模态框中传值  
    document.getElementById("sid").value = sid;
    document.getElementById("sname").value = sname;
    document.getElementById("ssex").value = ssex;
    document.getElementById("sbirthdate").value = sbirthdate;
    document.getElementById("semail").value = semail;
    document.getElementById("sphone").value = sphone;
    document.getElementById("saddress").value = saddress;
}
</script>
</body>
</html>