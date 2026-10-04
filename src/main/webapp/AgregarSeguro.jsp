<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar seguro</title>
</head>
<body>
<header>
		<nav>
			<a href="/Inicio.jsp"> Inicio </a>
			<a href="/AgregarSeguro.jsp">Agregar Seguros</a>
			<a href="/ListarSeguros">Listar Seguros</a>
		</nav>
		
		<h1>Agregar Seguros</h1>
		
		<form method="post" action="servletSeguro">
        <table>
            <tr>
                <td>Id Seguro:</td>                
            </tr>
            <tr>
                <td>Descripción:</td>
                <td><input type="text" name="txtDescripcion"></td>
            </tr>
            <tr>
                <td>Tipo de Seguro:</td>
                <td>
                    <select name="ddlTipoSeguro">
                       
                    </select>
                </td>
            </tr>
            <tr>
                <td>Costo contratación:</td>
                <td><input type="text" name="txtCostoContratacion"></td>
            </tr>
            <tr>
                <td>Costo Máximo Asegurado:</td>
                <td><input type="text" name="txtCostoMaximo"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="btnAceptar" value="Aceptar"></td>
            </tr>
        </table>
    </form>
		
</header>
</body>
</html>