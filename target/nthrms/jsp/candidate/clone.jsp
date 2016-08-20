<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			<a href="${pageContext.request.contextPath}/candidate/search">Search Candidate</a> / 
			<a href="${pageContext.request.contextPath}/candidate/view/${candidateModel.id }">View Candidate Detail</a> / 
			Clone Candidate</b>
		</h3> 
	</div>
	<div class="panel-body">
		<form:form class="form-horizontal" commandName="candidateModel" medthod="post">
			<div class="nth-button-group">
		        <button type="reset" class="btn btn-info nth-button" 
		        	data-toggle="modal" data-target="#nth-cancel-modal">
		        	<span class="glyphicon glyphicon-floppy-remove"></span>
		        	Cancel
	        	</button>
		        <button id="position-create" type="submit" class="btn btn-success nth-button">
		        	<span class="glyphicon glyphicon-floppy-saved"></span>
		        	Submit
		        </button>
   			</div>
  			<fieldset>
    			<legend>Clone candidate</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">First name</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-user"></span></span>
        					<form:input path="firstName" class="form-control nth-input" placeholder="First name" type="text"></form:input>
       					</div>
       					<form:errors path="firstName" cssClass="label-danger nth-error"></form:errors>
      				</div>
      				<label class="col-lg-2 control-label nth-label">Email</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-envelope"></span></span>
        					<form:input path="email" class="form-control nth-input" placeholder="Email" type="text"></form:input>
       					</div>
       					<form:errors path="email" cssClass="label-danger nth-error"></form:errors>
      				</div>
      			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Last name</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-user"></span></span>
        					<form:input path="lastName" class="form-control nth-input" placeholder="Last name" type="text"></form:input>
       					</div>
       					<form:errors path="lastName" cssClass="label-danger nth-error"></form:errors>
      				</div>
      				<label class="col-lg-2 control-label nth-label">Phone</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-earphone"></span></span>
        					<form:input path="phone" class="form-control nth-input" placeholder="Phone" type="text"></form:input>
       					</div>
       					<form:errors path="phone" cssClass="label-danger nth-error"></form:errors>
      				</div>
      			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Address</label>
    				<div class="col-lg-4">
    					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-home"></span></span>
    						<form:textarea path="address" class="form-control nth-textarea" placeholder="Address" type="text"></form:textarea>
    					</div>
    					<form:errors path="address" cssClass="label-danger nth-error"></form:errors>
    				</div>
    				<label class="col-lg-2 control-label nth-label">Link</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-link"></span></span>
        					<form:input path="link" class="form-control nth-input" placeholder="Link" type="text"></form:input>
       					</div>
      				</div>
      			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Description</label>
    				<div class="col-lg-4">
    					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-comment"></span></span>
    						<form:textarea path="description" class="form-control nth-textarea" placeholder="Position's description" type="text"></form:textarea>
    					</div>
    				</div>
      			</div>
      			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label">Certificate</label>
    				<div class="col-lg-10">
    					<form:errors path="certificate" cssClass="label-danger nth-error"></form:errors>
	    				<%@include file="/jsp/candidate/edit-certificate.jsp"%>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label">Experience</label>
    				<div class="col-lg-10">
    					<form:errors path="experience" cssClass="label-danger nth-error"></form:errors>
	    				<%@include file="/jsp/candidate/edit-experience.jsp"%>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label">Skill</label>
    				<div class="col-lg-10">
	    				<%@include file="/jsp/candidate/edit-skill.jsp"%>
    				</div>
    			</div>
  			</fieldset>
		</form:form>
	</div>
</div>

<div class="modal fade" id="nth-cancel-modal" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Cancel operation confirm</h4>
    	</div>
      	<div class="modal-body">
        	<p>Are you sure want to cancel the edit candidate operation?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/candidate/view/${candidateModel.id}">Yes</a>
  		</div>
  		</div>
	</div>
</div>