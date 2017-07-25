/**
 * 
 */
$(document).ready(function () {
	var userId = $("#userId").val();
	if (!userId)
		userId = getCookie("userId");
	
	$(document).on("click", "#btn-logout", function () {
		deleteCookie("userId");
	});
	
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
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
	
	
	function deleteCookie(name) {
		document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;path=/';
	}
});