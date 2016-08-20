<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			Change password</b>
		</h3>
	</div>
	<div class="panel-body">
		<form:form id="login-form" class="form-horizontal" commandName="userModel" medthod="post">
			<div class="nth-button-group">
		        <button type="reset" class="btn btn-info nth-button" 
		        	data-toggle="modal" data-target="#nth-change-password-modal">
		        	<span class="glyphicon glyphicon-floppy-remove"></span>
		        	Cancel
	        	</button>
		        <button type="submit" class="btn btn-success nth-button">
		        	<span class="glyphicon glyphicon-floppy-saved"></span>
		        	Submit
	        	</button>
   			</div>
  			<fieldset>
    			<legend>Change password</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Old password</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-lock"></span></span>
        					<form:input path="oldPassword" id="old-password" class="form-control nth-input" placeholder="Old password" type="password" data-toogle="popover"></form:input>
       					</div>
       					<form:errors path="oldPassword" cssClass="label-danger nth-error"></form:errors>
      				</div>
    			</div>
   				<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">New password</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-lock"></span></span>
        					<form:input path="newPassword" id="new-password" class="form-control nth-input" placeholder="New password" type="password"></form:input>
      					</div>
      					<form:errors path="newPassword" cssClass="label-danger nth-error"></form:errors>
      					<form:errors path="newPasswordDuplicate" cssClass="label-danger nth-error"></form:errors>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Retype password</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-lock"></span></span>
        					<form:input path="retypePassword" class="form-control nth-input" placeholder="Retype pasword" type="password"></form:input>
      					</div>
      					<form:errors path="retypePassword" cssClass="label-danger nth-error"></form:errors>
      					<form:errors path="retypePasswordNotMatch" cssClass="label-danger nth-error"></form:errors>
      				</div>
    			</div>
  			</fieldset>
		</form:form>
	</div>
</div>

<div class="modal fade" id="nth-change-password-modal" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Cancel operation confirm</h4>
    	</div>
      	<div class="modal-body">
        	<p>Are you sure want to cancel the change password operation?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/">Yes</a>
  		</div>
  		</div>
	</div>
</div>

<div class="modal fade" id="nth-congratulation-modal" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Congratulation</h4>
    	</div>
      	<div class="modal-body">
        	<p id="nth-congratulation-modal-body-p">${message }</p>
      	</div>
		<div class="modal-footer">
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/">OK</a>
  		</div>
  		</div>
	</div>
</div>