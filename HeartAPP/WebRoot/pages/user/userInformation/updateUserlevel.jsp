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
    <title>修改级别</title>
    
    
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
  	
  	<!-- 验证是否有值 -->
	<c:if test="${empty userlevel}">
		<c:redirect url="/userlevelAction" />
	</c:if>
  
  	<jsp:include page="/pages/common/common.jsp" />
  
    <div id="page-wrapper">
        <div class="row">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">修改级别
                    <a href="/HeartAPP/userlevelAction?page=${page}">
						<button class="btn btn-success">返回</button>
					</a>
                    </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-lg-6">
								<s:form action="userlevelAction" theme="simple">
									<input name="page" type="hidden" value="${page}"/>
									<s:actionerror cssStyle="color:red"/>
									<s:token></s:token>
									<div class="form-group">ID
										<input class="form-control"  type="text"
											value="${idUserLevel}" name="idUserLevel"
											readonly="readonly">
									</div>
									<div class="form-group">级别名称*
										<input class="form-control"
											value="${userlevel.userLevelName}" name="userLevelName" type="text"
											autofocus="autofocus" required="required">
									</div>
									<div class="form-group">级别说明
										<input class="form-control"
											value="${userlevel.userLevelDes}" name="userLevelDes" type="text">
									</div>
									<s:submit value="修改" cssClass="btn btn-lg btn-success btn-block"
									method="update"/>
								</s:form>
							</div>
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
</body>
</html>
