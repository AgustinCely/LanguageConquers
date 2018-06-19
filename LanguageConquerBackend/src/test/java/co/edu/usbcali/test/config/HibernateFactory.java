package co.edu.usbcali.test.config;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.modelo.Teacher;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class HibernateFactory {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional(readOnly=true)
	public void test() {
		assertNotNull(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		
		Teacher teacher=session.get(Teacher.class, 1);
		
		assertNotNull(teacher);
	}

}
