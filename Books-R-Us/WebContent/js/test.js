$(document).ready(function (){
	$('#testAjax').click(function () {
		//alert("testing ajax");
		$.get("Servlet?test", function(result, status) {
			if (status)
				$("p").html(result.data);
			else
				$("p").html("There was an error processing the AJAX request");
		});
	});

});
