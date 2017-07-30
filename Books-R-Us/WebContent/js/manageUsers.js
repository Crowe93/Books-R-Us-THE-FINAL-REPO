/**
 * 
 */
$(document).ready(function () {
	
	//loadUsers();
	
	function loadUsers() {
		var requestURL = "AdminServlet?loadUsers";
		$.get(requestURL, function (result) {
			$("#users-container").html("");
			$.each(result, function () {
				var user = $(this)[0];
				var html = getUserHtml(user);
				$("#users-container").append(html);
			});
		});
	}
	
	function getUserHtml(user) {
		console.log(user);
		var html =  '<tr>' +
        '<td>' + user.id + '</td>' +
        '<td>' + user.fname + '</td>' +
        '<td>' + user.lname + '</td>' +
        '<td>' + user.username + '</td>' +
        '<td>' + user.email + '</td>' +
        '<td> ***** </td>' +
        '<td class="actions" data-th="">' +
            '<a href="editUser&userId=' + user.id + '" class="btn btn-default btn-sm"><i class="fa fa-pencil"></i></a>' +
            '<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>		' +						
        '</td>' +
    '</tr>';
		
		return html;
	}
});