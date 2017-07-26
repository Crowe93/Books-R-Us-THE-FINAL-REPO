/**
 * 
 */
$(document).ready(function () {
	
	var userId = getCookie("userId");
	
	loadCart(userId);
	
	$(document).on("change", ".qty-select", function () {
		var newQty = $(this).val();
		var subtotalElement = $(this).parent().parent().find(".sub-total");
		var priceElement = $(this).parent().parent().find(".price");
		var price = priceElement.attr("price");
		var newTotal = price * newQty;
		subtotalElement.attr("subtotal", newTotal.toFixed(2));
		updateTotal();
	})
	
	$(document).on("click", ".btn-delete-item", function () {
		var bookId = $(this).attr("bookId");
		removeFromCart(userId, bookId);
	});
	
	function loadCart(userId) {
		var requestURL = "Servlet?viewCart&userId=" + userId;
		$.get(requestURL, function (result, response) {
			$("#cart-container").html(""); //clear out cart element
			if (result) {
				//iterate over each book and populate html
				$.each(result, function (index, item) {
					var html = getItemHTML(item.book.ISBN, item.book.title, item.book.author, item.book.price, item.book.imgurl, item.qty);
					$("#cart-container").append(html);
				});
				
				updateTotal();
			}
			//failed to load cart
			else {
				
			}
		}); //end get
	}
	
	function removeFromCart(userId, bookId) {
		var requestURL = "Servlet?removeFromCart&userId=" + userId + "&bookId=" + bookId;
		$.get(requestURL, function (result, response) {
			if (result) {
				//reload books
				loadCart(userId);
			}
			else {
				//failed to delete book
				loadCart(userId);
			}
		});
	}
	
	function getItemHTML(id, title, author, price, img, qty) {
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
			'<td data-th="Price" class="price" price="' + price + '">$' + price + '</td>' +
			'<td data-th="Quantity">' +
				'<input type="number" class="form-control text-center qty-select" value="' + qty + '">' +
			'</td>' +
			'<td data-th="Subtotal" class="text-center sub-total" subtotal=' + getSubtotal(price, qty) + '>$' + getSubtotal(price, qty) + '</td>' +
			'<td class="actions" data-th="">' +
				'<button class="btn btn-default btn-sm btn-refresh-item"><i class="fa fa-refresh"></i></button>' +
				'<button class="btn btn-danger btn-sm btn-delete-item" bookId="' + id + '"><i class="fa fa-trash-o"></i></button>' +								
			'</td>' +
		'</tr>';
		return html;
	}
	
	function getSubtotal(price, qty) {
		return price * qty;
	}
	
	function getElementSubtotal(element) {
		
	}
	
	function updateTotal(){
		var total = 0;
		$.each($(".sub-total"), function () {
			total += parseFloat($(this).attr("subtotal"));
			$(this).html("$" + $(this).attr("subtotal"));
		});
		$("#cart-sub-total").html("Subtotal: $" + total.toFixed(2));
		
		if (total < 50) { //include shipping in cost
			$("#shipping-amt").html("Shipping: $5.99");
			var actualTotal = total + parseFloat($("#shipping-amt").attr("shipping-amt"));
			$("#final-total").html("$" + actualTotal.toFixed(2));
		}
		else {
			$("#shipping-amt").html("Shipping: $0 (order over $50)");
			$("#final-total").html("$" + total.toFixed(2));
		}

	}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
	
});





