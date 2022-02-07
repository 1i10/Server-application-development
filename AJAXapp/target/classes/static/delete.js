$(document).on('click', '#deletePosition', function() {
	var code = $(this).attr('value');
	var rowToDelete = $(this).closest('tr');
	console.log(code);

	$.ajax({
		url: '/ListCarsSelling/' + code,
		type: 'DELETE',
		contentType: 'application/json',
		success: function() {
			rowToDelete.remove();
		},
		error: function(error) {
			alert(error);
		}
	});
});