package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.Note;

public interface INoteLogica {

	public void crearNote(Note entity) throws Exception;
	public void modificarNote(Note entity) throws Exception;
	public void eliminarNote(Note entity) throws Exception;
	public Note consultarPorIdNote(Integer id) throws Exception;
	public List<Note> consultarTodosLosNote() throws Exception;
}
