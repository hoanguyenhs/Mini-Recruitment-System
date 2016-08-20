<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-warning">	
	<div class="panel-heading">
		<h3 class="panel-title">
			<b><a href="${pageContext.request.contextPath}/">Home</a> / 
			<a href="${pageContext.request.contextPath}/vacancy/search">Search Vacancy</a> / 
			<a href="${pageContext.request.contextPath}/vacancy/view/${vacancyModel.id }">View Vacancy Detail</a> / 
			Hire Phase</b>
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

<div class="panel panel-info">	
	<div class="panel-heading">
		<h3 class="panel-title">
		 	Have ${candidateModelListLength } candidates in this phase
		</h3> 
	</div>
</div>

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


