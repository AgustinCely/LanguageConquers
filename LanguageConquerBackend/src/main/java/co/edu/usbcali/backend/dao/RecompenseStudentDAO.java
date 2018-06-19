package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.RecompenseStudent;

@Scope("singleton")
@Repository("recompenseStudentDAO")
public class RecompenseStudentDAO implements IRecompenseStudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearRecompenseStudent(RecompenseStudent entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarRecompenseStudent(RecompenseStudent entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarRecompenseStudent(RecompenseStudent entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public RecompenseStudent consultarPorIdRecompenseStudent(Integer id) {
		return sessionFactory.getCurrentSession().get(RecompenseStudent.class, id);
	}

	@Override
	public List<RecompenseStudent> consultarTodosLosRecompenseStudent() {
		String sql="SELECT rs FROM RecompenseStudent rs";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
