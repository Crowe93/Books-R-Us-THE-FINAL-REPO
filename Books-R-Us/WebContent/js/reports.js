/**
 * 
 */
$(document).ready(function () {
	
	loadInventoryReport();
	
	$("#btn-sales-report").click(function () {
		var date = $("#sales-date").val();
		loadSalesReport(date);
	});
	
	function loadInventoryReport() {
		var requestURL = "AdminServlet?loadInventoryReport";
		$.get(requestURL, function (report) {
			$("#low-inventory-container").html("");
			$.each(report.books, function () {
				var html = getInventoryHtml($(this)[0]);
				$("#low-inventory-container").append(html);
			});
		});
	}
	
	function loadSalesReport(date) {
		var requestURL = "AdminServlet?loadSalesReport&date=" + date;
		$.get(requestURL, function (report) {
			$("#sales-container").html("");
			var html = getSalesHtml(report);
			$("#sales-container").html(html);
		});
	}
	
	function getInventoryHtml(book) {
		var html = '<tr>' +
    	'<td>' + book.ISBN + '</td>' +
    	'<td>' + book.title + '</td>' +
        '<td>' + book.publisher + '</td>' +
        '<td>' + book.minimum + '</td>' +
        '<td><p class="text-danger" style="font-size:15px; font-weight:bold; ">' + book.stock + '</p></td>' +
    '</tr>';
		return html;
	}
});