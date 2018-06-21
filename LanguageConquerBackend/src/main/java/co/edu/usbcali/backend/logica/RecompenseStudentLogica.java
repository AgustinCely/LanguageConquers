package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IRecompenseStudentDAO;
import co.edu.usbcali.backend.modelo.Recompense;
import co.edu.usbcali.backend.modelo.RecompenseStudent;
import co.edu.usbcali.backend.modelo.Student;

@Scope("singleton")
@Service("recompenseStudentLogica")
public class RecompenseStudentLogica implements IRecompenseStudentLogica{

	@Autowired
	private IRecompenseStudentDAO recompenseStudentDAO;
	
	@Autowired
	private IRecompenseLogica recompenseLogica;
	
	@Autowired
	private IStudenLogica studentLogica;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearRecompenseStudent(RecompenseStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El recompenseStudent es nulo");
		}
		Recompense recompense = recompenseLogica.consultarPorIdRecompense(entity.getRecompense().getIdRecompense());
		if(recompense == null) {
			throw new Exception("La recompense es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		recompenseStudentDAO.crearRecompenseStudent(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarRecompenseStudent(RecompenseStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El recompenseStudent es nulo");
		}
		Recompense recompense = recompenseLogica.consultarPorIdRecompense(entity.getRecompense().getIdRecompense());
		if(recompense == null) {
			throw new Exception("La recompense es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		recompenseStudentDAO.modificarRecompenseStudent(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarRecompenseStudent(RecompenseStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El recompenseStudent es nulo");
		}
		if(entity.getIdRecompenseStudent()==0) {
			throw new Exception("El id es nulo");
		}
		
		recompenseStudentDAO.eliminarRecompenseStudent(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public RecompenseStudent consultarPorIdRecompenseStudent(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return recompenseStudentDAO.consultarPorIdRecompenseStudent(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RecompenseStudent> consultarTodosLosRecompenseStudent() throws Exception {
		return recompenseStudentDAO.consultarTodosLosRecompenseStudent();
	}

	
	
}
