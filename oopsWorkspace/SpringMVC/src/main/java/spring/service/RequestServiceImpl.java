
package spring.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.RequestDAO;
import spring.model.Request;


@Service("requestService")
public class RequestServiceImpl implements RequestService{

    private RequestDAO requestDAO;
    
	public void setRequestDAO(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}
		
	@Override
	@Transactional
	public void publishRequest(Request r) {
		this.requestDAO.publishRequest(r);
	}
	
	/*@Override
	@Transactional
	public void notifyAcceptedRequest(int id) {
		this.requestDAO.notifyAcceptedRequest(id);
	}
	
	@Override
	@Transactional
	public boolean validateRequest(int id) {
		return this.requestDAO.validateRequest(id);
	}
		
	@Override
	@Transactional
	public void notifyInvalidRequest() {
		this.requestDAO.notifyInvalidRequest();
		
	}*/
	
	@Override
	@Transactional
	public void deleteOldRequest(int requestId) {
		this.requestDAO.deleteOldRequest(requestId);
		
	}
	
	@Override
	@Transactional
	public List<Request> listRequest() {
		return this.requestDAO.listRequest();
	}
	
	@Override
	@Transactional
	public Request getRequestById(int id) {
		return this.requestDAO.getRequestById(id);
	}
	
	@Override
	@Transactional
	public void editRequest(Request r) {
		this.requestDAO.editRequest(r);
	}
	
	@Override
	@Transactional
	public String validateRequest(int id) {
		return this.requestDAO.validateRequest(id);
	}
	
	/*@Override
	@Transactional
	public void sendFeedback(String feedback, int id) {
		this.requestDAO.sendFeedback(feedback, id);
		
	}*/
	
	
	
}