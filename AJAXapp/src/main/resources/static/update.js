$(document).ready(function() {
	loadPosition();
});

$(document).on('click', '#updatePosition', function() {
	var position = {
		code: $('#code').val(),
		manufacturer: $('#manufacturer').val(),
		model: $('#model').val(),
		color: $('#color').val(),
		transmission: $('#transmission').val(),
		body_type: $('#body_type').val(),
		price: $('#price').val()
	};

	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: '/ListCarsSelling/' + position.code,
		data: JSON.stringify(position),
		success: function(data) {
			window.location = '/';
		},
		error: function(error) {
			alert(error);
		}
	}).done()

});

function getCodeFromURL(param) {
	var pageURL = decodeURIComponent(window.location.search.substring(1)),
		urlVars = pageURL.split('&'),
		paramName,
		i;
	//console.log(pageURL);
	//console.log(urlVars);

	for (i = 0; i < urlVars.length; i++) {
		paramName = urlVars[i].split('=');

		if (paramName[0] === param) {
			return paramName[1] === undefined ? true : paramName[1];
		}
	}
}

function loadPosition() {
	var code = getCodeFromURL('code');

	$.ajax({
		type: 'GET',
		url: '/ListCarsSelling/' + code,
		datatype: 'json',
		success: function(data) {
			$('#code').val(data.code),
				$('#manufacturer').val(data.manufacturer),
				$('#model').val(data.model),
				$('#color').val(data.color),
				$('#transmission').val(data.transmission),
				$('#body_type').val(data.body_type),
				$('#price').val(data.price);
		},
		error: function(error) {
			window.location = '/';
			alert(error);
		}
	}).done()
}