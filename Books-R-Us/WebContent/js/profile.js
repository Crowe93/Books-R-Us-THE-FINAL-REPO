/**
 * 
 */
$(document).ready(function (){
	initPage();
	var userId = getCookie("userId");
	loadProfile(userId);
	
	if (!userId)
		{
			$(location).attr('href','../login.html');
		}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}

	function loadProfile(userId) {
		//make ajax call to servlet
		var requestURL = "Servlet?userInfo&userId=" + userId;
		$.get(requestURL, function (result, status) {
			if (status) {
				//populate profile page with result data
				$("#fname-welcome").text(result.fname);
				$("#fname").text(result.fname);
				$("#lname").text(result.lname);
				$("#username").text(result.username);
				$("#email").text(result.email);
			}
			else {
				//failed to load user
				alert("Error loading user info");
			}
		});
	}
	
	function initPage() {
		$("#login-btn").hide();
	}
});

