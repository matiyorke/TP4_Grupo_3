<%@page import="dominio.Seguro"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.TipoSeguros"%>
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
		<%ArrayList<TipoSeguros> listaTipos = null;

	    if (request.getAttribute("listaTipos") != null) {
	        listaTipos = (ArrayList<TipoSeguros>) request.getAttribute("listaTipos");
	    }
		%>
		<form method="post" action="servletSeguro">
		Filtrar por tipo: <select name="filtradoSeguros">
		<%
            for (TipoSeguros tipo : listaTipos) {
        %>
        
        <option value="<%= tipo.getIdTipo() %>">
                <%= tipo.getDescripcion() %>
            </option>

        <%
            }
        %>
        
        </select>
        
        
		<input type="submit" value= "Filtrar" name="btnFiltrar"/>
		<input type="submit" value= "Mostrar todos" name="btnMostrarTodos"/>
	</form>
	<br>
		<%
		ArrayList<Seguro> listadeseguros=null;
		if(request.getAttribute("listaS")!=null)
		{
			listadeseguros= (ArrayList<Seguro>)request.getAttribute("listaS");
		}
		
		%>
	<table border= "1">
	<thead>
	<tr>
		<th>ID seguro</th> <th>Descripción</th> <th>Tipo de seguro</th> <th>Costo contratación</th> <th>Costo Máx. Asegurado</th>
		</tr>
		
	</thead>
	<tbody>
		<%
            if (listadeseguros != null) {

                for (Seguro seg : listadeseguros) {
        %>

        <tr>
            <td><%= seg.getIdSeguro() %></td>
            <td><%= seg.getDescripcion() %></td>
            <td>
            <%
	        for (TipoSeguros tipo : listaTipos) {
	            if (tipo.getIdTipo() == seg.getIdTipo()) {
	    	%>
	        <%= tipo.getDescripcion() %>
	    	<%
		            }
		        }
	    	%>
            
            </td>
            <td><%= seg.getCostoContratacion() %></td>
            <td><%= seg.getCostoAsegurado() %></td>
        </tr>

        <%
                }
            }
        %>

    </tbody>
	</tbody>
	
	</table>
</body>
</html>