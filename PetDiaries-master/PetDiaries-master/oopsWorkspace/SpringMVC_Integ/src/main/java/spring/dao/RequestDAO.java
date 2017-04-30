package spring.dao;

import java.util.List;


import spring.model.Request;

public interface RequestDAO {
	
	public void publishRequest(Request r);
	public List<Request> listRequest();
	public void deleteOldRequest(int requestId);
	public Request getRequestById(int id);
	public void editRequest(Request r);
	public String validateRequest(int id);

}