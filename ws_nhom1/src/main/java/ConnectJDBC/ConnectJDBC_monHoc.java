package ConnectJDBC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Util.hibernateUtil;
import model.khoaHoc;
import model.monHoc;
import model.user;

public class ConnectJDBC_monHoc {
	public static void main(String[] args) {
		SessionFactory sessionFactory = hibernateUtil.buildSessionFactory();
		try {
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction ts = session.beginTransaction();
					
					monHoc mh1 = new monHoc("mh01", "Khóa học HTML/CSS", "kh01");
					monHoc mh2 = new monHoc("mh02", "Khóa học JavaScript", "kh01");
					monHoc mh3 = new monHoc("mh03", "Khóa học PHP", "kh01");
					monHoc mh4 = new monHoc("mh04", "Khóa học Flutter & Dart", "kh02");
					monHoc mh5 = new monHoc("mh05", "Khóa học IOS", "kh02");
					monHoc mh6 = new monHoc("mh06", "Khóa học Android", "kh02");
					monHoc mh7 = new monHoc("mh07", "Khóa học Kotlin", "kh03");
					monHoc mh8 = new monHoc("mh08", "Khóa học Python", "kh03");
					monHoc mh9 = new monHoc("mh09", "Khóa học Java", "kh03");
					
					
					session.save(mh1);
					session.save(mh2);
					session.save(mh3);
					session.save(mh4);
					session.save(mh5);
					session.save(mh6);
					session.save(mh7);
					session.save(mh8);
					session.save(mh9);
					
					
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
