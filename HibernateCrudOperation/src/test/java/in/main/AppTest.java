package in.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.entity.User;

public class AppTest {
	public static void main(String[] args) {
		User user = new User();
		user.setName("Muskan");
		user.setEmail("Muskan@gmail.com");
		user.setPassword("4321");
		user.setGender("female");
		user.setCity("Bhopal");

		Configuration cfg = new Configuration();
		cfg.configure("/in/configure/hibernate.cfg.xml");
		System.out.println("Create Configuration successful...");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		System.out.println("sessionFactory create success...");

		Session session = sessionFactory.openSession();
		System.out.println("session create success...");

		Transaction transaction = session.beginTransaction();

		System.out.println("Data insert success..." + session.save(user));
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
