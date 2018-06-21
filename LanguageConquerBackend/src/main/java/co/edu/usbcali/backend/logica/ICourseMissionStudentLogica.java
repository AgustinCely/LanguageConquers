package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMissionStudent;

public interface ICourseMissionStudentLogica {

	public void crearCourseMissionStudent(CourseMissionStudent entity) throws Exception;
	public void modificarCourseMissionStudent(CourseMissionStudent entity) throws Exception;
	public void eliminarCourseMissionStudent(CourseMissionStudent entity) throws Exception;
	public CourseMissionStudent consultarPorIdCourseMissionStudent(Integer id) throws Exception;
	public List<CourseMissionStudent> consultarTodosLosCourseMissionStudent() throws Exception;
	
}
