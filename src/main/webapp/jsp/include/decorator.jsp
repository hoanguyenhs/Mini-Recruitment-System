<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<%@include file="/jsp/include/head.jsp"%>

<body class="nth-body">    

	<div class="navbar navbar-default navbar-fixed-top">
		<div class="nth-narbar-container">
	  		<div class="navbar-header">
	    		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Recruitment Manegement System</a>
	  		</div>
	 		<div class="navbar-collapse collapse navbar-responsive-collapse">		
	    		<ul class="nav navbar-nav navbar-right">
	      			<li class="dropdown">
	        			<a href="#" class="dropdown-toggle nth-label" data-toggle="dropdown">
	        				<%
	        					if (session.getAttribute("username") == null) {
	        					    Authentication authentication = SecurityContextHolder.getContext()
	        							.getAuthentication();
	        						String username = authentication.getName();
	        						session = request.getSession();
	        						session.setAttribute("username", username);
	                            }
	        				%>
	        				Welcome <c:out value="${sessionScope.username}"/><b class="caret"></b>
	        			</a>
	        			<ul class="dropdown-menu">
	          				<li style="padding-left: 15px;">
	          					<div class="input-group">
      								<span class="glyphicon glyphicon-user"></span>
	          						<a class="nth-label" href="#">View Profile</a>
	          					</div>
	          				</li>
	          				<li style="padding-left: 15px;">
	          					<div class="input-group">
		          					<span class="glyphicon glyphicon-lock"></span>
		          					<a class="nth-label" href="${pageContext.request.contextPath}/system/change-password">Change Password</a>
        						</div>
        					</li>
	          				<li class="divider"></li>
	          				<li style="padding-left: 15px;">
	          					<div class="input-group">
		          					<span class="glyphicon glyphicon-off"></span>
		          					<a class="nth-label" data-toggle="modal" data-target="#nth-logout-modal" href="#">Logout</a>
          						</div>
          					</li>
	        			</ul>
	      			</li>
	    		</ul>
	  		</div>
  		</div>
	</div>
	
	<div class="nth-container">
		<div class="nth-col-left">
			<ul class="nav nav-pills nav-stacked">
  				<li><a class="nth-menu" href="${pageContext.request.contextPath}/candidate/create">CREATE CANDIDATE</a></li>
  				<li><a class="nth-menu" href="${pageContext.request.contextPath}/candidate/search">SEARCH CANDIDATE</a></li>
  				<li><a class="nth-menu" href="${pageContext.request.contextPath}/position/create">CREATE POSITION</a></li>
  				<li><a class="nth-menu" href="${pageContext.request.contextPath}/position/search">SEARCH POSITION</a></li>
  				<li><a class="nth-menu" href="${pageContext.request.contextPath}/vacancy/create">CREATE VACANCY</a></li>
  				<li><a class="nth-menu" href="${pageContext.request.contextPath}/vacancy/search">SEARCH VACANCY</a></li>
  				<li><a class="nth-menu" href="#">SYSTEM SETTING</a></li>
			</ul>	
		</div>
		<div class="nth-col-right">
			<sitemesh:write property='body'/>
		</div>
	</div>
	
	<div class="jumbotron nth-footer">
  		<h1>Recruitment Manegement System</h1>
  		<p>Make by Nguyen Thuan Hoa. Contact him at 
  		<a href="mailto:nguyenthuanhoahs@gmail.com">nguyenthuanhoahs@gmail.com</a></p>
	</div>
	
	<div class="modal fade" id="nth-logout-modal">
	  	<div class="modal-dialog">
	  		<div class="modal-content">
	  		<div class="modal-header">
		        <h4 class="modal-title">Logout confirm</h4>
	    	</div>
	      	<div class="modal-body">
	        	<p>Are you sure want to logout?</p>
	      	</div>
			<div class="modal-footer">
	    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
	    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/logout">Yes</a>
	  		</div>
	  		</div>
		</div>
	</div>

</body>
</html>