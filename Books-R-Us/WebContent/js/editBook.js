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
	var userId = getCookie("userId");
	$("#bookId").val(bookId);
	$("#userId").val(userId);
	
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
	
	function getCookie(name) {
		  var value = "; " + document.cookie;
		  var parts = value.split("; " + name + "=");
		  if (parts.length == 2) return parts.pop().split(";").shift();
		}
});