
package bdlavanderia.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory	sessionFactory	= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("Criao inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
