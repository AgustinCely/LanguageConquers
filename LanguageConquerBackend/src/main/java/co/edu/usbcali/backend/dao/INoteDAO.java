package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.Note;

public interface INoteDAO {

	public void crearNota(Note entity);
	public void modificarNote(Note entity);
	public void eliminarNote(Note entity);
	public Note consultarPorIdNota(Integer id);
	public List<Note> consultarTodasLasNote();
	
}
