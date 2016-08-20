<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<%@include file="/jsp/include/head.jsp"%>

<body>
	
	<c:url value="/j_spring_security_check" var="security_check_action" />
	<form class="form-horizontal nth-login-form" action="${security_check_action}" method="post">
		<h3 class="form-signin-heading nth-login-caption">Do amazing thing with amazing tool</h3>
		<div class="form-group">
    		<label class="col-sm-2 control-label nth-label">Username</label>
    		<div class="col-sm-10">
    			<div class="input-group">
  					<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-user"></span></span>
  					<input name="j_username" type="text" class="form-control" placeholder="Username" required"/>
				</div>
    		</div>
  		</div>
  		<div class="form-group">
    		<label class="col-sm-2 control-label nth-label">Password</label>
    		<div class="col-sm-10">
    			<div class="input-group">
  					<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-lock"></span></span>
  					<input name="j_password" type="password" class="form-control" placeholder="Password" required/>
				</div>
    		</div>
  		</div>
  		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-primary nth-login-button">Login</button>
    		</div>
  		</div>
  		<span class="label label-default nth-login-error nth-label">${message }</span>
	</form>
	
</body>
</html>