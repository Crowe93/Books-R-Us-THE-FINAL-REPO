/**
 * 
 */
$(document).ready(function () {
	
	loadOrders();
	
	$(document).on("click", ".btn-delete-user", function () {
		var userId = $(this).parent().attr("userId");
		deleteUser(userId);
	});
	
	$(document).on("click", ".btn-delete-book", function () {
		var bookId = $(this).parent().attr("bookId");
		deleteBook(bookId);
	});
	
	function loadOrders() {
		var requestURL = "AdminServlet?loadAllOrders";
		$.get(requestURL, function (result) {
			loadUsers();
			$("#orders-container").html("");
			$.each(result, function() {
				var html = getOrderHtml($(this)[0]);
				$("#orders-container").append(html);
			});
			
		});
	}
	
	function loadUsers() {
		var requestURL = "AdminServlet?loadUsers";
		$.get(requestURL, function (result) {
			loadBooks();
			$("#users-container").html("");
			$.each(result, function () {
				var user = $(this)[0];
				var html = getUserHtml(user);
				$("#users-container").append(html);
			});
		});
	}
	
	function loadBooks() {
		var requestURL = "Servlet?loadBooks";
		$.get(requestURL, function (result) {
			$("#books-container").html("");
			$.each(result, function() {
				var html = getBookHtml($(this)[0]);
				$("#books-container").append(html);
			});
		});
	}
	
	function deleteUser(userId) {
		var requestURL = "Servlet?deleteAccount&userId=" + userId;
		$.get(requestURL, function () { 
			loadUsers();
		});
	}
	
	function deleteBook(bookId) {
		var requestURL = "AdminServlet?deleteBook&bookId=" + bookId;
		$.get(requestURL, function () {
			loadBooks();
		});
	}
	
	function getUserHtml(user) {
		//console.log(user);
		var html =  '<tr>' +
        '<td>' + user.id + '</td>' +
        '<td>' + user.fname + '</td>' +
        '<td>' + user.lname + '</td>' +
        '<td>' + user.username + '</td>' +
        '<td>' + user.email + '</td>' +
        '<td> ***** </td>' +
        '<td class="actions" data-th="" userId=' + user.id + '>' +
            '<a href="editUser.html?userId=' + user.id + '" class="btn btn-default btn-sm"><i class="fa fa-pencil"></i></a>' +
            '<button class="btn-delete-user btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>		' +						
        '</td>' +
    '</tr>';
		
		return html;
	}
	
	function getBookHtml(book) {
		console.log(book);
		var html = '<tr>' +
    	'<td>' + book.ISBN + '</td>' +
    	'<td>' + book.title + '</td>' +
        '<td>' + book.author + '</td>' +
        '<td>' + book.publisher + '</td>' +
        '<td>' + book.genre + '</td>' +
        '<td>' + book.year + '</td>' +
        '<td>$' + book.price.toFixed(2) + '</td>' +
        '<td>' + book.stock + '</td>' +
        '<td class="actions" data-th="" bookId="' + book.ISBN + '">' +
            '<a href="edit-book.html?bookId=' + book.ISBN + '" class="btn btn-default btn-sm"><i class="fa fa-pencil"></i></a>' +
            '<button class="btn-delete-book btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>' +								
        '</td>' +
    '</tr>';
		return html;
	}
	
	function getOrderHtml(order) {
		
		var html = '<tr>' +
        '<td>' + order.orderNum + '</td>' +
        '<td class="txt-oflo">' + order.user.username + '</td>' +
        '<td>SHIPPING</td>' +
        '<td class="txt-oflo">' + order.date + '</td>' +
        '<td><span class="text-success">$' + order.orderTotal.toFixed(2) + '</span></td>' +
    '</tr>';
		
		return html;
	}
});