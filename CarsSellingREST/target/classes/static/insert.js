$(document).ready(function() {
 
  $('#newPositionForm').submit(function(event) {
 
      var json = {
                manufacturer: $('#manufacturer').val(),
                model: $('#model').val(),
                color: $('#color').val(),
                transmission: $('#transmission').val(),
				body_type: $('#body_type').val(),
				price: $('#price').val()
            };

 
    $.ajax({
		type: 'POST',
		contentType: 'application/json',
        url: '/ListCarsSelling',
        data: JSON.stringify(json),
        success: function(s){
			window.location = '/'
		},

		error: function(e){
			window.location= '/insert'	
		}
		
    });
 
    event.preventDefault();
  });
 
});