package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Language;

@Scope("singleton")
@Repository("languageDAO")
public class LanguageDAO implements ILanguageDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearLanguage(Language entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarLanguage(Language entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarLanguage(Language entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Language consultarPorIdLanguage(Integer id) {
		return sessionFactory.getCurrentSession().get(Language.class, id);
	}

	@Override
	public List<Language> consultarTodosLosLanguage() {
		String sql="SELECT lan FROM Language lan";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
