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
    <title>宣泄关系管理</title>
    
    
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
                    <h1 class="page-header">宣泄关系表</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div align="right">
								<label>宣泄ID：
									<input type="number" value="${SidCatharsis}"
									name="SidCatharsis" id="SidCatharsis"
									onkeyup="value=value.replace(/[^(\d)]/g,'')"
									onkeydown="if(event.keyCode==13)search()"> </label>
								<button class="btn btn-default" onclick="search()"><i class="fa fa-search"></i></button>
							</div> 
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>ID</th>
											<th>用户</th>
											<th>宣泄信息ID</th>
											<th>积极暗示</th>
											<th>反馈时间</th>
											<th>说明</th>
											<th>修改</th>
											<th>删除</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="list" var="f">
											<tr>
												<td><s:property value="nusercathrel.idNuserCathRel" /></td>
												<td><s:property value="nusercathrel.idNuser" />  <s:property value="DUserName" /></td>
												<td><s:property value="nusercathrel.idCatharsis" /></td>
												<td><s:property value="nusercathrel.idPositiveSuggestion" />  <s:property value="DpositiveContent" /></td>
												<td><s:property value="nusercathrel.responseTime" /></td>
												<td><s:property value="nusercathrel.notes" /></td>
												<s:form action="nusercathrelAction" theme="simple">
												<s:token></s:token>
												<input name="idNuserCathRel" type="hidden" value="${nusercathrel.idNuserCathRel}"/>
												<input name="page" type="hidden" value="${page}"/>
												<input name="SidCatharsis" type="hidden" value="${SidCatharsis}"/>
												<td>
													<s:submit value="修改" cssClass="btn btn-success btn-xs" 
														method="searchById"/>
												</td>
												<td>
													<s:submit value="删除" cssClass="btn btn-success btn-xs" 
														method="delete" onclick="return deleteCheck()" />
												</td>
												</s:form>
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
				window.location.href='/HeartAPP/nusercathrelAction?page='+turnpage+'&SidCatharsis=${SidCatharsis}';
			}
		}else{
			window.location.href='/HeartAPP/nusercathrelAction?page='+x+'&SidCatharsis=${SidCatharsis}';
			}
		}
	function deleteCheck() {
		if (!confirm("确认要删除该宣泄关系？")){
			window.event.returnValue = false; 
		}
	}
	function search() {
		var SidCatharsis = document.getElementById("SidCatharsis").value;
		window.location.href='/HeartAPP/nusercathrelAction?SidCatharsis='+SidCatharsis;
	}
	</script>
</body>
</html>
