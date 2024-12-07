package in.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.entity.User;

public class UpdateOperation {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/in/configure/hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		try {
			User user = session.get(User.class, 2);

			user.setPassword("meena");
			user.setGender("female");
			session.saveOrUpdate(user);
			tr.commit();
			System.out.println("Data Update SuccessFully...");
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}

	}

}
