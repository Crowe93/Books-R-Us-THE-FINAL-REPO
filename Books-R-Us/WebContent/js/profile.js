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
				//console.log(result);
				//populate profile page with result data
				$("#fname-welcome").text(result.fname);
				$("#fname-side").text(result.fname);
				$("#fname").text(result.fname);
				$("#lname").text(result.lname);
				$("#lname-side").text(result.lname);
				$("#username").text(result.username);
				$("#email").text(result.email);
				
				//SHIPPING DATA
				$("#addr-address").text(result.shipping.street);
				$("#addr-city").text(result.shipping.city);
				$("#addr-state").text(result.shipping.state);
				$("#addr-zip").text(result.shipping.zip);
				
				if (result.payment){
					$("#card-type").text(result.payment.name);
					$("#card-number").text(result.payment.cardNum);
					$("#card-ccv").text(result.payment.csc);

					var expDate = result.payment.expDate;
					var split = expDate.split("/");
					$("#card-exp-day").text(split[0]);
					$("#card-exp-year").text(split[1]);
				}
				
				loadOrders(userId);
			}
			else {
				//failed to load user
				alert("Error loading user info");
			}
		});
	}
	
	function loadOrders(userId) {
		var requestURL = "Servlet?loadOrders&userId=" + userId;
		$.get(requestURL, function (result) {
			$("#order-container").html("");
			$.each(result, function () {
				var html = getOrderHtml($(this));
				console.log($(this));
				$("#order-container").append(html);
			})
		});
	}
	
	function initPage() {
		$("#login-btn").hide();
	}
	
	function getOrderHtml(order) {
		var html = '<div class="order">' + 
			'<div class="row">' + 
				'<div class="col-md-6 date">' + 
 				'<a href="#collapseExample" data-toggle="collapse" aria-expanded="false" aria-controls="collapseExample">' + order[0].date +
						 
					'</a>' + 
				'</div>' + 
				'<div class="col-md-6 status">' + 
					'<p style="color:#e72621; font-weight:bold;">STATUS: SHIPPED<p>' + 
				'</div>' + 
			'</div>' + 
			'<table class="table table-hover">' + 
				
				'<thead>' + 
					'<tr>' + 
						'<th style="width:20%"></th>' + 
						'<th style="width:80%"></th>' + 
					'</tr>' + 
				'</thead>' + 
				
				'<tbody class="collapse" id="collapseExample">' + 
					'<tr>' + 
						'<td> ' + 
							'<img src="images/into-water.jpg" style="width:100px; height:auto;">' + 
						'</td>' + 
						'<td>' + 
							'<h3> Into the Water</h3>' + 
							'<p>By Paula Hawkins</p>' + 
							'<br>' + 
							'<p style="font-size:15px">1 x $14.50</p>' + 
						'</td>												' + 
					'</tr>' + 
					'<tr>' + 
						'<td> ' + 
							'<img src="images/into-water.jpg" style="width:100px; height:auto;">' + 
						'</td>' + 
						'<td>' + 
							'<h3> Into the Water</h3>' + 
							'<p>By Paula Hawkins</p>' + 
							'<br>' + 
							'<p style="font-size:15px">2 x $11.98</p>' + 
						'</td>												' + 
					'</tr>' + 
					'<tr> ' + 
						'<td></td>' + 
						'<td class="text-right order-footer">' + 
							'<h5>Order#: ' + order[0].orderNum + '</h5>' + 
							'<h5>Shipping: FREE</h5>' + 
							
							'<h5 style="font-weight:bold"> Total: $40.98</h5>' + 
						'</td>' + 
					'</tr>' + 
				
				'</tbody>' + 
			
			'</table>' + 
		'</div>';
		
		return html;
	}
});

