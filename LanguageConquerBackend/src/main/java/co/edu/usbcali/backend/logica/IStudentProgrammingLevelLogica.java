package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.StudentProgrammingLevel;

public interface IStudentProgrammingLevelLogica {
	
	public void crearStudentProgrammingLevel(StudentProgrammingLevel entity) throws Exception;
	public void modificarStudentProgrammingLevel(StudentProgrammingLevel entity) throws Exception;
	public void eliminarStudentProgrammingLevel(StudentProgrammingLevel entity) throws Exception;
	public StudentProgrammingLevel consultarPorIdStudentProgrammingLevel(Integer id) throws Exception;
	public List<StudentProgrammingLevel> consultarTodoLosStudentProgrammingLevel() throws Exception ;
}
