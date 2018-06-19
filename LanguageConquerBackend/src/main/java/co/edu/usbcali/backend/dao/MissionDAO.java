package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Mission;

@Scope("singleton")
@Repository("missionDAO")
public class MissionDAO implements IMissionDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearMission(Mission entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarMission(Mission entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarMission(Mission entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Mission consultarPorIdMission(Integer id) {
		return sessionFactory.getCurrentSession().get(Mission.class, id);
	}

	@Override
	public List<Mission> consultarTodosLosMission() {
		String sql="SELECT mi FROM Mission mi";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
