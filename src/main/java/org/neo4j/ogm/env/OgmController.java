package org.neo4j.ogm.env;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.neo4j.ogm.env.domain.User;
import org.neo4j.ogm.session.Session;

@Path("simple")
public class OgmController {

	@Inject
	private OgmSessionBean ogmSessionBean;

	@GET
	@Path("list")
	public String hello() {

		Session session = ogmSessionBean.getSessionFactory().openSession();

		return session.loadAll(User.class).toString();
	}

	@GET
	@Path("create")
	public String hello2() {
		Session session = ogmSessionBean.getSessionFactory().openSession();
		session.save(new User("Me", 33));

		return "saved";
	}

}
