package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.Teacher;

public interface ITeacherLogica {
	
	public void crearTeacher(Teacher entity) throws Exception;
	public void modificarTeacher(Teacher entity) throws Exception;
	public void eliminarTeacher(Teacher entity)throws Exception;
	public Teacher consultarPorIdTeacher(Integer id)throws Exception;
	public List<Teacher> consultarTodosLosTeacher() throws Exception;
	
}
