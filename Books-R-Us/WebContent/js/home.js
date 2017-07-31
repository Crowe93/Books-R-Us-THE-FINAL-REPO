/**
 * 
 */
$(document).ready(function () {
	
	var userId = getCookie("userId");
	
	if (userId) { //logged in, display log-out
		$("#login-or-logout").attr("href", "Servlet?logout");
		$("#login-or-logout").html("Logout");
	} else { //not logged in, display log-in
		//do nothing
	}
	
	$(document).on("click", "#login-or-logout", function () {
		if (userId)
			deleteCookie("userId")
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