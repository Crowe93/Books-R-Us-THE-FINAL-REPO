/**
 * 
 */
$(document).ready(function () {
	
	var userId = getCookie("userId");
	
	if (!userId)
	{
		$(location).attr('href','../Books-R-Us/login.html');
	}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
});