package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Client;

import dto.ClienteEntidad;
import modelo.ClienteDao;
import modelo.ClientePool;

/**
 * Servlet implementation class clientelista
 */
@WebServlet("/cliente/listar")
public class clientelista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientelista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ClienteDao dao = new  ClienteDao();
		//ArrayList<ClienteEntidad> array= dao.obternerListaClientes();
		ClientePool pool = new ClientePool();
		ArrayList<ClienteEntidad> array= pool.obternerListaClientes();
		request.setAttribute("lista", array);
		RequestDispatcher rd= request.getRequestDispatcher("/clientelistar.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
