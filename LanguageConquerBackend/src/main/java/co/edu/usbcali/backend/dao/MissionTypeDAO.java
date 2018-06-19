package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.MissionType;

@Scope("singleton")
@Repository("missionTypeDAO")
public class MissionTypeDAO implements IMissionTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearMissionType(MissionType entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarMissionType(MissionType entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarMissionType(MissionType entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public MissionType consultarPorIdMissionType(Integer id) {
		return sessionFactory.getCurrentSession().get(MissionType.class, id);
	}

	@Override
	public List<MissionType> consultarTodosLosMissionType() {
		String sql="SELECT mt FROM MissionType mt";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
