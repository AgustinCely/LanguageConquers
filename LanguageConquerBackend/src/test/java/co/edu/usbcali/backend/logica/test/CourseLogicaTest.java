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

import co.edu.usbcali.backend.logica.ICourseLogica;
import co.edu.usbcali.backend.logica.ITeacherLogica;
import co.edu.usbcali.backend.modelo.Course;
import co.edu.usbcali.backend.modelo.Teacher;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseLogicaTest {
	
	public static final Logger log=LoggerFactory.getLogger(CourseLogicaTest.class);
	
	@Autowired
	private ICourseLogica courseLogica;
	
	@Autowired
	private ITeacherLogica teacherLogica;
	

	@Test
	@Rollback(false)
	public void aTestCrear() throws Exception{
		assertNotNull(courseLogica);
		
		Course course = new Course();
		course.setNameCourse("Introduccion a la programacion noobs");
		course.setPasswordCourse("puto el que lo lea");
		course.setNumberStudent(40);
		course.setQuantityLanguage(2);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mmm-dd");
		String dateInString="2018-06-19";
		String date2InString="2018-10-19";
		
		try {
			Date date =formatter.parse(dateInString);
			course.setStartCourse(date);
			Date dateEnd = formatter.parse(date2InString);
			course.setEndCourse(dateEnd);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Teacher teacher = teacherLogica.consultarPorIdTeacher(1);
		assertNotNull(teacher);
		course.setTeacher(teacher);
		
		courseLogica.crearCourse(course);
		
		
	}
	
	@Test
	public void bTestConsultarPorId() throws Exception{
		assertNotNull(courseLogica);
		
		Course course = courseLogica.consultarPorId(1);
		assertNotNull(course);
		
		log.info("ID "+course.getIdCourse());
		log.info("Nombre curso "+course.getNameCourse());
		log.info("profesor "+course.getTeacher().getNameUser());
		
		
	}
	
	@Test
	@Rollback(false)
	public void cTestModificar() throws Exception{
		assertNotNull(courseLogica);
		
		Course course = courseLogica.consultarPorId(1);
		assertNotNull(course);
		
		course.setNameCourse("me la pela todos uds putos noobs");
		course.setNumberStudent(30);
		
		courseLogica.modificarCourse(course);
		
	}
	
	@Test
	public void dTestConsultarTodo() throws Exception{
		assertNotNull(courseLogica);
		
		List<Course> losCourse = courseLogica.consultarTodosLosCourse();
		
		for (Course course : losCourse) {
			
			log.info("Id "+course.getIdCourse());
			log.info("Nombre curso "+course.getNameCourse());
			
		}
		
	}
	
	@Test
	@Rollback(false)
	public void eTestEliminar() throws Exception{
		assertNotNull(courseLogica);
		
		Course course = courseLogica.consultarPorId(1);
		assertNotNull(course);
		
		courseLogica.eliminarCourse(course);
		
	}

}
