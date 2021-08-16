package portaldeevento.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import portaldeevento.EventoBean;

public class EventoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private EntityManager manager;

	public EventoBean porId(Long id) {
		return manager.find(EventoBean.class, id);
	}

	public List<EventoBean> raizes() {
		return manager.createQuery("from EventoBean where categoriaPai is null", EventoBean.class).getResultList();
	}

	public List<EventoBean> subcategoriasDe(EventoBean categoriaPai) {
		return manager.createQuery("from EventoBean where categoriaPai = :raiz", EventoBean.class)
				.setParameter("raiz", categoriaPai).getResultList();
	}

}
