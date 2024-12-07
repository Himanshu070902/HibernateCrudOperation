package in.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.entity.User;

public class SelectOperation {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("/in/configure/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			User user = session.get(User.class, 1);
			if (user != null) {
				System.out.println("Name: " + user.getName());
				System.out.println("Email: " + user.getEmail());
				System.out.println("Password: " + user.getPassword());
				System.out.println("Gender: " + user.getGender());
				System.out.println("City: " + user.getCity());
			} else {
				System.out.println("User not found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			session.close();
			sessionFactory.close();
		}

	}

}
