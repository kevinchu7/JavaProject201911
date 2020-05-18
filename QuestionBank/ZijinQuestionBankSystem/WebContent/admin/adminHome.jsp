<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>紫金试题库系统</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery-2.1.4.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style>
body {
	background-image: url(../picture/bg3.jpg);
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
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">班级管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="addClass.jsp">添加班级</a></li>
									<li><a href="../ManagementClass?method=findClass">班级维护</a>
									</li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">学生管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="addStudent.jsp">添加学生</a></li>
									<li><a href="../ManagementStudent?method=findStudent">学生维护</a>
									</li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">教师管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="addTeacher.jsp">添加教师</a></li>
									<li><a href="../ManagementTeacher?method=findTeacher">教师维护</a>
									</li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">学科管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="addSubject.jsp">添加学科</a></li>
									<li><a href="../ManagementSubject?method=findSubject">学科维护</a>
									</li>
								</ul></li>
						</ul>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>我的<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="../PersonalInfo?method=findAdminInfo">个人信息</a>
								</li>
								<li><a href="updateAPW.jsp">修改密码</a></li>
								<li><a href="../LoginServlet?usertype=logout">注销</a></li>
							</ul></li>
					</ul>
				</div>
				</nav>
				<div class="jumbotron">
					<h1>欢迎使用紫金试题库系统!</h1>
					<p>
					诚信、勤奋、求是、创新
					</p>

				</div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-4 column">
				<h2>诚信</h2>
				<p>“诚”更多地指“内诚于心”，“信”则侧重于“外信于人”。其含义是指诚实无欺，讲求信用，诚信是自身的行为规范和道德修养，是立人之本。</p>

			</div>
			<div class="col-md-4 column">
				<h2>勤奋</h2>
				<p>勤，就是要珍惜时间，勤学习，勤思考，勤探究，勤实践。勤奋是成功、成才的唯一途径。</p>
				
			</div>
			<div class="col-md-4 column">
				<h2>求是</h2>
				<p>讲求是际，是对“实事求是”的浓缩。“创新”，创造与革新，意为与时俱进，追求新高。“求是”是态度。</p>
				
			</div>
			<div class="col-md-4 column">
				<h2>创新</h2>
				<p>“创新”，创造与革新，意为与时俱进，追求新高。“求是”是态度，“创新”是方法和手段。</p>
				
			</div>
			<div class="col-md-4 column">
				<h2>   </h2>
				<p>   </p>
				
			</div>
			<div class="col-md-4 column">
				<h2>   </h2>
				<p>   </p>
				
			</div>
		</div>
	</div>
</body>
</html>