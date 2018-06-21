package co.edu.usbcali.backend.logica.test;

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

import co.edu.usbcali.backend.logica.ITeacherLogica;
import co.edu.usbcali.backend.modelo.Teacher;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeacherLogicaTest {
	
	public static final Logger log=LoggerFactory.getLogger(TeacherLogicaTest.class);
	
	@Autowired
	private ITeacherLogica teacherLogica;

	@Test
	@Rollback(false)
	public void aTestCrear() throws Exception {
		assertNotNull(teacherLogica);
		
		Teacher teacher = new Teacher();
		teacher.setNameUser("Cristian");
		teacher.setUsername("Holipepe");
		teacher.setLastnameUser("Lopez Perez");
		teacher.setGenderUser('M');
		teacher.setPasswordUser("1234");
		teacher.setEmailUser("todostienen@hotmail.com");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mmm-dd");
		String dateInString="1990-05-11";
		try {
			
			Date date =formatter.parse(dateInString);
			teacher.setBirthdateUser(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		teacherLogica.crearTeacher(teacher);
		
	}
	
	@Test
	public void bTestConsultarPorId() throws Exception {
		assertNotNull(teacherLogica);
		
		Teacher teacher = teacherLogica.consultarPorIdTeacher(2);
		assertNotNull(teacher);
		log.info("id: "+teacher.getIdTeacher());
		log.info("Nombre "+teacher.getNameUser());
		log.info("Apellido "+teacher.getLastnameUser());
		
	}
	
	@Test
	@Rollback(false)
	public void cTestModificar() throws Exception {
		assertNotNull(teacherLogica);
		
		Teacher teacher = teacherLogica.consultarPorIdTeacher(2);
		assertNotNull(teacher);
		teacher.setUsername("melasudatodos");
		
		teacherLogica.modificarTeacher(teacher);
		
	}
	
	@Test
	public void dTestConsultarTodo() throws Exception {
		assertNotNull(teacherLogica);
		
		List<Teacher> losTeacher=teacherLogica.consultarTodosLosTeacher();
		
		for (Teacher teacher : losTeacher) {
			log.info("Id "+teacher.getIdTeacher());
			log.info("Nombre " +teacher.getNameUser());
		}
		
	}
	
	@Test
	@Rollback(false)
	public void eTestEliminar() throws Exception {
		assertNotNull(teacherLogica);
		Teacher teacher = teacherLogica.consultarPorIdTeacher(2);
		assertNotNull(teacher);
		
		teacherLogica.eliminarTeacher(teacher);
		
	}

}
