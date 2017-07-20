/**
 * 
 */
$(document).ready(function () {
	var userId = $("#userId").value();
	
	$("#loginSubmit").click(function () {
		var username = $("#username").value();
		var password = $("#password").value();
		var requestURL = "Sevlet?loginAuth&username=" + username + "&password=" + password;
		$.get(requestURL, function (result, status) {
			if (status) {
				var userId = result.id;
				alert(userId);
			}
			else {
				alert("Login Auth failed");
			}
		});
	});
});