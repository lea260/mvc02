package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dto.ClienteEntidad;
import modelo.Conexion;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/Productos")
	private DataSource mipool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPruebas() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con = null;
		ArrayList<ClienteEntidad> listaPersonas = new ArrayList<ClienteEntidad>();
		try {
			con = mipool.getConnection();
			//con = Conexion.getConexion();
			PreparedStatement ps = con.prepareStatement("select * from clientes");
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				int edad = resultado.getInt("edad");
				ClienteEntidad personaDao = new ClienteEntidad(id, nombre, edad);
				listaPersonas.add(personaDao);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("lista", listaPersonas);
		RequestDispatcher rd= request.getRequestDispatcher("/clientelistar.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
