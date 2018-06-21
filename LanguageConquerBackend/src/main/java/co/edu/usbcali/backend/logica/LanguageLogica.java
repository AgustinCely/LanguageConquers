package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.ILanguageDAO;
import co.edu.usbcali.backend.modelo.Language;

@Scope("singleton")
@Service("languageLogica")
public class LanguageLogica implements ILanguageLogica{

	@Autowired
	private ILanguageDAO languageDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearLanguage(Language entity) throws Exception {
		if(entity == null) {
			throw new Exception("El language es nulo");
		}
		if(entity.getNameLanguage()==null || entity.getNameLanguage().trim().equals("")==true) {
			throw new Exception("El nombre del language es nulo");
		}
		
		languageDAO.crearLanguage(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarLanguage(Language entity) throws Exception {
		if(entity == null) {
			throw new Exception("El language es nulo");
		}
		if(entity.getNameLanguage()==null || entity.getNameLanguage().trim().equals("")==true) {
			throw new Exception("El nombre del language es nulo");
		}
		if(entity.getScoreParty()==0) {
			throw new Exception("El puntaje de equipo no puede ser cero");
		}
		
		languageDAO.modificarLanguage(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarLanguage(Language entity) throws Exception {
		if(entity == null) {
			throw new Exception("El language es nulo");
		}
		if(entity.getIdLanguage()==0) {
			throw new Exception("El id es nulo");
		}
		
		languageDAO.eliminarLanguage(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Language consultarPorIdLanguage(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return languageDAO.consultarPorIdLanguage(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Language> consultarTodosLosLanguage() throws Exception {
		return languageDAO.consultarTodosLosLanguage();
	}

	
	
}
