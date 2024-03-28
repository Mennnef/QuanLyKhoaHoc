package ConnectJDBC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Util.hibernateUtil;
import model.khoaHoc;
import model.user;

public class ConnectJDBC_khoaHoc {
	public static void main(String[] args) {
		SessionFactory sessionFactory = hibernateUtil.buildSessionFactory();
		try {
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction ts = session.beginTransaction();
					
					khoaHoc kh1 = new khoaHoc("kh01", "Web Designer");
					khoaHoc kh2 = new khoaHoc("kh02", "Lập Trình Di Động");
					khoaHoc kh3 = new khoaHoc("kh03", "Lập Trình cơ bản");
					
					session.save(kh1);
					session.save(kh2);
					session.save(kh3);
					
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
