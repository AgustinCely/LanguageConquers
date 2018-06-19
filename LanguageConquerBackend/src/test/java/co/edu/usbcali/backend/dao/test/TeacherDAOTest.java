package co.edu.usbcali.backend.dao.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.ITeacherDAO;
import co.edu.usbcali.backend.modelo.Teacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeacherDAOTest {
	
	public static final Logger log=LoggerFactory.getLogger(TeacherDAOTest.class);
	
	@Autowired
	private ITeacherDAO teacherDAO;
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void aTestCrear() throws java.text.ParseException {
		assertNotNull(teacherDAO);
		//Integer id =2;
		Teacher teacher= new Teacher();
		//teacher.setIdTeacher(id);
		teacher.setNameUser("Pepe");
		teacher.setLastnameUser("Miraflores");
		teacher.setUsername("olipepe");
		teacher.setPasswordUser("1234");
		teacher.setGenderUser('M');
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mmm-dd");
		String dateInString="1990-05-11";
		try {
			
			Date date =formatter.parse(dateInString);
			teacher.setBirthdateUser(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		teacher.setEmailUser("melasuda@hotmail.com");
		
		teacherDAO.crear(teacher);
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void bTestConsultarPorId() {
		assertNotNull(teacherDAO);
		
		Teacher teacher = teacherDAO.consultarPorId(2);
		assertNotNull(teacher);
		log.info("id:"+teacher.getIdTeacher());
		log.info("Nombre: "+teacher.getNameUser()+" "+teacher.getLastnameUser());
		
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void cTestModificar() {
		assertNotNull(teacherDAO);
		
		Teacher teacher = teacherDAO.consultarPorId(2);
		assertNotNull(teacher);
		teacher.setPasswordUser("holi12");
		
	}
	
	@Test
	@Transactional(readOnly=false)
	public void dTestConsultarTodos() {
		assertNotNull(teacherDAO);
		
		List<Teacher> losTeachers=teacherDAO.consultarTodos();
		for (Teacher teacher : losTeachers) {
			log.info("Id: "+teacher.getIdTeacher());
			log.info("Nombre: "+teacher.getNameUser());
		}
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Rollback(false)
	public void eTestBorrar() {
		assertNotNull(teacherDAO);
		
		Teacher teacher = teacherDAO.consultarPorId(2);
		assertNotNull(teacher);
		teacherDAO.eliminar(teacher);
		
	}
	

}
