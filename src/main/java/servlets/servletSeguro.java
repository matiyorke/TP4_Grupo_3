package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.SeguroDao;
import dominio.Seguro;

@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletSeguro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String descripcion = request.getParameter("txtDescripcion");
		String idTipoStr = request.getParameter("ddlTipoSeguro");
		String costoContratacionStr = request.getParameter("txtCostoContratacion");
		String costoMaximoStr = request.getParameter("txtCostoMaximo");

		String mensaje = "";

		try {
			int idTipo = Integer.parseInt(idTipoStr);
			double costoContratacion = Double.parseDouble(costoContratacionStr);
			double costoMaximo = Double.parseDouble(costoMaximoStr);

			if (costoContratacion <= 0 || costoMaximo <= 0) {
				mensaje = "Los costos deben ser valores numéricos positivos.";
			}
			else {
				Seguro seguro = new Seguro();
				seguro.setDescripcion(descripcion);
				seguro.setIdTipo(idTipo);
				seguro.setCostoContratacion(costoContratacion);
				seguro.setCostoAsegurado(costoMaximo);

				SeguroDao dao = new SeguroDao();
				dao.agregarSeguro(seguro);

				mensaje = "Seguro agregado con éxito";
			}
		}
		catch (NumberFormatException e) {
			mensaje = "Los costos deben ser valores numéricos positivos.";
		}

		request.setAttribute("mensaje", mensaje);

		RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
		rd.forward(request, response);
	}

}