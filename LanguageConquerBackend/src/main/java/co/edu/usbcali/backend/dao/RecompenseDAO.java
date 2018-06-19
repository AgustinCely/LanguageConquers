package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Recompense;

@Scope("singleton")
@Repository("recompenseDAO")
public class RecompenseDAO implements IRecompenseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearRecompense(Recompense entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarRecompense(Recompense entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarRecompense(Recompense entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Recompense consultarPorIdRecompense(Integer id) {
		return sessionFactory.getCurrentSession().get(Recompense.class, id);
	}

	@Override
	public List<Recompense> consultarTodosLosRecompense() {
		String sql="SELECT r FROM Recompense r";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
