<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <jsp:include page="./main-header.jsp"></jsp:include>
  <jsp:include page="./main-siderbar.jsp"></jsp:include>
  
  <!-- 中间文档区 -->
  <div class="content-wrapper">
     	这是主页
  </div>
  <!-- /.content-wrapper -->
  
  <jsp:include page="./main-footer.jsp"></jsp:include>
<script>
	  	console.log($);
$(".index").addClass("active");
 </script>