package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.Teacher;

public interface ITeacherDAO {
	
	public void crear(Teacher entity);
	public void modificar(Teacher entity);
	public void eliminar(Teacher entity);
	public Teacher consultarPorId(Integer id);
	public List<Teacher> consultarTodos();
}
