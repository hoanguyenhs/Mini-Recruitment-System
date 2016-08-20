<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			<a href="${pageContext.request.contextPath}/vacancy/search">Search Vacancy</a> / 
			View Vacancy Detail</b>
		</h3>
	</div>
	<div class="panel-body">
		<div class="nth-button-group">
			<a class="btn btn-info nth-button-status" href="${pageContext.request.contextPath}/vacancy/active/${vacancyModel.id }">
				<span class="glyphicon glyphicon-briefcase"></span>
				Active vacancy
			</a>
<%-- 			<a class="btn btn-info nth-button-status" href="${pageContext.request.contextPath}/vacancy/active/${vacancyModel.id }"> --%>
<!-- 				<span class="glyphicon glyphicon-briefcase"></span> -->
<!-- 				Close vacancy -->
<!-- 			</a> -->
			<a class="btn btn-info nth-button-status" href="${pageContext.request.contextPath}/position/view/${vacancyModel.positionId }">
				<span class="glyphicon glyphicon-tasks"></span>
				View position
			</a>
			<div class="btn-group">
				<button type="button" class="btn btn-info dropdown-toggle nth-button" data-toggle="dropdown">
    				Export<span class="caret"></span>
 				</button>
				<ul class="dropdown-menu">
					<li><a class="btn btn-info nth-button-a" href="${pageContext.request.contextPath}/vacancy/export1/${vacancyModel.id }">
						<span class="glyphicon glyphicon-file"></span>
						Export detail
					</a></li>
					<li><a class="btn btn-info nth-button-a" href="${pageContext.request.contextPath}/vacancy/export2/${vacancyModel.id }">
						<span class="glyphicon glyphicon-file"></span>
						Export pie/chart
					</a></li>
				</ul>
			</div>
			
			<div class="btn-group">
				<button type="button" class="btn btn-info dropdown-toggle nth-button" data-toggle="dropdown">
    				Option <span class="caret"></span>
 				</button>
 				<ul class="dropdown-menu nth-dropdown-menu">
 					<li><a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/vacancy/clone/${vacancyModel.id }">
						<span class="glyphicon glyphicon-share"></span>
						Clone
					</a></li>
					<li><a class="btn btn-info nth-button" href="${pageContext.request.contextPath}/vacancy/edit/${vacancyModel.id }">
						<span class="glyphicon glyphicon-pencil"></span>
						Edit
					</a></li>
					<li><a class="btn btn-info nth-button" data-toggle="modal" data-target="#nth-confirm-modal">
						<span class="glyphicon glyphicon-remove"></span>
						Delete
					</a></li>
 				</ul>
			</div>
		</div>
  			<fieldset>
    			<legend>View vacancy detail</legend>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>ID:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${vacancyModel.id }</label>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Name:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${vacancyModel.name }</label>
      				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Amount:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${vacancyModel.amount }</label>
      				</div>
    			</div>
    			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Position:</b></label>
      				<div class="col-lg-10">
        				<label class="col-lg-10 control-label nth-label">${vacancyModel.positionName }</label>
      				</div>
      			</div>
      			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Start date:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${vacancyModel.startDate }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>End date:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${vacancyModel.endDate }</label>
    				</div>
    			</div>
      			<div class="form-group">
      				<label class="col-lg-2 control-label nth-label"><b>Status:</b></label>
      				<div class="col-lg-10">
						<label class="col-lg-10 control-label nth-label">${vacancyModel.status }</label>
      				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Description:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${vacancyModel.description }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Create date:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${vacancyModel.createDate }</label>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-lg-2 control-label nth-label"><b>Last update:</b></label>
    				<div class="col-lg-10">
    					<label class="col-lg-10 control-label nth-label">${vacancyModel.lastUpdate }</label>
    				</div>
    			</div>
  			</fieldset>
	</div>
</div>

<div class="panel panel-success">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b>Vacancy progress detail</b>
		</h3>
	</div>
	<div class="panel-body">
  		<table class="nth-table-progress">
  			<tr>
  				<td rowspan=2 style="width: 50px;"></td>
  				<td class="nth-td"><b>
 					<a class="nth-td-a" href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id }/review" >
  						Review
  					</a>
 				</b></td>
  				<td class="nth-td"><b>
  					<a class="nth-td-a" href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id }/entrancetest" >
  						Entrance test
  					</a>
 				</b></td>
  				<td class="nth-td"><b>
  					<a class="nth-td-a" href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id }/interview" >
  						Interview
  					</a>
 				</b></td>
  				<td class="nth-td"><b>
  					<a class="nth-td-a" href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id }/offer" >
  						Offer
  					</a>
  				</b></td>
  				<td class="nth-td"><b>
  					<a class="nth-td-a" href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id }/hire" >
  						Hire
  					</a>
  				</b></td>
  				<td rowspan=2 style="width: 50px;"></td>
  			</tr>
	  		<tr>
	  			<c:forEach var="phase" items="${phaseList }">
	  				<td class="nth-td">
	  					<table class="nth-table-progress-sub">
	  						<tr>
	  							<td rowspan=3 class="nth-td1">W: ${phase.waiting }</td>
	  							<td class="nth-td2">T: ${phase.total }</td>
	  						</tr>
	  						<tr><td class="nth-td3">P: ${phase.pass }</td></tr>
	  						<tr><td class="nth-td4">R: ${phase.reject }</td></tr>
	  					</table>
	  				</td>
	  			</c:forEach>
	  		</tr>
  		</table>
  		<div class="nth-note">[W]aiting - [T]otal - [P]ass - [R]eject</div>
	</div>
</div>

<div class="modal fade" id="nth-confirm-modal" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Confirm dialog</h4>
    	</div>
      	<div class="modal-body">
        	<p>Are you sure to delete this vacancy?</p>
      	</div>
		<div class="modal-footer">
    		<button type="button" class="btn btn-danger nth-button" data-dismiss="modal">No</button>
    		<a class="btn btn-success nth-button" href="${pageContext.request.contextPath}/vacancy/delete/${vacancyModel.id }">Yes</a>
  		</div>
  		</div>
	</div>
</div>

<div class="modal fade" id="nth-warning" tabindex="-1">
  	<div class="modal-dialog">
  		<div class="modal-content">
  		<div class="modal-header">
	        <h4 class="modal-title">Warning message</h4>
    	</div>
      	<div class="modal-body">
        	<p id="nth-warning-body-p">${message }</p>
      	</div>
		<div class="modal-footer">
    		<button class="btn btn-success nth-button" data-dismiss="modal">OK</button>
  		</div>
  		</div>
	</div>
</div>