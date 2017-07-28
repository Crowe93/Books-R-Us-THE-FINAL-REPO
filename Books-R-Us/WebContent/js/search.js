/**
 * 
 */
$(document).ready(function () {
	
	loadBooks();
	
	$(".btn-search").click(function () {
		var searchVal = $("#search-value").val();
		var filterType = $("#search-filter").val(); // 0 = title | 1 = isbn | 2 = author
			
		searchBooks(filterType, searchVal);
		
		
	});
	
	$(document).on("click", ".add-book-btn", function () {
		//alert("Test");
		var userId = getCookie("userId");
		
		//test for user id
		if (!userId)
			{
				$(location).attr('href','login.html');
				return;
			}

		
		var bookId = $(this).attr("bookId");
		addToCart(userId, bookId, $(this));
	});
	
	function addToCart(userId, bookId, buttonElement) {
		
		
		var requestURL = "Servlet?addToCart&userId=" + userId + "&bookId=" + bookId;
		$.get(requestURL, function (result, response) {
			if (result) {
				if (result.status == 1)
					{
						buttonElement.text(result.msg);
						buttonElement.removeClass("add-book-btn");
					}
				else
					{
						buttonElement.text(result.msg);
					}

			}
			else {

			}
		});
	}
	
	function loadBooks() {
		var requestURL = "Servlet?loadBooks";
		$.get(requestURL, function (result, response) {
			//iterate through list of books returned as json response
			$("#book-container").html("");
			$.each(result, function (index, book) {
				
				var html = getBookHtml(book);
				
				$("#book-container").append(html);
			});
		});
	}
	
	function searchBooks(filterType, searchVal) {
		//check for functional search value
		if (!searchVal)
			{
				loadBooks();
				return;
			}
		
		var requestURL = "Servlet?searchBooks&filterType=" + filterType + "&searchVal=" + searchVal;
		$.get(requestURL, function (result, response) {
			//iterate through list of books returned as json response
			$("#book-container").html("");
			$.each(result, function (index, book) {
				
				var html = getBookHtml(book);
				
				$("#book-container").append(html);
			});
		});
	}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
	
	function getBookHtml(book) {
		var html = '<tr>' +
		'<!-- product details -->' +
		'<td data-th="Product">' +
			'<div class="row">' +
				'<div class="col-sm-3 hidden-xs"><img style="width:150px; height: auto;" src="' + book.imgurl + '"class="img-responsive"/></div>' +
				'<div class="col-sm-9">' +
					'<h5 class="nomargin">' + book.title + '</h5>' +
					'<p class="text-left">Novel by ' + book.author + '</p>' +
					'<p class="text-left text-muted" style="font-style: italic; font-size:12px;" >' + book.genre + '</p>' +
					'<hr align="left" style="width:65%">' +
					'<p class=>Published by <mark>' + book.publisher + '</mark></p>' +
					'<p class="text-left">Published in ' + book.year + '</p>' +
					'<p class="text-primary"><span style="font-weight:bold;">ISBN-13: ' + book.id + '</span></p>' +
					
				'</div>' +
			'</div>' +
		'</td>' +
		
		'<!-- Product pricing -->' +
		'<td>' +
			'<div class="cart-price">' +
				'<h4 class="text-left">$' + book.price + ' </h4>' +
				'<button class="btn btn-default button-0 add-book-btn" bookId="' + book.ISBN + '"> Add to Cart</button>		' +
			'</div>' +
		'</td>' +
	'</tr>;'
		
		return html;
	}
	
});