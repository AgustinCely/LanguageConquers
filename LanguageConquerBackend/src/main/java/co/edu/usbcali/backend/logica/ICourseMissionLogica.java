package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMission;

public interface ICourseMissionLogica {

	public void crearCourseMission(CourseMission entity) throws Exception;
	public void modificarCourseMission(CourseMission entity) throws Exception;
	public void eliminarCourseMission(CourseMission entity) throws Exception;
	public CourseMission consultarPorIdCourseMission(Integer id) throws Exception;
	public List<CourseMission> consultarTodosLosCourseMission() throws Exception;
}
