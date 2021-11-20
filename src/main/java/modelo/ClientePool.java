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

	private DataSource mipool;

	public ClientePool(DataSource mipool) {
		this.mipool = mipool;
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ClienteEntidad> obternerListaClientes() {
		// TODO Auto-generated method stub
		Connection con = null;
		ArrayList<ClienteEntidad> listaPersonas = new ArrayList<ClienteEntidad>();
		try {
			con = mipool.getConnection();
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

		}
		return listaPersonas;
	}

}
