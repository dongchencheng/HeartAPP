<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>

    
    <!-- Bootstrap Core CSS -->
    <link href="/HeartAPP/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/HeartAPP/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/HeartAPP/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/HeartAPP/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

	<span id="message" class="mess"></span>
	
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">请修改密码</h3>
					</div>
					<div class="panel-body">
						<s:form action="loginAction" theme="simple">
						
						<s:token></s:token>
						
							<div class="form-group" id="oldinput">
								<input class="form-control" placeholder="请输入旧密码" id="oldpass"
									maxlength="16" name="oldpassword" type="password" autofocus>
							</div>
							<div class="form-group" id="newinput">
								<input class="form-control" placeholder="请输入新密码" id="newpass"
									maxlength="16" name="newpassword" type="password">
							</div>
							<div class="form-group" id="repeatinput">
								<input class="form-control" placeholder="请重复新密码" id="repeatpass"
									maxlength="16" type="password">
							</div>
							<s:submit value="修改" cssClass="btn btn-lg btn-success btn-block"
								method="update" onclick="return sub()" />
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	var success = "${success}";
	var mess = document.getElementById("message");
	
	if(success=="failure"){
		mess.innerHTML = "旧密码错误！";
	}
	
	function sub() {
		var oldpass = document.getElementById("oldpass").value.length;
		var newpass = document.getElementById("newpass").value.length;
		var oldinput = document.getElementById("oldinput");
		var newinput = document.getElementById("newinput");
		var repeatinput = document.getElementById("repeatinput");
		
		if (oldpass < 4) {
			oldinput.className="form-group has-error";
			mess.innerHTML = "旧密码介于4-16位";
			window.event.returnValue = false;
		} else if (newpass < 4) {
			oldinput.className="form-group has-success";
			newinput.className="form-group has-error";
			mess.innerHTML = "新密码介于4-16位";
			window.event.returnValue = false;
		}
		
		if(document.getElementById("newpass").value!=document.getElementById("repeatpass").value){
			repeatinput.className="form-group has-error";
			mess.innerHTML = "两次密码不一致！";
			window.event.returnValue = false;
		}
	}
	</script>
</body>
</html>
