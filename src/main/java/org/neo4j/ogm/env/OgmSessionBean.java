package org.neo4j.ogm.env;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.env.domain.User;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

//@ApplicationScoped
@Singleton
@Startup
public class OgmSessionBean {

	private final SessionFactory sessionFactory;

	public OgmSessionBean() {
		Configuration configuration = new Configuration.Builder()
				.credentials("neo4j", "secret")
				.uri("bolt://localhost:7687")
				.build();

		sessionFactory = new SessionFactory(configuration, "org.neo4j.ogm.env.domain");
	}

	@PostConstruct
	public void init(){
		Session session = getSessionFactory().openSession();
		session.save(new User("Me", 33));
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
