package portaldeevento.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import portaldeevento.UsuarioBean;


public class UsuarioController {

	private ConnectController connectController;

	private UsuarioBean usuario = new UsuarioBean();

	public String cadastraUsuario() throws SQLException {

		ConnectController con = new ConnectController();

		if (con.insertUsuario(usuario)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário cadastrado com sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastr de usuário!"));

		}
		con.closeConnection();

		return "";
	}

	public List<UsuarioBean> getUsuarios() throws SQLException {

		ConnectController con = new ConnectController();
		List<UsuarioBean> listaUsuarios = con.listUsuarios();

		return listaUsuarios;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public ConnectController getConnectController() {
		return connectController;
	}

	public void setConnectController(ConnectController connectController) {
		this.connectController = connectController;
	}
}
