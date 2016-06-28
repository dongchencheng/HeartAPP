<!DOCTYPE>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
  <head>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache,must-revalidate">
	<meta http-equiv="expires" content="0">    
    <title>登录界面</title>
    
    
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

  	<!-- 验证是否已经登录，若已经登录，则跳转index页面 -->
	<c:if test="${not empty id}">
		<c:redirect url="/pages/index.jsp" />
	</c:if>
	
	<span id="message" class="mess"></span>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">请登录</h3>
                    </div>
                    <div class="panel-body">
						<s:form action="loginAction" theme="simple">
							
							<s:token></s:token>
							
							<div class="form-group" id="userinput">
								<input class="form-control" placeholder="请输入用户名" id="user" maxlength="16"
									name="adminname" type="text" autofocus>
							</div>
							<div class="form-group" id="passinput">
								<input class="form-control" placeholder="请输入密码" id="pass" maxlength="16"
									name="password" type="password">
							</div>
							<s:submit value="登录" cssClass="btn btn-lg btn-success btn-block"
								method="login" onclick="return sub()" />
						</s:form>
					</div>
                </div>
            </div>
        </div>
    </div>

	<script>
	var success = "${success}";
	var mess = document.getElementById("message");
	if(success=="false"){
		mess.innerHTML = "账户或密码错误！";
	}else if(success=="limit"){
		mess.innerHTML = "账户权限不足！";
	}else if(success=="update"){
		mess.innerHTML = "修改成功，重新登录！";
	}
	
	function sub() {
		var user = document.getElementById("user").value.length;
		var pass = document.getElementById("pass").value.length;
		var userinput = document.getElementById("userinput");
		var passinput = document.getElementById("passinput");
		if (user < 4) {
			userinput.className="form-group has-error";
			mess.innerHTML = "账户介于4-16位";
			window.event.returnValue = false;
		} else if (pass < 4) {
			userinput.className="form-group has-success";
			passinput.className="form-group has-error";
			mess.innerHTML = "密码介于4-16位";
			window.event.returnValue = false;
		}
	}
	</script>
</body>
</html>
