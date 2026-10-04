<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.TipoSeguros"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar seguro</title>
</head>
<body>
<header>
		<nav>
			<a href="Inicio.jsp"> Inicio </a>
			<a href="servletSeguro">Agregar Seguros</a>
			<a href="servletSeguro?accion=listar">Listar Seguros</a>
		</nav>

		<h1>Agregar Seguros</h1>

<%
	ArrayList<TipoSeguros> listaTipos = (ArrayList<TipoSeguros>) request.getAttribute("listaTipos");
	int proximoId = (Integer) request.getAttribute("proximoId");

	String mensaje = (String) request.getAttribute("mensaje");
%>

<% if (mensaje != null && !mensaje.equals("")) { %>
	<p><%= mensaje %></p>
<% } %>

		<form method="post" action="servletSeguro">
        <table>
            <tr>
                <td>Id Seguro:</td>
                <td><%= proximoId %></td>
            </tr>
            <tr>
                <td>Descripción:</td>
                <td><input type="text" name="txtDescripcion"></td>
            </tr>
            <tr>
                <td>Tipo de Seguro:</td>
                <td>
                    <select name="ddlTipoSeguro">
<%
	for (int i = 0; i < listaTipos.size(); i++) {
		TipoSeguros tipo = listaTipos.get(i);
%>
                       <option value="<%= tipo.getIdTipo() %>"><%= tipo.getDescripcion() %></option>
<%
	}
%>
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