<!DOCTYPE>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
  <head>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>错误</title>
    <style>
    .mess{
    color:red;position: absolute;left:43%;top:130px;font-size:23px;
    }
    </style>
  </head>
  
  <body>
   <div id="message" class="mess">不能重复提交。</div><br>
   <a href="/HeartAPP/pages/index.jsp">返回首页</a>
</body>
</html>
