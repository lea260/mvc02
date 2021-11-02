package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ClienteEntidad;

public class ClienteDao {

	public ArrayList<ClienteEntidad> obternerListaClientes() {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
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

	public int agregarCliente(ClienteEntidad cli) {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		int resultado = -1;

		try {
			PreparedStatement ps = con.prepareStatement("insert into clientes (nombre, edad) values(?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, cli.getNombre());
			ps.setInt(2, cli.getEdad());
			// resultado = ps.executeUpdate();
			if (ps.executeUpdate() > 0) {
				// Retrieves any auto-generated keys created as a result of executing this
				// Statement object
				java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					int primkey = generatedKeys.getInt(1);
					resultado = primkey;
				}
			}
			// System.out.println("Record updated with id = "+primkey);

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
		return resultado;
	}

	public boolean eliminarCliente(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		boolean resultado = false;
		try {
			PreparedStatement ps = con.prepareStatement("delete from clientes where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
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
		return true;
	}

	public boolean editarCliente(ClienteEntidad cli) {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		int resultado = -1;
		try {
			PreparedStatement ps = con.prepareStatement("update clientes set nombre=?,edad=? where id=?");
			ps.setString(1, cli.getNombre());
			ps.setInt(2, cli.getEdad());
			ps.setInt(3, cli.getId());
			resultado = ps.executeUpdate();
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
		return true;
	}

	public ClienteEntidad obtenerClienteId(int idInt) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		ClienteEntidad cliente = new ClienteEntidad();
		try {
			PreparedStatement ps = con.prepareStatement("select * from clientes where id=?");
			ps.setInt(1, idInt);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				int edad = resultado.getInt("edad");
				cliente = new ClienteEntidad(id, nombre, edad);
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
		return cliente;
	}

}
