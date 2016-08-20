<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			<a href="${pageContext.request.contextPath}/position/search">Search Position</a> / 
			<a href="${pageContext.request.contextPath}/position/view/${positionModel.id}">View Position Detail</a> / 
			Edit Position</b>
		</h3> 
	</div>
	<div class="panel-body">
		<form:form class="form-horizontal" commandName="positionModel" medthod="post">
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
    			<legend>Edit position</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">ID</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-flag"></span></span>
        					<form:input path="id" class="form-control nth-input" type="text" readOnly="${true }"></form:input>
      					</div>
      				</div>
      			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Name</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-tag"></span></span>
        					<form:input path="name" class="form-control nth-input" placeholder="Position's name" type="text"></form:input>
       					</div>
       					<form:errors path="name" cssClass="label-danger nth-error"></form:errors>
      				</div>
      			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Year of Experience</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-signal"></span></span>
        					<form:input path="yearOfExperience" class="form-control nth-input" placeholder="Year of Experience" type="text"></form:input>
      					</div>
      					<form:errors path="yearOfExperience" cssClass="label-danger nth-error"></form:errors>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Division</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-th-list"></span></span>
	        				<form:select path="division" class="form-control nth-select selectpicker">
	        					<form:option value="Choose a division">Choose a division</form:option>
	        					<form:option value="Human Resource Division">Human Resources Division</form:option>
	        					<form:option value="Information Security Division">Information Security Division</form:option>
	        					<form:option value="Embed Application Division">Embed Application Division</form:option>
	        					<form:option value="Java Application Division">Java Application Division</form:option>
	        					<form:option value=".Net Application Division">.Net Application Division</form:option>
	        					<form:option value="PHP Application Division">PHP Application Division</form:option>
	        					<form:option value="Quality Control Division">Quality Control Division</form:option>
	        					<form:option value="Quality Assurance Division">Quality Assurance Division</form:option>
	        					<form:option value="Virtualize Deployment Division">Virtualization Deployment Division</form:option>
	        				</form:select>
        				</div>
      					<form:errors path="divisionValidated" cssClass="label-danger nth-error"></form:errors>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Create date</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="createDate" class="form-control nth-input" type="text" readOnly="${true }"></form:input>
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
    				<label class="col-lg-2 control-label nth-label">Skill</label>
    				<div class="col-lg-10">
	    				<%@include file="/jsp/position/edit-skill.jsp"%>
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
        	<p>Are you sure want to cancel the edit position operation?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/position/view/${positionModel.id}">Yes</a>
  		</div>
  		</div>
	</div>
</div>