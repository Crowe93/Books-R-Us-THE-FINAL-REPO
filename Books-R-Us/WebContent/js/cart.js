/**
 * 
 */
$(document).ready(function () {
	
	var userId = getCookie("userId");
	
	loadCart(userId);
	
	function loadCart(userId) {
		var requestURL = "Servlet?viewCart&userId=" + userId;
		$.get(requestURL, function (result, response) {
			$("#cart-container").html(""); //clear out cart element
			if (result) {
				//iterate over each book and populate html
				$.each(result, function (index, item) {
					var html = getItemHTML(item.book.title, item.book.author, item.book.price, item.book.imgurl, item.qty);
					$("#cart-container").append(html);
				});
				
				updateTotal();
			}
			//failed to load cart
			else {
				
			}
		}); //end get
	}
	
	function getItemHTML(title, author, price, img, qty) {
		var html = '<tr>' +
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
				'<input type="number" class="form-control text-center qty-select" value="' + qty + '">' +
			'</td>' +
			'<td data-th="Subtotal" class="text-center sub-total" subtotal=' + getSubtotal(price, qty) + '>$' + getSubtotal(price, qty) + '</td>' +
			'<td class="actions" data-th="">' +
				'<button class="btn btn-default btn-sm btn-refresh-item"><i class="fa fa-refresh"></i></button>' +
				'<button class="btn btn-danger btn-sm btn-delete-item"><i class="fa fa-trash-o"></i></button>' +								
			'</td>' +
		'</tr>';
		return html;
	}
	
	function getSubtotal(price, qty) {
		return price * qty;
	}
	
	function updateTotal(){
		var total = 0;
		$.each($(".sub-total"), function () {
			total += parseFloat($(this).attr("subtotal"));
		});
		$("#cart-sub-total").html("$" + total);
		var actualTotal = total + parseFloat($("#shipping-amt").attr("shipping-amt"));
		$("#final-total").html("$" + actualTotal.toFixed(2));
	}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
	
});





