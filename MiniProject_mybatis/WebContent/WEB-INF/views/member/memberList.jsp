<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="ejyoo.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="kr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
  <title>ejyoo Adminmanagement</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Page specific css -->
  <style>
  .table.dataTable  {
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: 13px;
	}
	</style>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
<!--         <a href="#" class="nav-link">Home</a> -->
      </li>
      <li class="nav-item d-none d-sm-inline-block">
<!--         <a href="#" class="nav-link">Contact</a> -->
      </li>
    </ul>
    
    
    
    

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Navbar Search -->
      <li class="nav-item">
        <a class="nav-link" data-widget="navbar-search" href="#" role="button">
<!--           <i class="fas fa-search"></i> -->
        </a>
        <div class="navbar-search-block">
          <form class="form-inline">
            <div class="input-group input-group-sm">
              <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
              <div class="input-group-append">
<!--                 <button class="btn btn-navbar" type="submit"> -->
<!--                   <i class="fas fa-search"></i> -->
<!--                 </button> -->
<!--                 <button class="btn btn-navbar" type="button" data-widget="navbar-search"> -->
<!--                   <i class="fas fa-times"></i> -->
<!--                 </button> -->
              </div>
            </div>
          </form>
        </div>
      </li>

      <!-- Messages Dropdown Menu -->
<!--       <li class="nav-item dropdown"> -->
<!--         <a class="nav-link" data-toggle="dropdown" href="#"> -->
<!--           <i class="far fa-comments"></i> -->
<!--           <span class="badge badge-danger navbar-badge">3</span> -->
<!--         </a> -->
<!--         <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right"> -->
<!--           <a href="#" class="dropdown-item"> -->
<!--             Message Start -->
<!--             <div class="media"> -->
<%--               <img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle"> --%>
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
<!--           </a> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a href="#" class="dropdown-item"> -->
<!--             Message Start -->
<!--             <div class="media"> -->
<%--               <img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3"> --%>
<!--               <div class="media-body"> -->
<!--                 <h3 class="dropdown-item-title"> -->
<!--                   John Pierce -->
<!--                   <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span> -->
<!--                 </h3> -->
<!--                 <p class="text-sm">I got your message bro</p> -->
<!--                 <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p> -->
<!--               </div> -->
<!--             </div> -->
<!--             Message End -->
<!--           </a> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a href="#" class="dropdown-item"> -->
<!--             Message Start -->
<!--             <div class="media"> -->
<%--               <img src="<%=request.getContextPath() %>/resources/bootstrap/dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3"> --%>
<!--               <div class="media-body"> -->
<!--                 <h3 class="dropdown-item-title"> -->
<!--                   Nora Silvester -->
<!--                   <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span> -->
<!--                 </h3> -->
<!--                 <p class="text-sm">The subject goes here</p> -->
<!--                 <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p> -->
<!--               </div> -->
<!--             </div> -->
<!--             Message End -->
<!--           </a> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a href="#" class="dropdown-item dropdown-footer">See All Messages</a> -->
<!--         </div> -->
<!--       </li> -->
<!--       Notifications Dropdown Menu -->
<!--       <li class="nav-item dropdown"> -->
<!--         <a class="nav-link" data-toggle="dropdown" href="#"> -->
<!--           <i class="far fa-bell"></i> -->
<!--           <span class="badge badge-warning navbar-badge">15</span> -->
<!--         </a> -->
<!--         <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right"> -->
<!--           <span class="dropdown-header">15 Notifications</span> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a href="#" class="dropdown-item"> -->
<!--             <i class="fas fa-envelope mr-2"></i> 4 new messages -->
<!--             <span class="float-right text-muted text-sm">3 mins</span> -->
<!--           </a> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a href="#" class="dropdown-item"> -->
<!--             <i class="fas fa-users mr-2"></i> 8 friend requests -->
<!--             <span class="float-right text-muted text-sm">12 hours</span> -->
<!--           </a> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a href="#" class="dropdown-item"> -->
<!--             <i class="fas fa-file mr-2"></i> 3 new reports -->
<!--             <span class="float-right text-muted text-sm">2 days</span> -->
<!--           </a> -->
<!--           <div class="dropdown-divider"></div> -->
<!--           <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a> -->
<!--         </div> -->
<!--       </li> -->
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
              <i class="fas fa-search fa-fw"></i>
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
            <h1 class="m-0">회원 관리</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
<!--               <li class="breadcrumb-item"><a href="#">Home</a></li> -->
<!--               <li class="breadcrumb-item active">Starter Page</li> -->
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
<!--     /.content-header -->
<!-- zzzzzzzzzzzzzzzzzzz -->
<!-- 	<div class="col-md-3"> -->
<!--             <div class="card card-success shadow-sm"> -->
<!--               <div class="card-header"> -->
<!--                 <h3 class="card-title">Shadow - Small</h3> -->

<!--                 <div class="card-tools"> -->
<!--                   <button type="button" class="btn btn-tool" data-card-widget="collapse"> -->
<!--                     <i class="fas fa-minus"></i> -->
<!--                   </button> -->
<!--                 </div> -->
<!--                 /.card-tools -->
<!--               </div> -->
<!--               /.card-header -->
<!--               <div class="card-body"> -->
<!--                 The body of the card -->
<!--               </div> -->
<!--               /.card-body -->
<!--             </div> -->
<!--             /.card -->
<!--           </div> -->
<!--           /.col -->



    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
       	<div class="row">
       		<div class="col-sm-12">
       			<div class="row">
	       				<div class="col-sm-8">
	       				
	       				
	       					<div class="card">
			       				<div class="card-header">
			       					<div class="row">
			       						<div class="col-sm-10">
			       							<h3 class="card-title">회원 목록</h3>
			       						</div>
			       						<div class="col-sm-2">
			       							<a type='button' class="btn btn-secondary btn-sm" href='insertMember' >회원등록</a>
			       						</div>
			       					</div>
			       				</div> <!-- /.card-header -->
			       				
			       				<div class="card-body">
			       					<table id="example1" class="table table-bordered table-striped">
			                  <thead>
			                  <tr>
			                  	<th>#</th>
			                    <th>#</th>
			                    <th>아이디</th>
			                    <th>비밀번호</th>
			                    <th>전화번호</th>
			                    <th>이메일</th>
			                    <th>#</th>
			                    <th>#</th>
			                  </tr>
			                  </thead>
			                  <tbody>
			                  	<c:forEach items="${memberList}" var="memberDto">
			                  		<c:set var="i" value="${i+1}"/>
														<tr>
															<td>${i}</td>
															<td><i class="fas fa-info-circle curserStyle" onclick="goLocation('member?userId=${memberDto.userId}')"></i></td>
															<td>${memberDto.userId}</td>
															<td>${memberDto.userPw}</td>
															<td>${memberDto.userPhone}</td>
															<td>${memberDto.userEmail}</td>
															<td>
																<a type='button' class="btn btn-secondary btn-sm" href='updateMember?userId=${memberDto.userId}'>수정</a>
															</td>
															<td>
																<a type='button' class="btn btn-secondary btn-sm" onclick="confirmMessage('delete','deleteMember?userId=${memberDto.userId}')">삭제</a>
															</td>
														</tr>
													</c:forEach>
			                  </tbody>
			                  <tfoot>
			                  <tr>
			                    <th>#</th>
			                    <th>#</th>
			                    <th>아이디</th>
			                    <th>비밀번호</th>
			                    <th>전화번호</th>
			                    <th>이메일</th>
			                    <th></th>
			                    <th></th>
			                  </tr>
			                  </tfoot>
			                </table>
			              </div><!-- /.card-body -->
			              
		              	<div class="card-footer"></div><!-- /.card-footer -->
			       			</div><!-- /.card -->
			       			
			       			
	       				</div><!-- /.col-sm-8  -->
	       				<div class="col-sm-4">
	       					<div class="card">
	       						<div class="card-header"></div>
	       						<div class="card-body"></div>
	       						<div class="card-footer"></div>
	       					</div><!-- close card -->
	       				</div><!-- close col-sm-4 -->
       			</div>
       		</div>
       	</div>
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

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
<!-- DataTables  & Plugins -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jszip/jszip.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/pdfmake/pdfmake.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/pdfmake/vfs_fonts.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/demo.js"></script>
<!-- common util -->
<script src="<%= request.getContextPath() %>/js/memberSystemUtil.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
//       "buttons": ["copy", "excel", "pdf", "print", "colvis"], //"csv"
      buttons: [
    	    {
    	        extend:    'copyHtml5',
    	        text:      'copy',
    	        titleAttr: 'Copy to Clipboard',
    	    },
    	    {
    	        extend:    'excel',
    	        text:      'excel',
    	        titleAttr: 'Download to Excel',
    	    },
    	    {
    	        extend:    'pdf',
    	        text:      'pdf',
    	        titleAttr: 'Download to pdf',
    	    },
    	    {
    	        extend:    'print',
    	        text:      'print',
    	        titleAttr: 'Print',
    	    },
    	    {
    	        extend:    'colvis',
    	        text:      'columns',
    	        titleAttr: 'Visible Columns',
    	        columns:   ':not(.noVis)',
    	    },
    	    {
    	        extend:    'pageLength',
    	        text:      'rows',
    	        titleAttr: 'Number of Rows',
    	    },
    	],
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)'); 
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
    $('.curserStyle').css('cursor','pointer');
    $(":button").attr("aria-controls","example1").css("border","1px solid #56606a");
  });
</script>
</body>
</html>