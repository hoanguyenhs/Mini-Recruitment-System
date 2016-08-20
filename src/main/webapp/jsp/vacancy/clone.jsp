<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			<a href="${pageContext.request.contextPath}/vacancy/search">Search Vacancy</a> / 
			<a href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id}">View Vacancy Detail</a> / 
			Clone Vacancy</b>
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
		        	Submit
		        </button>
   			</div>
  			<fieldset>
    			<legend>Clone vacancy</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Name</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-tag"></span></span>
        					<form:input path="name" class="form-control nth-input" placeholder="Vacancy name" type="text"></form:input>
       					</div>
       					<form:errors path="name" cssClass="label-danger nth-error"></form:errors>
      				</div>
      				<label class="col-lg-2 control-label nth-label">Amount</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-th"></span></span>
        					<form:input path="amount" class="form-control nth-input" placeholder="Amount" type="number" required="${true }"></form:input>
      					</div>
      					<form:errors path="amount" cssClass="label-danger nth-error"></form:errors>
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
        				<form:errors path="positionNameValidated" cssClass="label-danger nth-error"></form:errors>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label">Start date</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="startDate" class="form-control nth-input datetimepicker startdate" type="text" required="${true }"></form:input>
       					</div>
      				</div>
      				<label class="col-lg-2 control-label nth-label">End date</label>
      				<div class="col-lg-4">
      					<div class="input-group">
      						<span class="input-group-addon nth-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        					<form:input path="endDate" class="form-control nth-input datetimepicker enddate" type="text" required="${true }"></form:input>
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
        	<p>Are you sure want to cancel the clone vacancy operation?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id}">Yes</a>
  		</div>
  		</div>
	</div>
</div>