package co.edu.usbcali.test.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SessionFactoryTest {

	@Autowired
	private LocalSessionFactoryBean sessionFactory;
	
	@Test
	public void test() {
		assertNotNull(sessionFactory);
	}

}
