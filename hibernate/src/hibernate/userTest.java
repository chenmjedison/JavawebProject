package hibernate;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class userTest {
	private SessionFactory sessionFactory;
	public userTest(){
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public void save(Users u){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
	}
	public void showUsers(String username){
		String hql="from Users u where u.username= '"+username+"'";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		Iterator it=query.list().iterator();
		while(it.hasNext()){
			Users u=(Users)it.next();
			System.out.println(u.getId()+"\t"+u.getUsername()+"\t"+u.getNickname());
		}
	}
	public static void main(String[] args){
		userTest test=new userTest();
		Users u=new Users("½Ü¿Ë","123","jack");
		test.save(u);
		test.showUsers("½Ü¿Ë");
	}
}
