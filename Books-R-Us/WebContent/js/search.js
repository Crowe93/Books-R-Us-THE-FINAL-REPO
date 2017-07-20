/**
 * 
 */
$(document).ready(function () {
	
	$("#loadBookBtn").click(function () {
		//load books with ajax
		var requestURL = "Servlet?loadBooks";
		$.get(requestURL, function (result, response) {
			//iterate through list of books returned as json response
			$.each(result, function (book) {
				
				var html = '<img src="' + book.imgurl + '" width="50px" height="50px">' + book.title + ' Author Publisher Price Stock <br>'
				
				$("#searchContainer").append(html);
			});
		});
		
		
	});
	
	
	
});