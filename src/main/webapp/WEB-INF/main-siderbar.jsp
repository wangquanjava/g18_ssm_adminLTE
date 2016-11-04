 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./base.jsp"%>
  <!--   左边菜单 -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${webRoot}/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${userEntity.realname }</p>
        </div>
      </div>
      
      <!-- 左侧菜单 -->
      <ul class="sidebar-menu">
        <li class="index">
          <a href="${webRoot }/pageController/index">
            <i class="fa fa-th"></i> <span>主页</span>
          </a>
        </li>
        
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i>
            <span>个人管理</span>
            <span class="pull-right-container">
            	<i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          
          <ul class="treeview-menu">
            <li class="profile">
            	<a href="${webRoot }/pageController/profile"><i class="fa fa-circle-o"></i>个人信息</a>
            </li>
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i>
            <span>后台管理</span>
            <span class="pull-right-container">
            	<i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          
          <ul class="treeview-menu">
            <li class="manager-import">
            	<a href="${webRoot }/pageController/manager-import"><i class="fa fa-circle-o"></i>学生信息导入</a>
            </li>
          </ul>
        </li>
        
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i>
            <span>作业管理</span>
            <span class="pull-right-container">
            	<i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          
          <ul class="treeview-menu">
            <li>
            	<a href="index.html"><i class="fa fa-circle-o"></i> 提交作业</a>
            </li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> 检查作业</a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i>作业列表</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
