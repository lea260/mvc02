package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ClienteEntidad;
import modelo.ClienteDao;

/**
 * Servlet implementation class ClienteNuevo
 */
@WebServlet("/cliente/nuevo")
public class ClienteNuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteNuevo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ClienteDao dao = new ClienteDao();
			String idNombreStr = request.getParameter("nombre");
			String EdadStr = request.getParameter("edad");
			int edadInt = Integer.parseInt(EdadStr);
			ClienteEntidad cli = new ClienteEntidad(0, idNombreStr, edadInt);
			dao.agregarCliente(cli);
			ArrayList<ClienteEntidad> array = dao.obternerListaClientes();
			request.setAttribute("lista", array);
			RequestDispatcher rd = request.getRequestDispatcher("/clientelistar.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
