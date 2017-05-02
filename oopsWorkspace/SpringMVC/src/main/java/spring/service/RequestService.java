package spring.service;

import java.util.List;


import spring.model.Request;

public interface RequestService {

	public void publishRequest(Request r);
	public void deleteOldRequest(int requestId);
	public List<Request> listRequest();
	public Request getRequestById(int id);
	public void editRequest(Request r);
	public String validateRequest(int id);
}