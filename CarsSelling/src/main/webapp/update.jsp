<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update position</title>
</head>
<body>
<h3>Update position</h3>
<form method="post">
<input type="hidden" value="${position.code}" name="code" />
<label>manufacturer</label><br>
<input name="manufacturer" value="${position.manufacturer}"/><br>
<label>model</label><br>
<input name="model" value="${position.model}"/><br>
<label>color</label><br>
<input name="color" value="${position.color}"/><br>
<label>transmission</label><br>
<select name="transmission" >
<option>${position.transmission}</option>
<option>Manual</option>
<option>Automatic</option>
</select><br>
<label>body type</label><br>
<select name="body_type">
<option>${position.body_type}</option>
<option>Compact</option>
<option>Crossover</option>
<option>Coupe</option>
<option>Hatchback</option>
<option>Pickup</option>
<option>Sedan</option>
<option>Sport coupe</option>
<option>SUV</option>
<option>Van</option>
<option>Wagon</option>
</select><br>
<label>price</label><br>
<input name="price" value="${position.price}" type="text"/><br><br>
<input type="submit" value="Update" />
</form>
</body>
</html>