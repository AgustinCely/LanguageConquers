package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.MissionLevel;

@Scope("singleton")
@Repository("missionLevelDAO")
public class MissionLevelDAO implements IMissionLevelDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearMissionLevel(MissionLevel entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarMissionLevel(MissionLevel entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarMissionLevel(MissionLevel entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public MissionLevel consultarPorIdMissionLevel(Integer id) {
		return sessionFactory.getCurrentSession().get(MissionLevel.class, id);
	}

	@Override
	public List<MissionLevel> consultarTodosLosMissionLevel() {
		String sql ="SELECT ml FROM MissionLevel ml";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

}
