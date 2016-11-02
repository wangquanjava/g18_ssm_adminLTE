<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <jsp:include page="./base.jsp"></jsp:include>
  <jsp:include page="./main-header.jsp"></jsp:include>
  <jsp:include page="./main-siderbar.jsp"></jsp:include>
  
  <!-- 中间文档区 -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
                         导入学生信息
        <small></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">General Elements</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <!-- left column -->
        <div>
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
                <div class="form-group">
                 <input type="file" multiple="false" name="fileInput" id="fileInput">

                  <p class="help-block">上传格式正确的excel</p>
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" id="submit" class="btn btn-primary">提交</button>
              </div>
          </div>
          <!-- /.box -->
        </div>
        <!--/.col (left) -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>

  <!-- /.content-wrapper -->
  
  <jsp:include page="./main-footer.jsp"></jsp:include>
<script src="${webRoot }/plugins/uploadifive/jquery.uploadifive.js"></script>
<link rel="stylesheet" href="${webRoot}/plugins/uploadifive/uploadifive.css">
<script>
	  	$(".maneger-import").parentsUntil(".sidebar-menu").andSelf().filter("li").addClass("active");
//	 	上传队列所有文件
		$("#submit").click(function() {
			$("#fileInput").uploadifive('upload');
		});
		//给按钮绑定对象
		$("#fileInput").uploadifive({
			uploadScript:'${webRoot}/managerController/uploadFile',
			auto:false,
			fileObjName:'fileFieldName',
			onUploadComplete:function(file, data, response){
				alert(JSON.parse(data).msg);
			}
		});
 </script>