package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.usbcali.backend.dao.ICourseMissionRolDAO;
import co.edu.usbcali.backend.modelo.CourseMission;
import co.edu.usbcali.backend.modelo.CourseMissionRol;
import co.edu.usbcali.backend.modelo.Rol;

public class CourseMissionRolLogica implements ICourseMissionRolLogica{

		
	@Autowired
	private IRolLogica rolLogica;
	
	@Autowired
	private ICourseMissionLogica courseMissionLogica;
	
	@Autowired
	private ICourseMissionRolDAO courseMissionRolDAO;
	
	
	@Override
	public void crearCourseMissionRol(CourseMissionRol entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionRol es nulo");
		}
		
		CourseMission courseMission = courseMissionLogica.consultarPorIdCourseMission(entity.getCourseMission().getIdCourseMission());
		if(courseMission==null) {
			throw new Exception("El coursemission es nulo");
		}
		Rol rol = rolLogica.consultarPorIdRol(entity.getRol().getIdRol());
		if(rol == null) {
			throw new Exception("El rol es nulo");
		}
		
		courseMissionRolDAO.crearCourseMissionRol(entity);
	}

	@Override
	public void modificarCourseMissionRol(CourseMissionRol entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionRol es nulo");
		}
		
		CourseMission courseMission = courseMissionLogica.consultarPorIdCourseMission(entity.getCourseMission().getIdCourseMission());
		if(courseMission==null) {
			throw new Exception("El coursemission es nulo");
		}
		Rol rol = rolLogica.consultarPorIdRol(entity.getRol().getIdRol());
		if(rol == null) {
			throw new Exception("El rol es nulo");
		}
		
		courseMissionRolDAO.modificarCourseMissionRol(entity);
	}

	@Override
	public void eliminarCourseMissionRol(CourseMissionRol entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionRol es nulo");
		}
		if(entity.getIdCourseMissionRol()==0) {
			throw new Exception("El id es nulo");
		}
		
		courseMissionRolDAO.eliminarCourseMissionRol(entity);
	}

	@Override
	public CourseMissionRol consultarPorIdCourseMissionRol(Integer id) throws Exception {
		if(id == 0) {
			throw new Exception("El id es nulo");
		}
		return courseMissionRolDAO.consultarPorIdCourseMissionRol(id);
	}

	@Override
	public List<CourseMissionRol> consultarTodosLosCourseMissionRol() throws Exception {
		return courseMissionRolDAO.consultarTodosLosCourseMissionRol();
	}

	
	
}
