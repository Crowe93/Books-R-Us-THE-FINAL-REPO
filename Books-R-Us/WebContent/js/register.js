/**
 * 
 */
$(document).ready(function () {
	$("#btn-register").click(function (event) {
		var fname = $("#fname").val();
		var lname = $("#lname").val();
		var username = $("#username").val();
		var email = $("#email").val();
		var password = $("#password").val();
		var passwordConfirm = $("#password-confirm").val();
		
		if (!fname || !lname || !username || !email || !password || !passwordConfirm) {
			event.preventDefault();
			error("All fields must be filled out before registering");
		}
		else if (password !== passwordConfirm) {
			//passwords do not match
			event.preventDefault();
			error("Password confirmation does not match desired password.");
			return;
		}
		

		
		
	});
	
	function error (msg) {
		$("#error-field").html("<strong> ERROR: </strong>" + msg);
		$("#error-field").stop();
		$("#error-field").fadeIn(0);
		$("#error-field").fadeOut(5000);
	}
});