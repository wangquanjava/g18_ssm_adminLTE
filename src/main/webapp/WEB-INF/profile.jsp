<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="./base.jsp"%>
  <jsp:include page="./main-header.jsp"></jsp:include>
  <jsp:include page="./main-siderbar.jsp"></jsp:include>
  
  <!-- 内容区 -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        	个人信息
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">User profile</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <div class="row">
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="${webRoot}/dist/img/user4-128x128.jpg" alt="User profile picture">

              <h3 class="profile-username text-center">${userEntity.realname }</h3>
			  
			  
              <p class="text-muted text-center">${userEntity.roleText }</p>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>作业数</b> <a class="pull-right">1,322</a>
                </li>
              </ul>

              <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          <!-- About Me Box -->
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#settings" data-toggle="tab">设置</a></li>
			  <!--
			  	 暂时隐藏时间线
			         <li><a href="#timeline" data-toggle="tab">时间线</a></li> 
			  -->
            </ul>
            <div class=" tab-content">
              <div class="active tab-pane" id="settings">
                <form class="form-horizontal" action="${webRoot }/userController/update" method="post">
                  <input type="hidden" name="id" value="${userEntity.id }">
<!--                   学号 -->
                  <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">学号</label>

                    <div class="col-sm-10">
                      <input type="email" class="form-control" disabled="disabled" value="${userEntity.userId }" id="inputName" placeholder="Name">
                    </div>
                  </div>
<!--                   姓名 -->
                  <div class="form-group">
                    <label for="inputReal" class="col-sm-2 control-label">姓名</label>

                    <div class="col-sm-10">
                      <input type="email" class="form-control" disabled="disabled" value="${userEntity.realname }" id="inputReal" placeholder="姓名">
                    </div>
                  </div>
<!--                   密码 -->
                  <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>

                    <div class="col-sm-10">
                      <input type="password" class="form-control" name="password" id="inputPassword" value="${userEntity.password }" placeholder="Password">
                    </div>
                  </div>
<!--                   邮箱 -->
                  <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">Email</label>

                    <div class="col-sm-10">
                      <input type="email" class="form-control" name="email" value="${userEntity.email }" id="inputEmail" placeholder="Email">
                    </div>
                  </div>
<!--                   入学日期 -->
	              <div class="form-group">
	                <label for="startDate" class="col-sm-2 control-label">Date:</label>
	                <div class="col-sm-10">
	                  <input type="text" class="form-control pull-right" id="startDate" value="<fmt:formatDate value='${userEntity.startDate}' pattern='yyyy-MM-dd'/>" placeholder="入学日期" name="startDate">
	                </div>
	                <!-- /.input group -->
	              </div>
                  
                  
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-danger">Submit</button>
                    </div>
                  </div>
                </form>
              </div>
              <!-- /.tab-pane -->
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
   
   
<jsp:include page="./main-footer.jsp"></jsp:include>
<script>
	$(".profile").parentsUntil(".sidebar-menu").andSelf().filter("li").addClass("active");
    $('#startDate').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
      });
</script>