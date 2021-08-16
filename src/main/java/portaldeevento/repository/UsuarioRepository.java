package portaldeevento.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import portaldeevento.UsuarioBean;

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public UsuarioBean porId(Long id) {
		return this.manager.find(UsuarioBean.class, id);
	}

	public List<UsuarioBean> vendedores() {
		// TODO filtrar apenas usuarios (por um grupo específico)
		return this.manager.createQuery("from UsuarioBean", UsuarioBean.class).getResultList();
	}

	public UsuarioBean porEmail(String email) {
		UsuarioBean usuario = null;

		try {
			usuario = this.manager.createQuery("from UsuarioBean where lower(email) = :email", UsuarioBean.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o e-mail informado
		}

		return usuario;
	}

}
