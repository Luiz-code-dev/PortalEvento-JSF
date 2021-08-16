package portaldeevento.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import portaldeevento.UsuarioBean;

public class ConnectController {

	public UsuarioBean usuario;

	Connection con = null;

	public ConnectController() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Instalou driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		String url = "jdbc:postgresql://localhost:5432/eventosportdb";
		String user = "postgres";
		String password = "800529";
		con = DriverManager.getConnection(url, user, password);
	}

	public void closeConnection() throws SQLException {

		con.close();
	}

	@SuppressWarnings("unused")
	public boolean insertUsuario(UsuarioBean usuario) {

		Statement st = null;
		ResultSet rs = null;
		return false;
	}

	// lista todos os usuarios cadastrados no banco de dados

	public List<UsuarioBean> listUsuarios() {

		ArrayList<UsuarioBean> lista = new ArrayList<UsuarioBean>();

		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			String sql = "select * from usuario ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				UsuarioBean usuario = new UsuarioBean();
				usuario.setNomeCompleto(rs.getString(2));
				usuario.setSenha(rs.getString(3));
				usuario.setApelido(rs.getString(4));
				usuario.setEmail(rs.getString(5));
				lista.add(usuario);
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(ConnectController.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(ConnectController.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return lista;
	}

}
