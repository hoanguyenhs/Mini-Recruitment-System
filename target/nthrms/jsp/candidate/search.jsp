<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			Search Candidate</b>
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
		        	Search
		        </button>
   			</div>
  			<fieldset>
    			<legend>Search candidate</legend>
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
      				<label class="col-lg-2 control-label nth-label">After create date</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="createDate" class="form-control nth-input datetimepicker startdate" placeholder="After create date"></form:input>
      					</div>
      				</div>
      				<label class="col-lg-2 control-label nth-label">Before last update</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="lastUpdate" class="form-control nth-input datetimepicker enddate" placeholder="Before last update"></form:input>
      					</div>
      				</div>  
      			</div>
     			<div class="form-group">
     				<label class="col-lg-2 control-label nth-label">Status</label>
    				<div class="col-lg-4">
    					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-eye-open"></span></span>
    						<form:select path="status" class="form-control nth-select selectpicker">
	        					<form:option value="Choose a status">Choose a status</form:option>
	        					<form:option value="Waiting">Waiting</form:option>
	        					<form:option value="Actived">Actived</form:option>
	        				</form:select>
    					</div>
    				</div>    				
      			</div>
  			</fieldset>
		</form:form>
	</div>
</div>

<c:if test="${candidateModelList != null }">
	<div class="panel panel-info">	
		<div class="panel-heading">
			<h3 class="panel-title">
			 	Found ${candidateModelListLength } candidates
			</h3> 
		</div>
	</div>
</c:if>

<c:forEach var="candidateModel" items="${candidateModelList }">
	<div class="panel panel-success">	
		<div class="panel-heading">
			<h3 class="panel-title">
			 	Candidate ID: ${candidateModel.id }
			</h3> 
		</div>
		<div class="panel-body">
			<div class="nth-button-group">
				<a class="btn btn-info nth-button-status" href="${pageContext.request.contextPath}/candidate/view/${candidateModel.id }">
					<span class="glyphicon glyphicon-folder-open"></span>
					View detail
				</a>
			</div>
			<fieldset>
				<legend>Email: ${candidateModel.email }</legend>
	    		<label class="col-lg-2 control-label nth-label"><b>First name:</b></label>
	      		<div class="col-lg-4">
	        		<label class="control-label nth-label">${candidateModel.firstName }</label>
	      		</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Status:</b></label>
	  			<div class="col-lg-4">
	  				<label class="control-label nth-label">${candidateModel.status }</label>
	  			</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Last name:</b></label>
	      		<div class="col-lg-4">
	        		<label class="control-label nth-label">${candidateModel.lastName }</label>
	      		</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Create date:</b></label>
	  			<div class="col-lg-4">
	  				<label class="control-label nth-label">${candidateModel.createDate }</label>
	  			</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Phone:</b></label>
	      		<div class="col-lg-4">
					<label class="control-label nth-label">${candidateModel.phone }</label>
	      		</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Last update:</b></label>
	  			<div class="col-lg-4">
	  				<label class="control-label nth-label">${candidateModel.lastUpdate }</label>
	  			</div>
				<label class="col-lg-2 control-label nth-label"><b>Address:</b></label>
	  			<div class="col-lg-10">
	  				<label class="control-label nth-label">${candidateModel.address }</label>
	  			</div>
	  			<label class="col-lg-2 control-label nth-label"><b>Link:</b></label>
	  			<div class="col-lg-10">
	  				<label class="control-label nth-label">${candidateModel.link }</label>
	  			</div>
    		</fieldset>
		</div>	
	</div>
</c:forEach>

<div class="modal fade" id="nth-cancel-modal" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Cancel operation confirm</h4>
    	</div>
      	<div class="modal-body">
        	<p>Are you sure want to cancel the search candidate operation?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/">Yes</a>
  		</div>
  		</div>
	</div>
</div>

<div class="modal fade" id="nth-delete-candidate" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Delete success</h4>
    	</div>
      	<div class="modal-body">
        	<p id="nth-delete-candidate-body-p">${message }</p>
      	</div>
		<div class="modal-footer">
    		<button class="btn btn-success nth-button" data-dismiss="modal">OK</button>
  		</div>
  		</div>
	</div>
</div>