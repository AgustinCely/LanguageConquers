package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IProgrammingLevelDAO;
import co.edu.usbcali.backend.modelo.ProgrammingLevel;


@Scope("singleton")
@Service("programmingLevelLogica")
public class ProgrammingLevelLogica implements IProgrammingLevelLogica {
	
	@Autowired
	private IProgrammingLevelDAO programmingLevelDAO;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearProgrammingLevel(ProgrammingLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El programminglevel es nulo");
		}
		if(entity.getNameProgrammingLevel()==null || entity.getNameProgrammingLevel().trim().equals("")==true) {
			throw new Exception("El nombre de programminglevel es nulo");
		}
		
		programmingLevelDAO.crearProgrammingLevel(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarProgrammingLevel(ProgrammingLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El programminglevel es nulo");
		}
		if(entity.getNameProgrammingLevel()==null || entity.getNameProgrammingLevel().trim().equals("")==true) {
			throw new Exception("El nombre de programminglevel es nulo");
		}
		
		programmingLevelDAO.modificarProgrammingLevel(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarProgrammingLevel(ProgrammingLevel entity) throws Exception {
		if(entity==null) {
			throw new Exception("El programminglevel es nulo");
		}
		if(entity.getIdProgrammingLevel()==0) {
			throw new Exception("El id es nulo");
		}
		
		programmingLevelDAO.eliminarProgrammingLevel(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public ProgrammingLevel consultarPorIdProgrammingLevel(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return programmingLevelDAO.consultarPorIdProgrammingLevel(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProgrammingLevel> consultarTodosLosProgrammingLevel() throws Exception {
		return programmingLevelDAO.consultarTodosLosProgrammingLevel();
	}

	
	
}
