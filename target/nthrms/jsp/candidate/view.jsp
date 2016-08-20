<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			<a href="${pageContext.request.contextPath}/candidate/search">Search Candidate</a> / 
			View Candidate Detail</b>
		</h3>
	</div>
	<div class="panel-body">
		<div class="nth-button-group">
			<a class="btn btn-info nth-button-status" href="${pageContext.request.contextPath}/candidate/status/${candidateModel.id }">
				<span class="glyphicon glyphicon-repeat"></span>
				Status: ${candidateModel.status }
			</a>
			<a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/candidate/clone/${candidateModel.id }">
				<span class="glyphicon glyphicon-share"></span>
				Clone
			</a>
			<a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/candidate/edit/${candidateModel.id }">
				<span class="glyphicon glyphicon-pencil"></span>
				Edit
			</a>
			<a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/candidate/export/${candidateModel.id }">
				<span class="glyphicon glyphicon-file"></span>
				Export
			</a>
			<a class="btn btn-info nth-button" data-toggle="modal" data-target="#nth-confirm-modal">
				<span class="glyphicon glyphicon-remove"></span>
				Delete
			</a>
		</div>
  			<fieldset>
    			<legend>View candidate detail</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>ID:</b></label>
      				<div class="col-lg-4">
        				<label class="control-label nth-label">${candidateModel.id }</label>
      				</div>
      				<label class="col-lg-2 control-label nth-label"><b>Link:</b></label>
    				<div class="col-lg-4">
    					<label class="control-label nth-label">${candidateModel.link }</label>
    				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Fist name:</b></label>
      				<div class="col-lg-4">
        				<label class="control-label nth-label">${candidateModel.firstName }</label>
      				</div>
      				<label class="col-lg-2 control-label nth-label"><b>Status:</b></label>
    				<div class="col-lg-4">
    					<label class="control-label nth-label">${candidateModel.status }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Last name:</b></label>
      				<div class="col-lg-4">
        				<label class="control-label nth-label">${candidateModel.lastName }</label>
      				</div>
      				<label class="col-lg-2 control-label nth-label"><b>Create date:</b></label>
    				<div class="col-lg-4">
    					<label class="control-label nth-label">${candidateModel.createDate }</label>
    				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Phone:</b></label>
      				<div class="col-lg-4">
        				<label class="control-label nth-label">${candidateModel.phone }</label>
      				</div>
      				<label class="col-lg-2 control-label nth-label"><b>Last update:</b></label>
    				<div class="col-lg-4">
    					<label class="control-label nth-label">${candidateModel.lastUpdate }</label>
    				</div>
      			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Email:</b></label>
      				<div class="col-lg-4">
						<label class="control-label nth-label">${candidateModel.email }</label>
      				</div>
      				<label class="col-lg-2 control-label nth-label"><b>Description:</b></label>
    				<div class="col-lg-4">
    					<label class="control-label nth-label">${candidateModel.description }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Address:</b></label>
    				<div class="col-lg-10">
    					<label class="control-label nth-label">${candidateModel.address }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Certificate:</b></label>
    				<div class="col-lg-10">
    					<c:forEach var="certificateModel" items="${certificateModelList }">
    						<div class="nth-certificate" style="height: 90px;">
								<div class="form-group">
									<label class="col-lg-2 nth-label"><b><i>Name:</i></b></label>
									<label class="col-lg-4 nth-label">${certificateModel.name }</label>
									<label class="col-lg-2 nth-label"><b><i>Start Date:</i></b></label>
									<label class="col-lg-4 nth-label">${certificateModel.startDate }</label>
								</div>
								<div class="form-group">
									<label class="col-lg-2 nth-label"><b><i>School:</i></b></label>
									<label class="col-lg-4 nth-label">${certificateModel.school }</label>
									<label class="col-lg-2 nth-label"><b><i>End Date:</i></b></label>
									<label class="col-lg-4 nth-label">${certificateModel.endDate }</label>
								</div>
								<div class="form-group" style="margin-bottom: 0px;">
									<label class="col-lg-2 nth-label"><b><i>Score:</i></b></label>
									<label class="col-lg-4 nth-label">${certificateModel.score }</label>
								</div>
							</div>
    					</c:forEach>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Experience:</b></label>
    				<div class="col-lg-10">
						<c:forEach var="experienceModel" items="${experienceModelList }">
    						<div class="nth-experience" style="height: 90px;">
								<div class="form-group">
									<label class="col-lg-2 control-label nth-label"><b><i>Company:</i></b></label>
									<label class="col-lg-4 control-label nth-label">${experienceModel.company }</label>
									<label class="col-lg-2 control-label nth-label"><b><i>Start Date:</i></b></label>
									<label class="col-lg-4 control-label nth-label">${experienceModel.startDate }</label>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label nth-label"><b><i>Position:</i></b></label>
									<label class="col-lg-4 control-label nth-label">${experienceModel.position }</label>
									<label class="col-lg-2 control-label nth-label"><b><i>End Date:</i></b></label>
									<label class="col-lg-4 control-label nth-label">${experienceModel.endDate }</label>
								</div>
								<div class="form-group" style="margin-bottom: 0px;">
									<label class="col-lg-2 control-label nth-label"><b><i>Salary:</i></b></label>
									<label class="col-lg-4 control-label nth-label">${experienceModel.salary }</label>
								</div>
							</div>
    					</c:forEach>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Skill:</b></label>
    				<div class="col-lg-10">
	    				<%@include file="/jsp/candidate/view-skill.jsp"%>
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
        	<p>Are you sure to delete this candidate?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/candidate/delete/${candidateModel.id }">Yes</a>
  		</div>
  		</div>
	</div>
</div>