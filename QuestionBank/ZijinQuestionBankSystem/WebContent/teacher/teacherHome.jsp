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
						<a class="navbar-brand" href="teacherHome.jsp">紫金试题库系统</a>
					</div>
					<div>
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">试题管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="addQuestion.jsp">添加试题</a></li>
									<li><a
										href="../ManagementQuestion?method=findchoiceQuestion">选择题维护</a>
									</li>
									<li><a
										href="../ManagementQuestion?method=findfillQuestion">填空题维护</a>
									</li>
									<li><a
										href="../ManagementQuestion?method=findjudgeQuestion">判断题维护</a>
									</li>
								</ul></li>
							<li><a href="makePaper.jsp">发布试卷</a></li>
							<li><a href="../ReleaseHistory?method=findpaperHistory">历史发布</a>
							</li>
							<li><a href="../Statistics?method=findStatistics">统计情况</a></li>
						</ul>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>我的<strong
								class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="../PersonalInfo?method=findTeacherInfo">个人信息</a>
								</li>
								<li><a href="updateTPW.jsp">修改密码</a></li>
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