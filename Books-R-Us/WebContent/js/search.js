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
			$(location).attr('href','../Books-R-Us/login.html');
		
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
				
				var html = 		'					<tr>' +
				'<td data-th="Product">' +
				'<div class="row">' +
					'<div class="col-sm-4 hidden-xs"><img src="' + book.imgurl + '"class="img-responsive"/></div>' +
					'<div class="col-sm-8">' +
						'<h4 class="text-left">' + book.title + '</h4>' +
						'<p>' + book.author + '</p>' +
						'<p>' + book.genre + '</p>' +
						'<p>' + book.year + '</p>' +
					'</div>' +
				'</div>' +
			'</td>' +

					'<td class="actions" data-th="">' +
				'<h3 class="text-left"> $' + book.price + '</h3>' +
				'<button class="btn btn-info btn-default add-book-btn" bookId="' + book.ISBN + '"> Add to Cart</button>		' +						
			'</td>' +
			
		'</tr>';
				
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
				
				var html = 		'					<tr>' +
				'<td data-th="Product">' +
				'<div class="row">' +
					'<div class="col-sm-4 hidden-xs"><img src="' + book.imgurl + '"class="img-responsive"/></div>' +
					'<div class="col-sm-8">' +
						'<h4 class="text-left">' + book.title + '</h4>' +
						'<p>' + book.author + '</p>' +
						'<p>' + book.genre + '</p>' +
						'<p>' + book.year + '</p>' +
					'</div>' +
				'</div>' +
			'</td>' +

					'<td class="actions" data-th="">' +
				'<h3 class="text-left"> $' + book.price + '</h3>' +
				'<button class="btn btn-info btn-default add-book-btn" bookId="' + book.ISBN + '"> Add to Cart</button>		' +						
			'</td>' +
			
		'</tr>';
				
				$("#book-container").append(html);
			});
		});
	}
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
	
});