<script>
	var index2 = 0;
	divExperience = ''
		+'<div class="nth-experience">'
			+'<div class="form-group">'
				+'<label class="col-lg-2 control-label nth-label">Company</label>'
				+'<input name="experienceCompany" class="col-lg-4 form-control nth-input" placeholder="Company" type="text"></input>'
				+'<label class="col-lg-2 control-label nth-label">Start Date</label>'
				+'<input name="experienceStarDate" class="col-lg-4 form-control nth-input datetimepicker startdate" placeholder="Star Date" type="text"></input>'
			+'</div>'
			+'<div class="form-group">'
				+'<label class="col-lg-2 control-label nth-label">Position</label>'
				+'<input name="experiencePosition" class="col-lg-4 form-control nth-input" placeholder="Position" type="text"></input>'
				+'<label class="col-lg-2 control-label nth-label">End Date</label>'
				+'<input name="experienceEndDate" class="col-lg-4 form-control nth-input datetimepicker enddate" placeholder="End Date" type="text"></input>'
			+'</div>'
			+'<div class="form-group" style="margin-bottom: 0px;">'
				+'<label class="col-lg-2 control-label nth-label">Salary</label>'
				+'<input name="experienceSalary" class="col-lg-4 form-control nth-input" placeholder="Salary" type="text"></input>'
				+'<div class="col-lg-5">'
					+'<span style="margin-right: 50px;"></span>'
					+'<button type="button" class="btn btn-success nth-button-add1">+</button>'
					+'<button type="button" class="btn btn-danger nth-button-remove1">-</button>'
				+'</div>'
			+'</div>'
		+'</div>';
		
	$(document).on('click', '.nth-button-add1', function(){
		$(".nth-experience-container").append(divExperience);
		index2++;
		$('.datetimepicker').datetimepicker({
			format : 'YYYY-MM-DD',
			pickTime : false,
			autoClose : true,
		});
	});

	$(document).on('click', '.nth-button-remove1', function(){
		if(index2 > 0){
			var parent = $(this).parent().parent().parent();
			parent.remove();
			index2--;
		}
	});

</script>

<div class="nth-experience-container">
	<div class="nth-experience">
		<div class="form-group">
			<label class="col-lg-2 control-label nth-label">Company</label>
			<input name="experienceCompany" class="col-lg-4 form-control nth-input" placeholder="Company" type="text"></input>
			<label class="col-lg-2 control-label nth-label">Start Date</label>
			<input name="experienceStarDate" class="col-lg-4 form-control nth-input datetimepicker startdate" placeholder="Star Date" type="text"></input>
		</div>
		<div class="form-group">
			<label class="col-lg-2 control-label nth-label">Position</label>
			<input name="experiencePosition" class="col-lg-4 form-control nth-input" placeholder="Position" type="text"></input>
			<label class="col-lg-2 control-label nth-label">End Date</label>
			<input name="experienceEndDate" class="col-lg-4 form-control nth-input datetimepicker enddate" placeholder="End Date" type="text"></input>
		</div>
		<div class="form-group" style="margin-bottom: 0px;">
			<label class="col-lg-2 control-label nth-label">Salary</label>
			<input name="experienceSalary" class="col-lg-4 form-control nth-input" placeholder="Salary" type="text"></input>
			<div class="col-lg-5">
				<span style="margin-right: 50px;"></span>
				<button type="button" class="btn btn-success nth-button-add1">+</button>
				<button type="button" class="btn btn-danger nth-button-remove1">-</button>
			</div>
		</div>
	</div>
</div>