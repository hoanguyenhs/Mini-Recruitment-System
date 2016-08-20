$(document).ready(function() {

	if (!$("#nth-congratulation-modal-body-p").text() == "") {
		$("#nth-congratulation-modal").modal("show");
	}

	$("#nth-congratulation-modal").on('hidden.bs.modal', function() {
		window.location.href = "../";
	});

	if (!$("#nth-delete-position-body-p").text() == "") {
		$("#nth-delete-position").modal("show");
	}

	$("#nth-delete-position").on('hidden.bs.modal', function() {
		window.location = "../search";
	});

	if (!$("#nth-delete-candidate-body-p").text() == "") {
		$("#nth-delete-candidate").modal("show");
	}

	$("#nth-delete-candidate").on('hidden.bs.modal', function() {
		window.location = "../search";
	});

	if (!$("#nth-warning-body-p").text() == "") {
		$("#nth-warning").modal("show");
	}

	$(".selectpicker").selectpicker();

	$('.datetimepicker').datetimepicker({
		format : 'YYYY-MM-DD',
		pickTime : false,
		autoClose : true,
	});

	$(".startdate").on("dp.change", function(e) {
		$('.enddate').data("DateTimePicker").setMinDate(e.date);
	});
	$(".enddate").on("dp.change", function(e) {
		$('.startdate').data("DateTimePicker").setMaxDate(e.date);
	});

});