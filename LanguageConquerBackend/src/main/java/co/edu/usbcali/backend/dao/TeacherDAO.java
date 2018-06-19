package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Teacher;



@Scope("singleton")
@Repository("teacherDAO")
public class TeacherDAO implements ITeacherDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crear(Teacher entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}

	@Override
	public void modificar(Teacher entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}

	@Override
	public void eliminar(Teacher entity) {
		sessionFactory.getCurrentSession().delete(entity);
		
	}

	@Override
	public Teacher consultarPorId(Integer id) {
		return sessionFactory.getCurrentSession().get(Teacher.class, id);
	}

	@Override
	public List<Teacher> consultarTodos() {
		String sql="SELECT tea FROM Teacher tea";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}
	
	
}
