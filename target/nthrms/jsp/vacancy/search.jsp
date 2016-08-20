<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			Search Vacancy</b>
		</h3> 
	</div>
	<div class="panel-body">
		<form:form class="form-horizontal" commandName="vacancyModel" medthod="post">
			<div class="nth-button-group">
		        <button type="reset" class="btn btn-info nth-button" 
		        	data-toggle="modal" data-target="#nth-cancel-modal">
		        	<span class="glyphicon glyphicon-floppy-remove"></span>
		        	Cancel
	        	</button>
		        <button type="submit" class="btn btn-success nth-button">
		        	<span class="glyphicon glyphicon-floppy-saved"></span>
		        	Search
		        </button>
   			</div>
  			<fieldset>
    			<legend>Search vacancy</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Name</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-tag"></span></span>
        					<form:input path="name" class="form-control nth-input" placeholder="Vacancy name" type="text"></form:input>
       					</div>
      				</div>
      			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Position Name</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-tasks"></span></span>
	        				<form:select path="positionName" class="form-control nth-select selectpicker">
	        					<form:option value="Choose a position">Choose a position</form:option>
	        					<c:forEach var="positionModel" items="${positionModelList }">
	        						<form:option value="${positionModel.name }">${positionModel.name }</form:option>
	        					</c:forEach>
	        				</form:select>
        				</div>
      				</div>
      			</div>
     			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Status</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-tasks"></span></span>
	        				<form:select path="status" class="form-control nth-select selectpicker">
	        					<form:option value="Choose a status">Choose a status</form:option>
	        					<form:option value="Waiting">Waiting</form:option>
	        					<form:option value="Actived">Actived</form:option>
	        				</form:select>
        				</div>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Start date</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="startDate" class="form-control nth-input datetimepicker" type="text"></form:input>
       					</div>
      				</div>
      				<label class="col-lg-2 control-label nth-label">End date</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="endDate" class="form-control nth-input datetimepicker" type="text"></form:input>
       					</div>
      				</div>
      			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">After create date</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="createDate" class="form-control nth-input datetimepicker" type="text"></form:input>
       					</div>
      				</div>
      				<label class="col-lg-2 control-label nth-label">Before last update</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="lastUpdate" class="form-control nth-input datetimepicker" type="text"></form:input>
       					</div>
      				</div>
      			</div>
  			</fieldset>
		</form:form>
	</div>
</div>

<c:if test="${vacancyModelList != null }">
	<div class="panel panel-info">	
		<div class="panel-heading">
			<h3 class="panel-title">
			 	Found ${vacancyModelListLength } vacancies
			</h3> 
		</div>
	</div>
</c:if>

<c:forEach var="vacancyModel" items="${vacancyModelList }">
	<div class="panel panel-success">	
		<div class="panel-heading">
			<h3 class="panel-title">
			 	Vacancy ID: ${vacancyModel.id }
			</h3> 
		</div>
		<div class="panel-body">
			<div class="nth-button-group">
				<a class="btn btn-info nth-button-status" href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id }">
					<span class="glyphicon glyphicon-folder-open"></span>
					View detail
				</a>
			</div>
			<fieldset>
				<legend>Name: ${vacancyModel.name }</legend>
	    		<label class="col-lg-2 control-label nth-label"><b>Amount:</b></label>
	      		<div class="col-lg-10">
	        		<label class="control-label nth-label">${vacancyModel.amount }</label>
	      		</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Position:</b></label>
	      		<div class="col-lg-4">
	        		<label class="control-label nth-label">${vacancyModel.positionName }</label>
	      		</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Status:</b></label>
	      		<div class="col-lg-4">
					<label class="control-label nth-label">${vacancyModel.status }</label>
	      		</div>
	      		<label class="col-lg-2 control-label nth-label"><b>Start date:</b></label>
	  			<div class="col-lg-4">
	  				<label class="control-label nth-label">${vacancyModel.startDate }</label>
	  			</div>
	  			<label class="col-lg-2 control-label nth-label"><b>End update:</b></label>
	    		<div class="col-lg-4">
	    			<label class="control-label nth-label">${vacancyModel.endDate }</label>
	    		</div>
				<label class="col-lg-2 control-label nth-label"><b>Create date:</b></label>
	  			<div class="col-lg-4">
	  				<label class="control-label nth-label">${vacancyModel.createDate }</label>
	  			</div>
	  			<label class="col-lg-2 control-label nth-label"><b>Last update:</b></label>
	    		<div class="col-lg-4">
	    			<label class="control-label nth-label">${vacancyModel.lastUpdate }</label>
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
        	<p>Are you sure want to search the search vacancy operation?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/">Yes</a>
  		</div>
  		</div>
	</div>
</div>

<div class="modal fade" id="nth-delete-position" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Delete success</h4>
    	</div>
      	<div class="modal-body">
        	<p id="nth-delete-position-body-p">${message }</p>
      	</div>
		<div class="modal-footer">
    		<button class="btn btn-success nth-button" data-dismiss="modal">OK</button>
  		</div>
  		</div>
	</div>
</div>