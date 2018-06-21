package co.edu.usbcali.backend.logica;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.INoteDAO;
import co.edu.usbcali.backend.modelo.Note;

@Scope("singleton")
@Service("noteLogica")
public class NoteLogica implements INoteLogica{

	@Autowired
	private INoteDAO noteDAO;
	
	private BigDecimal bd = new BigDecimal(0);
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearNote(Note entity) throws Exception {
		if(entity==null) {
			throw new Exception("La note es nulo");
		}
		if(entity.getQualificationNote()==bd) {
			throw new Exception("La note es nulo");
		}
		
		noteDAO.crearNota(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarNote(Note entity) throws Exception {
		if(entity==null) {
			throw new Exception("La note es nulo");
		}
		if(entity.getQualificationNote()==bd) {
			throw new Exception("La note es nulo");
		}
		
		noteDAO.modificarNote(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarNote(Note entity) throws Exception {
		if(entity==null) {
			throw new Exception("La note es nulo");
		}
		if(entity.getIdNote()==0) {
			throw new Exception("El id es nulo");
		}
		
		noteDAO.eliminarNote(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Note consultarPorIdNote(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("");
		}
		return noteDAO.consultarPorIdNota(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Note> consultarTodosLosNote() throws Exception {
		return noteDAO.consultarTodasLasNote();
	}

	
	
}
