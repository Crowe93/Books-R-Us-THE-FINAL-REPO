/**
 * 
 */
$(document).ready(function () {
	
	var userId = getCookie("userId");
	
	loadProfileInfo(userId);
	
	$("#btn-confirm").click(function () {
		confirmOrder(userId);
	});
	
	function confirmOrder(userId) {
		
		var requestURL = "Servlet?confirmOrder&userId=" + userId;
		$.get(requestURL, function (result, status) {
			//console.log(result);
			if (result.status == 1) {
				alert(result.msg);
			}
			else
				alert("Error: " + result.msg);
		});
		
	}
	
	function loadCart(userId) {
		var requestURL = "Servlet?viewCart&userId=" + userId;
		$.get(requestURL, function (result, response) {
			$("#cart-container").html(""); //clear out cart element
			if (result) {
				//iterate over each book and populate html
				$.each(result, function (index, item) {
					var html = getCartHTML(item.book.ISBN, item.book.title, item.book.author, item.book.price, item.book.imgurl, item.qty);
					$("#cart-container").append(html);
				});
				
				//updateTotal();
			}
			//failed to load cart
			else {
				
			}
		}); //end get
	}
	
	function loadProfileInfo(userId) {
		//make ajax call to servlet
		var requestURL = "Servlet?userInfo&userId=" + userId;
		$.get(requestURL, function (result, status) {
			if (status) {
				//populate profile page with result data
				
				//console.log(result);
				
				//BASIC DATA
				$("#full-name").val(result.fname + " " + result.lname);
				
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
				
				//now that loadProfile is done, load the cart (to prevent ResultSet errors)
				loadCart(userId);
			}
			else {
				//failed to load user
				alert("Error loading user info");
			}
		});
	}
	
	function getCartHTML(id, title, author, price, img, qty) {
		var html = 	'<tr>' +
		'<td data-th="Product">' +
		'<div class="row">' +
			'<div class="col-sm-4 hidden-xs"><img style="width:100px; height: auto;" src="' + img + '" class="img-responsive"/></div>' +
			'<div class="col-sm-8">' +
				'<h5 class="nomargin">' + title + '</h5>' +
				'<p class="text-left">Novel by ' + author + '</p>' +
			'</div>' +
		'</div>' +
	'</td>' +
	'<td data-th="Price">$' + price + '</td>' +
	'<td data-th="Quantity">' +
		'<input type="number" class="form-control text-center" value="' + qty + '" readonly>' +
	'</td>' +
	'<td data-th="Subtotal" class="text-center">$' + (qty * price).toFixed(2) + '</td>' +
    '</tr>';
		return html;
	}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
});