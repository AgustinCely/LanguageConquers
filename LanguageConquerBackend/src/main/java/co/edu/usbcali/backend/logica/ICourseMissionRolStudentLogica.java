package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMissionRolStudent;

public interface ICourseMissionRolStudentLogica {
	
	public void crearCourseMissionRolStudent(CourseMissionRolStudent entity) throws Exception;
	public void modificarCourseMissionRolStudent(CourseMissionRolStudent entity) throws Exception;
	public void eliminarCourseMissionRolStudent(CourseMissionRolStudent entity) throws Exception;
	public CourseMissionRolStudent consultarPorIdCourseMissionRolStudent(Integer id) throws Exception;
	public List<CourseMissionRolStudent> consultarTodosLosCourseMissionRolStudent() throws Exception;
}
