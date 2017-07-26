/**
 * 
 */
$(document).ready(function (){
	initPage();
	
	var userId = getCookie("userId");
	loadProfile(userId);
	
	$("#btn-delete-account").click(function () {
		var requestURL = "Servlet?deleteAccount&userId=" + userId;
		$.get(requestURL, function (status, result) { 
			deleteCookie("userId");
			$(location).attr('href','../Books-R-Us/home.html')
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

	function loadProfile(userId) {
		//make ajax call to servlet
		var requestURL = "Servlet?userInfo&userId=" + userId;
		$.get(requestURL, function (result, status) {
			if (status) {
				console.log(result);
				//populate profile page with result data
				$("#fname-welcome").text(result.fname);
				$("#fname-side").text(result.fname);
				$("#fname").text(result.fname);
				$("#lname").text(result.lname);
				$("#lname-side").text(result.lname);
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

