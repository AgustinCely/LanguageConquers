package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Avatar;


@Scope("singleton")
@Repository("avatarDAO")
public class AvatarDAO implements IAvatarDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearAvatar(Avatar entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarAvatar(Avatar entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}

	@Override
	public void borrarAvatar(Avatar entity) {
		sessionFactory.getCurrentSession().delete(entity);
		
	}

	@Override
	public Avatar consultarPorIdAvatar(Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Avatar.class, id);
	}

	@Override
	public List<Avatar> consultarTodosLosAvatar() {
		String sql="SELECT ava FROM Avatar ava";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}
	
	

}
