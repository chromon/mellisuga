<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="sitename.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>提问 - <%=sitename %></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="stylesheet" href="../css/bootstrap.css" media="screen">
	<link rel="stylesheet" href="../css/style.css" media="screen">
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<script src="../js/respond.min.js"></script>
	<![endif]-->

	<script src="../js/jquery-1.11.2.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>

	<!-- bacheditor -->
	<link rel="stylesheet" href="../plugin/BachEditor/css/pygment_trac.css">
	<link rel="stylesheet" href="../plugin/BachEditor/css/editor.css">
	<link rel="stylesheet" href="../plugin/BachEditor/css/codemirror.min.css">
	<link rel="stylesheet" href="../plugin/BachEditor/css/default.min.css">
	<script type="text/javascript" src="../plugin/BachEditor/js/highlight.min.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/marked.min.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/codemirror.min.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/ZeroClipboard.min.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/highlight.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/fileupload.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/modal.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/MIDI.js"></script>
	<script type="text/javascript" src="../plugin/BachEditor/js/bacheditor.js"></script>

</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="../" class="navbar-brand"><%=sitename %></a>
				<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">

				<form class="navbar-form navbar-left" role="search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search for...">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="button">Go!</button>
						</span>
					</div>
				</form>

				<ul class="nav navbar-nav">
					<li>
						<a href="#">首页</a>
					</li>
					<li>
						<a href="#">话题</a>
					</li>
					<li>
						<a href="#">发现</a>
					</li>
					<li>
						<a href="#">消息</a>
					</li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ellery <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#" class="glyphicon glyphicon-user"> 我的主页</a></li>
							<li><a href="#" class="glyphicon glyphicon-envelope"> 私信</a></li>
							<li><a href="#" class="glyphicon glyphicon-cog"> 设置</a></li>
							<li class="divider"></li>
							<li><a href="#" class="glyphicon glyphicon-off"> 退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>

    <div class="container">

      	<!-- main content -->
		<div class="question-main-content col-lg-10 col-md-10 col-sm-10 col-xs-10">
			<div class="row">
				<form class="form-horizontal">
					<fieldset>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2 col-md-offset-2">
								<input type="text" class="form-control" id="inputName" placeholder="写下你的问题">
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2 col-md-offset-2">
								<label for="inputName" class="control-label">问题说明（可选）：</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2 col-md-offset-2">
								<div class="editor">
									<textarea id="myEditor"></textarea>
								</div>

								<script>
								$(function() {
									var myEditor = new Editor();
									myEditor.render('#myEditor');
								});
								</script>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2 col-md-offset-2">
								<label for="inputName" class="control-label">选择话题：</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2 col-md-offset-2">
								<input type="text" class="form-control" id="inputName" placeholder="搜索话题">
								<span class="help-block">话题越精准，越容易让相关领域专业人士看到你的问题</span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2 col-md-offset-2">
								<div class="checkbox">
									<label>
										<input type="checkbox">匿名
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2 col-md-offset-2">
								<button type="reset" class="btn btn-default">取消</button>
								<button type="submit" class="btn btn-primary">提交</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div><!-- end main content row -->
		</div><!-- main content -->

	</div><!-- end container -->

	</body>
</html>