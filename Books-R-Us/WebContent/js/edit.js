/**
 * 
 */
$(document).ready(function () {
	var userId = getCookie("userId");
	
	loadProfile(userId);
	
	$("#btn-submit").click(function () {
		editProfile(userId);
	});
	
	function loadProfile(userId) {
		//make ajax call to servlet
		var requestURL = "Servlet?userInfo&userId=" + userId;
		$.get(requestURL, function (result, status) {
			if (status) {
				//populate profile page with result data
				
				//console.log(result);
				
				//BASIC DATA
				$("#fname").val(result.fname);
				$("#fname-side").text(result.fname);
				$("#lname").val(result.lname);
				$("#lname-side").text(result.lname);
				$("#username").val(result.username);
				$("#email").val(result.email);
				
				//SHIPPING DATA
				$("#addr-address").val(result.shipping.street);
				$("#addr-city").val(result.shipping.city);
				$("#addr-state").val(result.shipping.state);
				$("#addr-zip").val(result.shipping.zip);
				
				if (result.payment){
					$("#card-type").val(result.payment.name);
					$("#card-number").val(result.payment.cardNum);
					$("#card-ccv").val(result.payment.csc);
					//card date/year later
				}
			}
			else {
				//failed to load user
				alert("Error loading user info");
			}
		});
	}
	
	function editProfile(userId) {
		//get all variables
		
		//BASIC INFO
		var fname = $("#fname").val();
		var lname = $("#lname").val();
		var username = $("#username").val();
		var email = $("#email").val();
		var oldpass = $("#password-old").val();
		var newpass = $("#password-new").val();
		
		//SHIPPING ADDR
		var address = $("#addr-address").val();
		var city = $("#addr-city").val();
		var state = $("#addr-state").val();
		var zip = $("#addr-zip").val();
		
		//CARD INFO
		var cardType = $("#card-type").val();
		var cardNum = $("#card-number").val();
		var cardCCV = $("#card-ccv").val();
		var expDate = $("#card-exp-day").val();
		var expYear = $("#card-exp-year").val();
		
		//build request URL (kill me)
		var requestURL = "Servlet?editProfile&userId=" + userId + "&fname=" + fname + "&lname=" + lname + "&username=" + username + "&email=" + email + "&oldpassword=" + oldpass + "&newpassword=" + newpass +
							"&address=" + address + "&city=" + city + "&state=" + state + "&zip=" + zip +
							"&cardType=" + cardType + "&cardNum=" + cardNum + "&cardccv=" + cardCCV + "&expDate=" + expDate + "&expYear=" + expYear;
		
		$.get(requestURL, function (status, result) {
			if (status) {
				
			}
			else {
				alert("something maybe happened");
			}
		});
	}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
});