package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IRolStudentDAO;
import co.edu.usbcali.backend.modelo.Rol;
import co.edu.usbcali.backend.modelo.RolStudent;
import co.edu.usbcali.backend.modelo.Student;


@Scope("singleton")
@Service("rolStudentLogica")
public class RolStudentLogica implements IRolStudentLogica{

	@Autowired
	private IRolLogica rolLogica;
	
	@Autowired
	private IStudenLogica studentLogica;
	
	@Autowired
	private IRolStudentDAO rolStudentDAO; 
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearRolStudent(RolStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El rolstudent es nulo");
		}
		Rol rol = rolLogica.consultarPorIdRol(entity.getRol().getIdRol());
		if(rol==null) {
			throw new Exception("El rol es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		rolStudentDAO.crearRolStudent(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarRolStudent(RolStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El rolstudent es nulo");
		}
		Rol rol = rolLogica.consultarPorIdRol(entity.getRol().getIdRol());
		if(rol==null) {
			throw new Exception("El rol es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		rolStudentDAO.modificarRolStudent(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarRolStudent(RolStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El rolstudent es nulo");
		}
		if(entity.getIdRolStudent()==0) {
			throw new Exception("El id es nulo");
		}
		
		rolStudentDAO.eliminarRolStudent(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public RolStudent consultarPorIdRolStudent(Integer id) throws Exception {
		if(id ==0) {
			throw new Exception("El id es nulo");
		}
		return rolStudentDAO.consultarPorIdRolStudent(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RolStudent> consultarTodoslosRolStudent() throws Exception {
		return rolStudentDAO.consultarTodosLosRolStudent();
	}
	
	
	
}
