/**
 * 
 */
$(document).ready(function () {
	
	//load HTML parameters
	var params={};
	window.location.search
	  .replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str,key,value) {
	    params[key] = value;
	  }
	);
	
	var bookId = params["bookId"];
	
	loadBookInfo(bookId);
	
	function loadBookInfo(bookId) {
		var requestURL = "Servlet?loadBook&bookId=" + bookId;
		$.get(requestURL, function (book) {
			console.log(book);
			if (book) {
				$("#isbn").val(book.ISBN);
				$("#title").val(book.title);
				$("#author").val(book.author);
				$("#publisher").val(book.publisher);
				$("#year").val(book.year);
				$("#genre").val(book.genre);
				$("#price").val(book.price);
				$("#quantity").val(book.stock);
				$("#image").val(book.imgurl);
			}
		});
	}
});