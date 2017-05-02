package spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import spring.model.Request;

@Repository
public class RequestDAOImpl implements RequestDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(RequestDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf1){
		this.sessionFactory = sf1;
	}
	
	@Override
	public void publishRequest(Request r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
		logger.info("Request saved successfully, Request Details="+r);
	}
	
	@Override
	public void deleteOldRequest(int requestId) {
		Session session = this.sessionFactory.getCurrentSession();
		Request r = (Request) session.load(Request.class, new Integer(requestId));
		if(null != r){
			session.delete(r);
		}
		logger.info("Request deleted successfully, request details="+r);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> listRequest() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Request> requestList = session.createQuery("from Request").list();
		for(Request r : requestList){
			logger.info("Request List::"+r);
		}
		return requestList;
	}
	
	@Override
	public Request getRequestById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Request r = (Request) session.load(Request.class, new Integer(id));
		logger.info("Request loaded successfully, Request details="+r);
		return r;
	}
	
	@Override
	public void editRequest(Request r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(r);
		logger.info("Request updated successfully, Request Details="+r);
	}

	@Override
	public String validateRequest(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Request r = (Request) session.load(Request.class, new Integer(id));
		logger.info("Request validated");
		String result = "Owner id" + r.getOwnerId() + " has " + r.getPetType()+ "of breed " + r.getPetBreed() 
		+ "to be taken care from" + r.getFromDate() + "to" + r.getToDate();
		return result;
	}

}