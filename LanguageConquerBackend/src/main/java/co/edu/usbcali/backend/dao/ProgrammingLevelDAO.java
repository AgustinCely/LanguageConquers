package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.ProgrammingLevel;

@Scope("singleton")
@Repository("programmingLevelDAO")
public class ProgrammingLevelDAO implements IProgrammingLevelDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearProgrammingLevel(ProgrammingLevel entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarProgrammingLevel(ProgrammingLevel entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarProgrammingLevel(ProgrammingLevel entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public ProgrammingLevel consultarPorIdProgrammingLevel(Integer id) {
		return sessionFactory.getCurrentSession().get(ProgrammingLevel.class, id);
	}

	@Override
	public List<ProgrammingLevel> consultarTodosLosProgrammingLevel() {
		String sql="SELECT pl FROM ProgrammingLevel pl";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

}
