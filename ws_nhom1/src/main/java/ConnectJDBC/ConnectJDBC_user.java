package ConnectJDBC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Util.hibernateUtil;
import model.khoaHoc;
import model.user;

public class ConnectJDBC_user {
	public static void main(String[] args) {
		SessionFactory sessionFactory = hibernateUtil.buildSessionFactory();
		try {
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction ts = session.beginTransaction();
					
					user u = new user("admin", "admin", "admin");
					session.save(u);
					
					ts.commit();
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
