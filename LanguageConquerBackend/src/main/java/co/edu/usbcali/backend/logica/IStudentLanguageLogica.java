package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.StudentLanguage;

public interface IStudentLanguageLogica {

	public void crearStudentLanguage(StudentLanguage entity) throws Exception;
	public void modificarStudentLanguage(StudentLanguage entity) throws Exception;
	public void eliminarStudentLanguage(StudentLanguage entity) throws Exception;
	public StudentLanguage consultarPorIdStudentLanguage(Integer id) throws Exception;
	public List<StudentLanguage> consultarTodosLosStudentLanguage() throws Exception;
	
}
