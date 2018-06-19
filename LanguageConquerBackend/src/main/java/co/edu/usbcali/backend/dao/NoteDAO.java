package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Note;

@Scope("singleton")
@Repository("noteDAO")
public class NoteDAO implements INoteDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearNota(Note entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarNote(Note entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarNote(Note entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Note consultarPorIdNota(Integer id) {
		return sessionFactory.getCurrentSession().get(Note.class, id);
	}

	@Override
	public List<Note> consultarTodasLasNote() {
		String sql="SELECT not FROM Note not";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

}
