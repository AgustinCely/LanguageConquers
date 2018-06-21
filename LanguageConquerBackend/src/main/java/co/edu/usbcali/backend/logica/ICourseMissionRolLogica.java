package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMissionRol;

public interface ICourseMissionRolLogica {

	
	public void crearCourseMissionRol(CourseMissionRol entity) throws Exception;
	public void modificarCourseMissionRol(CourseMissionRol entity) throws Exception;
	public void eliminarCourseMissionRol(CourseMissionRol entity) throws Exception;
	public CourseMissionRol consultarPorIdCourseMissionRol(Integer id) throws Exception;
	public List<CourseMissionRol> consultarTodosLosCourseMissionRol() throws Exception;
}
