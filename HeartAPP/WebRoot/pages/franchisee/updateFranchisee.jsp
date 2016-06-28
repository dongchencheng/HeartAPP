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
    <title>修改加盟商</title>
    
    
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
	<c:if test="${empty franchisee}">
		<c:redirect url="/franchiseeAction" />
	</c:if>
  
  	<jsp:include page="/pages/common/common.jsp" />
  
    <div id="page-wrapper">
        <div class="row">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">修改加盟商
	                    <a href="/HeartAPP/franchiseeAction?page=${page}&SadminName=${SadminName}&SfrName=${SfrName}">
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
								<s:form action="franchiseeAction" theme="simple">
									<input name="page" type="hidden" value="${page}"/>
									<input name="SadminName" type="hidden" value="${SadminName}"/>
									<input name="SfrName" type="hidden" value="${SfrName}"/>
									<s:actionerror cssStyle="color:red"/>
									<s:token></s:token>
									<div class="form-group">ID
										<input class="form-control"
											value="${idFranchisee}" name="idFranchisee" type="text"
											readonly="readonly">
									</div>
									<div class="form-group">负责人名称*
										<input class="form-control"
											value="${franchisee.adminName}" name="adminName" type="text"
											autofocus="autofocus" required="required">
									</div>
									<div class="form-group">负责人手机*
										<input class="form-control"
											value="${franchisee.adminTel}" name="adminTel" type="tel"
											required="required">
									</div>
									<div class="form-group">加盟商名称*
										<input class="form-control"
											value="${franchisee.frName}" name="frName" type="text"
											required="required">
									</div>
									<div class="form-group">国家
										<input class="form-control"
											value="${franchisee.frCountry}" name="frCountry" type="text">
									</div>
									<div class="form-group">省份
										<input class="form-control"
											value="${franchisee.frProvience}" name="frProvience"
											type="text">
									</div>
									<div class="form-group">介绍
										<input class="form-control"
											value="${franchisee.frDes}" name="frDes" type="text">
									</div>
									<div class="form-group">地址
										<input class="form-control"
											value="${franchisee.frAddress}" name="frAddress" type="text">
									</div>
									<div class="form-group">说明
										<input class="form-control"
											value="${franchisee.notes}" name="notes" type="text">
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
