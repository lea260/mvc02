package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;

import dto.ClienteEntidad;

public class ClientePool {

	//@Resource(name = "jdbc/Productos")
	private DataSource mipool;

	public Connection ClientePool() {
		// TODO Auto-generated constructor stub
		Connection con=null;
		try {
			// Esta parte es fija
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			// Y aquí pedimos nuestra conexión, por su nombre
			DataSource ds = (DataSource) envCtx.lookup("jdbc/bdprog01");
			con = ds.getConnection();

			// Aquí la transacción con la base de datos

			// Se cierra la conexión, ya que estamos en un pool de conexiones
			// para dejarla libre a otros procesos.
			//conexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<ClienteEntidad> obternerListaClientes() {
		// TODO Auto-generated method stub
		Connection con = this.ClientePool();
		ArrayList<ClienteEntidad> listaPersonas = new ArrayList<ClienteEntidad>();
		try {
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
		return listaPersonas;
	}

}
