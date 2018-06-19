package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.MissionState;

@Scope("singleton")
@Repository("missionStateDAO")
public class MissionStateDAO implements IMissionStateDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearMissionState(MissionState entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarMissionState(MissionState entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarMissionState(MissionState entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public MissionState consultarPorIdMissionState(Integer id) {
		return sessionFactory.getCurrentSession().get(MissionState.class, id);
	}

	@Override
	public List<MissionState> consultarTodosLosMissionState() {
		String sql ="SELECT ms FROM MissionState ms";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
