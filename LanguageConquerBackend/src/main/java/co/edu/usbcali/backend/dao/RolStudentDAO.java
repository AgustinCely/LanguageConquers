package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.RolStudent;

@Scope("singleton")
@Repository("rolStudentDAO")
public class RolStudentDAO implements IRolStudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearRolStudent(RolStudent entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarRolStudent(RolStudent entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarRolStudent(RolStudent entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public RolStudent consultarPorIdRolStudent(Integer id) {
		return sessionFactory.getCurrentSession().get(RolStudent.class, id);
	}

	@Override
	public List<RolStudent> consultarTodosLosRolStudent() {
		String sql="SELECT ros FROM RolStudent ros";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
