<script>

	var skillList = [];
	var skillDomain = [];
	var skillTechnical = [];
	var skillLanguage = [];
	var index = [];

	$(document).ready(function(){
		
 		$.ajax({
	 		type: "GET",
	 		url: "${pageContext.request.contextPath}/skill/getAll",
	 		async: false,
	 		success: function(data) {
	 			$.each( data, function( key, val ) {
	 				skillList.push(val);
	 			});
	 		}
		});

		for(var i = skillList.length-1; i > -1; i--) {
 			if(skillList[i].type == "Domain"){
 				skillDomain.push(skillList[i]);
	 		}else if(skillList[i].type == "Technical"){
	 			skillTechnical.push(skillList[i]);
	 		}else{
	 			skillLanguage.push(skillList[i]);
	 		}
 		}

 		for(var i = 0; i < skillDomain.length; i++) {
 	 		$(".nth-skill-domain").after("<tr>"
 	 	 		+"<td>"+skillDomain[i].name
 	 	 			+"<input name='skillID' class='nth-hide' value='"+skillDomain[i].id+"'/>"
 	 	 			+"<input name='level' class='nth-hide' value='"+skillDomain[i].level+"'/>"
 	 	 		+"</td>"
 	 	 	 	+"<td><input type='radio' value='1' name='skillDomain["+i+"]' checked/></td>"
 	 	 	 	+"<td><input type='radio' value='2' name='skillDomain["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='3' name='skillDomain["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='4' name='skillDomain["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='5' name='skillDomain["+i+"]'/></td>"
 	 	 	 	+"</tr>");
	 	}

 		for(var i = 0; i < skillTechnical.length; i++) {
 	 		$(".nth-skill-technical").after("<tr>"
	 			+"<td>"+skillTechnical[i].name
 	 	 			+"<input name='skillID' class='nth-hide' value='"+skillTechnical[i].id+"'/>"
 	 	 			+"<input name='level' class='nth-hide' value='"+skillTechnical[i].level+"'/>"
 	 	 		+"</td>"
 	 	 	 	+"<td><input type='radio' value='1' name='skillTechnical["+i+"]' checked/></td>"
 	 	 	 	+"<td><input type='radio' value='2' name='skillTechnical["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='3' name='skillTechnical["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='4' name='skillTechnical["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='5' name='skillTechnical["+i+"]'/></td>"
 	 	 	 	+"</tr>");
	 	}

 		for(var i = 0; i < skillLanguage.length; i++) {
 	 		$(".nth-skill-language").after("<tr>"
 	 			+"<td>"+skillLanguage[i].name
 	 	 			+"<input name='skillID' class='nth-hide' value='"+skillLanguage[i].id+"'/>"
 	 	 			+"<input name='level' class='nth-hide' value='"+skillLanguage[i].level+"'/>"
 	 	 		+"</td>"
 	 	 	 	+"<td><input type='radio' value='1' name='skillLanguage["+i+"]' checked/></td>"
 	 	 	 	+"<td><input type='radio' value='2' name='skillLanguage["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='3' name='skillLanguage["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='4' name='skillLanguage["+i+"]'/></td>"
 	 	 		+"<td><input type='radio' value='5' name='skillLanguage["+i+"]'/></td>"
 	 	 	 	+"</tr>");
	 	}

	 	$("input[type='radio']").change(function(){
		 	var rowParent = $(this).parent().parent();
		 	rowParent.first().find("input[name='level']").val($(this).val());
	 	});
		
	});

</script>

<div id="nth-skill-container">
	<table class="nth-skill table table-striped table-hover">
		<tbody>
			<tr class="nth-skill-domain">
				<td style="width: 20%;"><b><i>Domain skills</i></b></td>
				<td style="width: 16%;">Very bad</td>
				<td style="width: 16%;">Bad</td>
				<td style="width: 16%;">Normal</td>
				<td style="width: 16%;">Good</td>
				<td style="width: 16%;">Very good</td>
			</tr>
			<tr class="nth-skill-technical">
				<td><b><i>Technical skills</i></b></td>
				<td>Limit knowledge</td>
				<td>Relative knowledge</td>
				<td>Can perform well with assistance</td>
				<td>Can perform well without assistance</td>
				<td>Expert knowledge and can lead a team</td>
			</tr>
			<tr class="nth-skill-language">
				<td><b><i>Language skills</i></b></td>
				<td>Beginner</td>
				<td>Elementary</td>
				<td>Intermediate</td>
				<td>Advance</td>
				<td>Expert</td>
			</tr>
		</tbody>
	</table>
</div>