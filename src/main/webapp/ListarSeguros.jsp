<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Seguros</title>
</head>
<body>

<nav>
	<a href="Inicio.jsp"> Inicio </a>
	<a href="servletSeguro">Agregar Seguros</a>
	<a href="servletSeguro?accion=listar">Listar Seguros</a>
</nav>

	<h1>Listado de Seguros</h1>

	Filtrar por tipo: <select name="filtradoSeguros"></select>
	<input type="submit" value= "Filtrar" name="btnFiltrar"/>
	<input type="submit" value= "Mostrar todos" name="btnMostrarTodos"/> <br>
		
	<table border= "1">
	<thead>
		<tr>
			<td>ID seguro</td>
			<td>Descripción</td>
			<td>Tipo de seguro</td>
			<td>Costo contratación</td>
			<td>Costo Máx. Asegurado</td>
		</tr>
	</thead>
	<tbody>
	
	</tbody>
	
	</table>
</body>
</html>