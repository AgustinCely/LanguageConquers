package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.ITeacherDAO;
import co.edu.usbcali.backend.modelo.Teacher;

@Scope("singleton")
@Service("teacherLogica")
public class TeacherLogica implements ITeacherLogica{

	@Autowired
	private ITeacherDAO teacherDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearTeacher(Teacher entity) throws Exception {
		if(entity == null) {
			throw new Exception("El docente es nulo");
		}
		if(entity.getNameUser()==null || entity.getNameUser().trim().equals("")==true) {
			throw new Exception("El nombre es nulo");
		}
		if(entity.getLastnameUser()==null || entity.getLastnameUser().trim().equals("")==true) {
			throw new Exception("El apellido es nulo");
		}
		if(entity.getGenderUser()==null || entity.getGenderUser().toString().equals("")==true) {
			throw new Exception("El genero es nulo");
		}
		if(entity.getEmailUser()==null || entity.getEmailUser().trim().equals("")==true) {
			throw new Exception("El Email es nulo");
		}
		if(entity.getUsername()== null || entity.getUsername().trim().equals("")==true) {
			throw new Exception("El nombre de usuario es nulo");
		}
		if(entity.getPasswordUser()==null || entity.getPasswordUser().trim().equals("")==true) {
			throw new Exception("La contraseña es nulo");
		}
		if(entity.getBirthdateUser()==null || entity.getBirthdateUser().toString().equals("")==true) {
			throw new Exception("la fecha de nacimiento es nulo");
		}
		teacherDAO.crear(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarTeacher(Teacher entity) throws Exception {
		if(entity == null) {
			throw new Exception("El docente es nulo");
		}
		if(entity.getNameUser()==null || entity.getNameUser().trim().equals("")==true) {
			throw new Exception("El nombre es nulo");
		}
		if(entity.getLastnameUser()==null || entity.getLastnameUser().trim().equals("")==true) {
			throw new Exception("El apellido es nulo");
		}
		if(entity.getGenderUser()==null || entity.getGenderUser().toString().equals("")==true) {
			throw new Exception("El genero es nulo");
		}
		if(entity.getEmailUser()==null || entity.getEmailUser().trim().equals("")==true) {
			throw new Exception("El Email es nulo");
		}
		if(entity.getUsername()== null || entity.getUsername().trim().equals("")==true) {
			throw new Exception("El nombre de usuario es nulo");
		}
		if(entity.getPasswordUser()==null || entity.getPasswordUser().trim().equals("")==true) {
			throw new Exception("La contraseña es nulo");
		}
		if(entity.getBirthdateUser()==null || entity.getBirthdateUser().toString().equals("")==true) {
			throw new Exception("la fecha de nacimiento es nulo");
		}
		
		teacherDAO.modificar(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarTeacher(Teacher entity) throws Exception {
		if(entity==null) {
			throw new Exception("El docente es nulo");
		}
		if(entity.getIdTeacher()==0) {
			throw new Exception("El id es nulo");
		}
		
		teacherDAO.eliminar(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Teacher consultarPorIdTeacher(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return teacherDAO.consultarPorId(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Teacher> consultarTodosLosTeacher() throws Exception {
		return teacherDAO.consultarTodos();
	}

	
	
}
