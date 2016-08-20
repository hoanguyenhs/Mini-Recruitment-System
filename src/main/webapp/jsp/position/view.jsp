<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			<a href="${pageContext.request.contextPath}/position/search">Search Position</a> / 
			View Position Detail</b>
		</h3>
	</div>
	<div class="panel-body">
		<div class="nth-button-group">
			<a class="btn btn-info nth-button-status" href="${pageContext.request.contextPath}/position/status/${positionModel.id }">
				<span class="glyphicon glyphicon-repeat"></span>
				Status: ${positionModel.status }
			</a>
			<a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/position/clone/${positionModel.id }">
				<span class="glyphicon glyphicon-share"></span>
				Clone
			</a>
			<a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/position/edit/${positionModel.id }">
				<span class="glyphicon glyphicon-pencil"></span>
				Edit
			</a>
			<a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/position/export/${positionModel.id }">
				<span class="glyphicon glyphicon-file"></span>
				Export
			</a>
			<a class="btn btn-info nth-button" data-toggle="modal" data-target="#nth-confirm-modal">
				<span class="glyphicon glyphicon-remove"></span>
				Delete
			</a>
		</div>
  			<fieldset>
    			<legend>View position detail</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>ID:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${positionModel.id }</label>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Name:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${positionModel.name }</label>
      				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Year of Experience:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${positionModel.yearOfExperience }</label>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Division:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${positionModel.division }</label>
      				</div>
      			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Status:</b></label>
      				<div class="col-lg-10">
						<label class="col-lg-10 control-label nth-label">${positionModel.status }</label>
      				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Description:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${positionModel.description }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Create date:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${positionModel.createDate }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Last update:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${positionModel.lastUpdate }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Skill:</b></label>
    				<div class="col-lg-10">
	    				<%@include file="/jsp/position/view-skill.jsp"%>
    				</div>
    			</div>
  			</fieldset>
	</div>
</div>

<div class="modal fade" id="nth-confirm-modal" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Confirm dialog</h4>
    	</div>
      	<div class="modal-body">
        	<p>Are you sure to delete this position?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/position/delete/${positionModel.id }">Yes</a>
  		</div>
  		</div>
	</div>
</div>