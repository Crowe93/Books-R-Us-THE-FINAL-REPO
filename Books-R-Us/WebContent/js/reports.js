/**
 * 
 */
$(document).ready(function () {
	
	loadInventoryReport();
	$("#sales-container").html("");
	
	$("#btn-sales-report").click(function () {
		var date = $("#sales-date").val();
		if (!date || date === "")
			return;
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
			console.log(report);
			$.each(report.booksales, function () {
				var html = getSalesHtml($(this)[0]);
				$("#sales-container").append(html);
			});
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
	
	function getSalesHtml(sale) {
		var html = '<tr>' +
        '<td>' + sale.book.ISBN + '</td>' +
        '<td>' + sale.book.title + '</td>' +
        '<td>$' + sale.book.price.toFixed(2) + '</td>' +
        '<td>' + sale.date + '</td>' +
        '<td>' + sale.numSold + '</td>' +
        '<td><span class="text-success">$' + (sale.numSold * sale.book.price).toFixed(2) + '</span></td>' +
        '</tr>';
		return html;
	}
});