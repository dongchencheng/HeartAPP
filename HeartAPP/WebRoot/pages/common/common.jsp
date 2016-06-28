<!DOCTYPE>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
  <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/HeartAPP/pages/index.jsp">心里有你</a>
            </div>
            <!-- 手机版导航栏按钮 -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 个人信息</a>
                        </li>
                        <li><a href="/HeartAPP/pages/common/update.jsp"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="/HeartAPP/loginAction"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                        </li>
                        <li>
                            <a href="/HeartAPP/pages/index.jsp"><i class="fa fa-home fa-fw"></i> 首页</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> 普通用户相关<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                            		<a href="#"><i class="glyphicon glyphicon-user fa-fw"></i> 用户信息<span class="fa arrow"></span></a>
                            		<ul class="nav nav-third-level">
		                                <li>
		                                    <a href="/HeartAPP/normaluserAction"><i class="fa fa-user fa-fw"></i> 普通用户</a>
		                                </li>
		                                <li>
		                                    <a href="/HeartAPP/userlevelAction"><i class="fa fa-star fa-fw"></i> 用户级别</a>
		                                </li>
		                                <li>
		                                    <a href="/HeartAPP/userstatusAction"><i class="fa fa-tree fa-fw"></i> 用户状态</a>
		                                </li>
		                                <li>
		                                    <a href="/HeartAPP/usercreatetypeAction"><i class="fa fa-globe fa-fw"></i> 注册来源</a>
		                                </li>
                            		</ul>
                            		<!-- /.nav-third-level -->
                      			</li>
                                <li>
                                    <a href="#"><i class="fa  fa-play-circle fa-fw"></i> 使用资源<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="/HeartAPP/usercollectAction"><i class="fa fa-bookmark fa-fw"></i> 用户收藏</a>
                                        </li>
                                        <li>
                                            <a href="/HeartAPP/nuserlikedAction"><i class="fa fa-heart fa-fw"></i> 用户喜欢</a>
                                        </li>
                                        <li>
                                            <a href="/HeartAPP/nuserclickedAction"><i class="fa fa-location-arrow fa-fw"></i> 用户点击</a>
                                        </li>
                                        <li>
                                            <a href="/HeartAPP/nuservisitedAction"><i class="fa fa-sign-in fa-fw"></i> 用户访问</a>
                                        </li>
                                        <li>
                                            <a href="/HeartAPP/nuserrecommenedAction"><i class="fa fa-thumbs-o-up fa-fw"></i> 用户推荐</a>
                                        </li>
                                        <li>
                                            <a href="/HeartAPP/nusersearchedAction"><i class="fa fa-search fa-fw"></i> 用户查找</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-frown-o fa-fw"></i> 用户宣泄<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="/HeartAPP/catharsisAction"><i class="fa fa-edit fa-fw"></i> 宣泄信息</a>
                                        </li>
                                        <li>
                                            <a href="/HeartAPP/nusercathrelAction"><i class="fa fa-chain fa-fw"></i> 宣泄关系</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-smile-o fa-fw"></i> 积极暗示<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="/HeartAPP/positivesuggestionAction"><i class="fa fa-edit fa-fw"></i> 暗示信息</a>
                                        </li>
                                        <li>
                                            <a href="/HeartAPP/nusersugrelAction"><i class="fa fa-chain fa-fw"></i> 暗示关系</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-music fa-fw"></i> 资源自身信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                	<a href="flot.html"><i class="fa fa-file-o fa-fw"></i> 资源信息</a>
                                </li>
                                <li>
                                	<a href="flot.html"><i class="fa fa-tag fa-fw"></i> 资源大类</a>
                                </li>
                                <li>
                                	<a href="flot.html"><i class="fa fa-chain fa-fw"></i> 大类关系</a>
                                </li>
                                <li>
                                	<a href="flot.html"><i class="fa fa-tag fa-fw"></i> 资源属性</a>
                                </li>
                                <li>
                                	<a href="flot.html"><i class="fa fa-chain fa-fw"></i> 属性关系</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-bank fa-fw"></i> 加盟商信息<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                	<a href="/HeartAPP/franchiseeAction"><i class="fa fa-bank fa-fw"></i> 加盟商</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-child fa-fw"></i> 心理咨询师相关<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                	<a href="/HeartAPP/counselorAction"><i class="fa fa-credit-card fa-fw"></i> 咨询师自身信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-plus-square fa-fw"></i> 患者相关<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                	<a href="flot.html"><i class="fa fa-folder-open fa-fw"></i> 患者自身信息</a>
                                </li>
                                <li>
                                	<a href="/HeartAPP/taskAction"><i class="fa fa-tasks fa-fw"></i> 任务信息</a>
                                </li>
                                <li>
                                	<a href="/HeartAPP/taskfinishedAction"><i class="fa fa-check fa-fw"></i> 任务完成</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
