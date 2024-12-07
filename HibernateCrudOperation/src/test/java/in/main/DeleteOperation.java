package in.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.entity.User;

public class DeleteOperation {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/in/configure/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		try {

			User user = new User();
			user.setId(6);
			session.delete(user);
			transaction.commit();
			System.out.println("delete datasuccess Fully....");

		} catch (Exception e) {
			System.out.println("error in database..");
		}
	}

}
