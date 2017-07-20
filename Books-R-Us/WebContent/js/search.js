/**
 * 
 */
$(document).ready(function () {
	
	
	
	$(".btn-search").click(function () {
		var searchVal = $("#search-value").val();
		var filterType = $("#search-filter").val(); // 0 = title | 1 = isbn | 2 = author
			
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
				'<button name="add" type="submit" class="btn btn-info btn-default"> Add to Cart</button>		' +						
			'</td>' +
			
		'</tr>';
				
				$("#book-container").append(html);
			});
		});
		
		
	});
	
	
	
});