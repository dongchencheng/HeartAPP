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
    <title>普通用户管理</title>
    
    
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
  
  	<jsp:include page="/pages/common/common.jsp" />
  
    <div id="page-wrapper">
        <div class="row">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">普通用户表</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>ID</th>
											<th>用户名</th>
											<th>用户昵称</th>
											<th>设备ID</th>
											<th>CPU号</th>
											<th>注册日期</th>
											<th>出生日期</th>
											<th>年龄</th>
											<th>所在国家</th>
											<th>所在省城</th>
											<th>所在城市</th>
											<th>所在区或县城</th>
											<th>用户级别ID</th>
											<th>用户积分</th>
											<th>用户状态ID</th>
											<th>用户注册来源</th>
											<th>特别说明</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="list" var="f">
											<tr>
												<td><s:property value="idUser" /></td>
												<td><s:property value="userName" /></td>
												<td><s:property value="nickName" /></td>
												<td><s:property value="deviceId" /></td>
												<td><s:property value="cpuid" /></td>
												<td><s:property value="createTime" /></td>
												<td><s:property value="birthDay" /></td>
												<td><s:property value="age" /></td>
												<td><s:property value="country" /></td>
												<td><s:property value="province" /></td>
												<td><s:property value="city" /></td>
												<td><s:property value="zone" /></td>
												<td><s:property value="idUserLevel" /></td>
												<td><s:property value="userScore" /></td>
												<td><s:property value="idStatus" /></td>
												<td><s:property value="idCreateType" /></td>
												<td><s:property value="notes" /></td>
											</tr>
										</s:iterator>
										<tr>
										<tr>
											 <td align="right" colspan="20">
											 <c:if test="${page>1}">
											 	<a href="javascript:turn(1)">首页</a>
											 	<a href="javascript:turn(${page-1})">前一页</a>
											 </c:if>
											 <c:if test="${allpage>1}">
												<input type="text" id="tpage"
													onkeyup="value=value.replace(/[^(\d)]/g,'')"
													onkeydown="if(event.keyCode==13)turn('tpage')">
												<input type=button value="跳转" onclick="turn('tpage')">
											 </c:if>
											 <c:if test="${allpage>1&&page!=allpage}">
											 	<a href="javascript:turn(${page+1})">后一页</a>
											 	<a href="javascript:turn(${allpage})">尾页</a>
											 </c:if>
											 </td>
										</tr>
										<c:if test="${allpage>1}">
										<tr><td colspan="20" align="right">当前第${page}页，共${allpage}页</td>
										</tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
    </div>
    
    <!-- jQuery -->
    <script src="/HeartAPP/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/HeartAPP/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/HeartAPP/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/HeartAPP/dist/js/sb-admin-2.js"></script>
	<script>
	function turn(x){
		var turnpage;
		if(x=="tpage"){
			turnpage=document.getElementById("tpage").value;
			if(turnpage>${allpage}||turnpage<1){
				alert("跳转页数有误");
			}else{
				window.location.href='/HeartAPP/normaluserAction?page='+turnpage;
			}
		}else{
			window.location.href='/HeartAPP/normaluserAction?page='+x;
			}
		}
	</script>
</body>
</html>
