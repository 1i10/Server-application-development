$(document).ready(function() {
			$.getJSON('/ListCarsSelling', function(json) {
				var tr=[];
				for (var i = 0; i < json.length; i++) {
					tr.push('<tr>');
					tr.push('<td>' + json[i].code + '</td>');
					tr.push('<td>' + json[i].manufacturer + '</td>');
					tr.push('<td>' + json[i].model + '</td>');
					tr.push('<td>' + json[i].color + '</td>');
					tr.push('<td>' + json[i].transmission + '</td>');
					tr.push('<td>' + json[i].body_type + '</td>');
					tr.push('<td>' + json[i].price + '</td>');
					tr.push('<td><a href="/update?code='+json[i].code+'"><button>Update</button></a>&nbsp;&nbsp;'
					+ '<button id="deletePosition" value='+json[i].code+'>Delete</button></td>');
					tr.push('</tr>');
				}
				$('table').append($(tr.join('')));
			});
			
});