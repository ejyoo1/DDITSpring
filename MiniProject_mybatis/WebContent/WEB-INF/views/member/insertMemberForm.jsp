<%@page import="ejyoo.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>ejyoo Adminmanagement</title>
	
	<!-- Google Font: Source Sans Pro -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body>
	<div class="wrapper">
		<!-- Navbar -->
	  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
	    <!-- Left navbar links -->
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
	      </li>
	      <li class="nav-item d-none d-sm-inline-block">
<!-- 	        <a href="#" class="nav-link">Home</a> -->
	      </li>
	      <li class="nav-item d-none d-sm-inline-block">
<!-- 	        <a href="#" class="nav-link">Contact</a> -->
	      </li>
	    </ul>
	    <!-- Right navbar links -->
    	<ul class="navbar-nav ml-auto">
	    	<!-- Navbar Search -->
	      <li class="nav-item">
	      	<a class="nav-link" data-widget="navbar-search" href="#" role="button">
<!--           	<i class="fas fa-search"></i> -->
        	</a>
        	<div class="navbar-search-block">
	          <form class="form-inline">
	            <div class="input-group input-group-sm">
	              <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
	              <div class="input-group-append">
<!-- 	                <button class="btn btn-navbar" type="submit"> -->
<!-- 	                  <i class="fas fa-search"></i> -->
<!-- 	                </button> -->
<!-- 	                <button class="btn btn-navbar" type="button" data-widget="navbar-search"> -->
<!-- 	                  <i class="fas fa-times"></i> -->
<!-- 	                </button> -->
	              </div>
	            </div>
	          </form>
        	</div>
      	</li>
      	
      	<!-- Messages Dropdown Menu -->
<!--       	<li class="nav-item dropdown"> -->
<!-- 	      	<a class="nav-link" data-toggle="dropdown" href="#"> -->
<!-- 	          <i class="far fa-comments"></i> -->
<!-- 	          <span class="badge badge-danger navbar-badge">3</span> -->
<!-- 	        </a> -->
<!-- 	        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right"> -->
<!--           	<a href="#" class="dropdown-item"> -->
<!--           		Message Start -->
<!--             <div class="media"> -->
<%--             	<img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle"> --%>
<!--               <div class="media-body"> -->
<!--                 <h3 class="dropdown-item-title"> -->
<!--                   Brad Diesel -->
<!--                   <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> -->
<!--                 </h3> -->
<!--                 <p class="text-sm">Call me whenever you can...</p> -->
<!--                 <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p> -->
<!--               </div> -->
<!--             </div> -->
<!--             Message End -->
<!--             </a> -->
<!-- 	          <div class="dropdown-divider"></div> -->
<!-- 	          <a href="#" class="dropdown-item"> -->
<!-- 		          Message Start -->
<!-- 	            <div class="media"> -->
<%-- 	              <img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3"> --%>
<!-- 	              <div class="media-body"> -->
<!-- 	                <h3 class="dropdown-item-title"> -->
<!-- 	                  John Pierce -->
<!-- 	                  <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span> -->
<!-- 	                </h3> -->
<!-- 	                <p class="text-sm">I got your message bro</p> -->
<!-- 	                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p> -->
<!-- 	              </div> -->
<!-- 	            </div> -->
<!-- 	            Message End -->
<!-- 	          </a> -->
<!-- 	          <div class="dropdown-divider"></div> -->
<!--          		<a href="#" class="dropdown-item"> -->
<!-- 	         		Message Start -->
<!-- 	            <div class="media"> -->
<%-- 	              <img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3"> --%>
<!-- 	              <div class="media-body"> -->
<!-- 	                <h3 class="dropdown-item-title"> -->
<!-- 	                  Nora Silvester -->
<!-- 	                  <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span> -->
<!-- 	                </h3> -->
<!-- 	                <p class="text-sm">The subject goes here</p> -->
<!-- 	                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p> -->
<!-- 	              </div> -->
<!-- 	            </div> -->
<!-- 	            Message End -->
<!-- 	          </a> -->
<!-- 	          <div class="dropdown-divider"></div> -->
<!-- 	          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a> -->
<!-- 	        </div> -->
<!-- 	      </li> -->
<!-- 	      Notifications Dropdown Menu -->
<!-- 	      <li class="nav-item dropdown"> -->
<!-- 	        <a class="nav-link" data-toggle="dropdown" href="#"> -->
<!-- 	          <i class="far fa-bell"></i> -->
<!-- 	          <span class="badge badge-warning navbar-badge">15</span> -->
<!-- 	        </a> -->
<!-- 	        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right"> -->
<!-- 	          <span class="dropdown-header">15 Notifications</span> -->
<!-- 	          <div class="dropdown-divider"></div> -->
<!-- 	          <a href="#" class="dropdown-item"> -->
<!-- 	            <i class="fas fa-envelope mr-2"></i> 4 new messages -->
<!-- 	            <span class="float-right text-muted text-sm">3 mins</span> -->
<!-- 	          </a> -->
<!-- 	          <div class="dropdown-divider"></div> -->
<!-- 	          <a href="#" class="dropdown-item"> -->
<!-- 	            <i class="fas fa-users mr-2"></i> 8 friend requests -->
<!-- 	            <span class="float-right text-muted text-sm">12 hours</span> -->
<!-- 	          </a> -->
<!-- 	          <div class="dropdown-divider"></div> -->
<!-- 	          <a href="#" class="dropdown-item"> -->
<!-- 	            <i class="fas fa-file mr-2"></i> 3 new reports -->
<!-- 	            <span class="float-right text-muted text-sm">2 days</span> -->
<!-- 	          </a> -->
<!-- 	          <div class="dropdown-divider"></div> -->
<!-- 	          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a> -->
<!-- 	        </div> -->
<!-- 	      </li> -->
	      <li class="nav-item">
	        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
	          <i class="fas fa-expand-arrows-alt"></i>
	        </a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
	          <i class="fas fa-th-large"></i>
	        </a>
	      </li>
	    </ul>
	  </nav>
	  <!-- /.navbar -->
	  <!-- Main Sidebar Container -->
	  <aside class="main-sidebar sidebar-dark-primary elevation-4">
	    <!-- Brand Logo -->
	    <a href="#" class="brand-link">
	      <img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
	      <span class="brand-text font-weight-light">management</span>
	    </a>
	
	    <!-- Sidebar -->
	    <div class="sidebar">
	      <!-- Sidebar user panel (optional) -->
	      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
	        <div class="image">
	          <img src="<%=request.getContextPath() %>/resources/images/ejyoo.png" class="img-circle elevation-2" alt="User Image">
	        </div>
	        <div class="info">
	          <a href="#" class="d-block">ejyoo</a>
	        </div>
	      </div>
	
	      <!-- SidebarSearch Form -->
	      <div class="form-inline">
	        <div class="input-group" data-widget="sidebar-search">
	          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
	          <div class="input-group-append">
	            <button class="btn btn-sidebar">
<!-- 	              <i class="fas fa-search fa-fw"></i> -->
	            </button>
	          </div>
	        </div>
	      </div>
	
	      <!-- Sidebar Menu -->
	      <nav class="mt-2">
	        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
	          <li class="nav-item">
	            <a href="#" class="nav-link">
	              <i class="nav-icon fas fa-table"></i>
	              <p>
                	회원관리시스템
	                <i class="fas fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href="memberList" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
                  <p>등록 회원 관리</p>
	                </a>
	              </li>
	            </ul>
	          </li>
	        </ul>
	      </nav>
	      <!-- /.sidebar-menu -->
	    </div>
	    <!-- /.sidebar -->
	  </aside>
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <div class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1 class="m-0">회원 등록</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
<!-- 	              <li class="breadcrumb-item"><a href="#">Home</a></li> -->
<!-- 	              <li class="breadcrumb-item active">Starter Page</li> -->
	            </ol>
	          </div><!-- /.col -->
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div>
	    <!-- /.content-header -->
	
	    <!-- Main content -->
	    <div class="content">
	      <div class="container-fluid">
	       	<div class="row">
	       			<!-- left col -->
	       			<div class="col-sm-2"></div><!-- ./col-sm-2 -->
	       			<div class="col-sm-8">
	       				<!-- jquery validation -->
	       				<div class="card card-secondary">
	              	<div class="card-header">
	                	<h3 class="card-title">회원 등록</h3>
	              	</div><!-- /.card-header -->
	              	<!-- form start -->
	              	<form id="fm" method="post" action="insertMember">
	                	<div class="card-body">
	                		<div class="form-group">
	                    	<label for="userId">아이디</label>
	                    	<div class="input-group">
		                    	<input type="text" name="userId" class="form-control" id="userId" placeholder="아이디를 입력하세요.">
		                    	<div class="input-group-append">
	                        	<span class="input-group-text" id="idchkSpan" onclick="validationId('<%=request.getContextPath() %>')">중복확인</span>
	                      	</div>
	                    	</div>
	                  	</div>
	                  <div class="form-group">
	                    <label for="userPw">비밀번호</label>
	                    <input type="password" name="userPw" class="form-control" id="userPw" placeholder="비밀번호를 입력하세요.">
	                  </div>
	                  <div class="form-group">
	                    <label for="userPhone">휴대전화</label>
	                    <input type="text" name="userPhone" class="form-control" id="userPhone" placeholder="휴대전화 번호를 입력하세요.">
	                  </div>
	                  <div class="form-group">
	                    <label for="userEmail">이메일</label>
	                    <input type="email" name="userEmail" class="form-control" id="userEmail" placeholder="이메일을 입력하세요.">
	                  </div>
	                  <div class="form-group mb-0">
	                    <div class="custom-control custom-checkbox">
	                      <input type="checkbox" name="terms" class="custom-control-input" id="exampleCheck1">
	                      <label class="custom-control-label" for="exampleCheck1">I agree to the <a href="#">terms of service</a>.</label>
	                    </div>
	                  </div>
	                </div><!-- /.card-body -->
	                
	                <div class="card-footer">
	                  <button type="submit" class="btn btn-secondary btn-sm">등록</button>
	                  <input type="text" name="idchk" id="idchk" hidden/>
	                </div><!-- /.card-footer -->
	              </form>
	            </div>
	            <!-- /.card card-secondary -->
	            </div><!--/.col-sm-8 -->
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div><!-- ./content -->
	  </div><!-- /.content-wrapper -->
	
	  <!-- Control Sidebar -->
	  <aside class="control-sidebar control-sidebar-dark">
	    <!-- Control sidebar content goes here -->
	    <div class="p-3">
	      <h5>Title</h5>
	      <p>Sidebar content</p>
	    </div>
	  </aside>
	  <!-- /.control-sidebar -->
	
	  <!-- Main Footer -->
	  <footer class="main-footer">
	    <!-- To the right -->
	    <div class="float-right d-none d-sm-inline">
	      Anything you want
	    </div>
	    <!-- Default to the left -->
	    <strong>Copyright &copy; 2014-2021 <a href="#">ejyoo</a>.</strong> All rights reserved.
	  </footer>
	</div>
	<!-- ./wrapper -->
	
	<!-- REQUIRED SCRIPTS -->
	
	<!-- jQuery -->
	<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- jquery-validation -->
	<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery-validation/jquery.validate.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery-validation/additional-methods.min.js"></script>
	<!-- AdminLTE App -->
	<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/demo.js"></script>
	<!-- Page specific script -->
	<script>
	$(function () {
		  $.validator.setDefaults({
		    submitHandler: function () {
		    	var flag = $("#idchk").text();
		    	if(flag=="false"){
		    		alert("아이디 중복검사를 진행해주세요.");
		    		return false;
		    	}else{
		    		return true;
		    	}
		    }
		  });
		  
		  $.validator.addMethod("englishLetters", function(value, element){
			  return this.optional(element) || value.match(/^[a-zA-Z0-9\.\,\s]+( [a-zA-Z0-9\.\,\s]+)*$/);
			}, "영어로 입력 해주세요.");
	
			$.validator.addMethod("koreanLetters", function(value, element){
				return this.optional(element) || value.match(/^[가-힣]+$/);
			}, "한글로 입력 해주세요.");
		  
			$.validator.addMethod("hasBlank", function(value, element) {
				return this.optional(element) || !value.match(" ");
			}, "빈 칸은 입력하실 수 없습니다.");
			
		  $.validator.addMethod("userId", function(value, element){
		  	return this.optional(element) || value.match(/^(?=.*[a-z])[a-z0-9]{4,12}$/);
		  }, "4~12자 영문 소문자, 숫자를 사용하세요. 영문 소문자는 필수입니다.");
			
			$.validator.addMethod("userPhone", function(phone_number, element) {
				phone_number = phone_number.replace(/\s+/g, "");
				return this.optional(element) || phone_number.match(/^\d{3}-\d{3,4}-\d{4}$/);
			}, "잘못된 휴대폰 번호입니다. 숫자, – 를 포함한 숫자만 입력하세요.");
			
		  
		  $('#fm').validate({
		    rules: {
		    	userId: {
		    		required: true,
		    		userId: true,
		    		hasBlank: true
		    	},
		      userPw: {
		        required: true,
		        englishLetters: true,
		        hasBlank: true
		      },
		      userPhone: {
		    	  required: true,
		    	  userPhone: true,
		    	  hasBlank: true
		      },
		      userEmail: {
			        required: true,
			        hasBlank: true
			      },
		      terms: {
		        required: true
		      },
		    },
		    messages: {
		    	userId:{
		    			required: "아이디를 입력해 주세요.",
		    			englishLetters: "4~12자 영문 소문자, 숫자를 사용하세요. 영문 소문자는 필수입니다."
		    	},
		    	userPw: {
			        required: "비밀번호를 입력해 주세요.",
			      },
		    	userPhone: {
			    	  required: "휴대폰 번호를 입력해 주세요.",
			    	  phoneNumbers: "올바른 휴대전화 번호를 입력하여주세요. 010-0000-0000"
			      },
		    	userEmail: {
		        required: "이메일을 입력해 주세요.",
		        email: "올바른 이메일 주소를 입력해주세요. test@test.com"
		      },
		      terms: "정보 제공 동의 체크해주세요."
		    },
		    errorElement: 'span',
		    errorPlacement: function (error, element) {
		      error.addClass('invalid-feedback');
		      element.closest('.form-group').append(error);
		    },
		    highlight: function (element, errorClass, validClass) {
		      $(element).addClass('is-invalid');
		    },
		    unhighlight: function (element, errorClass, validClass) {
		      $(element).removeClass('is-invalid');
		    }
		    
		  });
		});
		
</script>
<script src="<%= request.getContextPath() %>/js/memberSystemUtil.js"></script>
</body>
</html>