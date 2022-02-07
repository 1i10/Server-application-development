<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert new position</title>
</head>
<body>
<h2>New position</h2>
<form method="post">
<label>manufacturer</label><br>
<input name="manufacturer"/><br>
<label>model</label><br>
<input name="model"/><br>
<label>color</label><br>
<input name="color"/><br>
<label>transmission</label><br>
<select name="transmission">
<option>Manual</option>
<option>Automatic</option>
</select><br>
<label>body type</label><br>
<select name="body_type">
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
<input name="price" type="text"/><br><br>
<input type="submit" value="Save" />
</form>
</body>
</html>