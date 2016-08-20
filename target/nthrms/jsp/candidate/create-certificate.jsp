<script>
	var index1 = 0;
	divCertificate = ''
		+'<div class="nth-certificate">'
			+'<div class="form-group">'
				+'<label class="col-lg-2 control-label nth-label">Name</label>'
				+'<input name="certificateName" class="col-lg-4 form-control nth-input" placeholder="Name" type="text"></input>'
				+'<label class="col-lg-2 control-label nth-label">Start Date</label>'
				+'<input name="certificateStarDate" class="col-lg-4 form-control nth-input datetimepicker startdate" placeholder="Star Date" type="text"></input>'
			+'</div>'
			+'<div class="form-group">'
				+'<label class="col-lg-2 control-label nth-label">School</label>'
				+'<input name="certificateSchool" class="col-lg-4 form-control nth-input" placeholder="School" type="text"></input>'
				+'<label class="col-lg-2 control-label nth-label">End Date</label>'
				+'<input name="certificateEndDate" class="col-lg-4 form-control nth-input datetimepicker enddate" placeholder="End Date" type="text"></input>'
			+'</div>'
			+'<div class="form-group" style="margin-bottom: 0px;">'
				+'<label class="col-lg-2 control-label nth-label">Score</label>'
				+'<input name="certificateScore" class="col-lg-4 form-control nth-input" placeholder="Score" type="text"></input>'
				+'<div class="col-lg-5">'
					+'<span style="margin-right: 50px;"></span>'
					+'<button type="button" class="btn btn-success nth-button-add">+</button>'
					+'<button type="button" class="btn btn-danger nth-button-remove">-</button>'
				+'</div>'
			+'</div>'
		+'</div>';
		
	$(document).on('click', '.nth-button-add', function(){
		$(".nth-certificate-container").append(divCertificate);
		index1++;
		$('.datetimepicker').datetimepicker({
			format : 'YYYY-MM-DD',
			pickTime : false,
			autoClose : true,
		});
	});

	$(document).on('click', '.nth-button-remove', function(){
		if(index1 > 0){
			var parent = $(this).parent().parent().parent();
			parent.remove();
			index1--;
		}
	});

</script>

<div class="nth-certificate-container">
	<div class="nth-certificate">
		<div class="form-group">
			<label class="col-lg-2 control-label nth-label">Name</label>
			<input name="certificateName" class="col-lg-4 form-control nth-input" placeholder="Name" type="text"></input>
			<label class="col-lg-2 control-label nth-label">Start Date</label>
			<input name="certificateStarDate" class="col-lg-4 form-control nth-input datetimepicker startdate" placeholder="Star Date" type="text"></input>
		</div>
		<div class="form-group">
			<label class="col-lg-2 control-label nth-label">School</label>
			<input name="certificateSchool" class="col-lg-4 form-control nth-input" placeholder="School" type="text"></input>
			<label class="col-lg-2 control-label nth-label">End Date</label>
			<input name="certificateEndDate" class="col-lg-4 form-control nth-input datetimepicker enddate" placeholder="End Date" type="text"></input>
		</div>
		<div class="form-group" style="margin-bottom: 0px;">
			<label class="col-lg-2 control-label nth-label">Score</label>
			<input name="certificateScore" class="col-lg-4 form-control nth-input" placeholder="Score" type="text"></input>
			<div class="col-lg-5">
				<span style="margin-right: 50px;"></span>
				<button type="button" class="btn btn-success nth-button-add">+</button>
				<button type="button" class="btn btn-danger nth-button-remove">-</button>
			</div>
		</div>
	</div>
</div>