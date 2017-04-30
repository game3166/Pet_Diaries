package spring.model;


import spring.model.User;
import spring.service.ProfileFactoryService;


public abstract class Profile extends User{
	void openChatBox()
	{
		//NULL
	}
	void sendMessage()
	{
		//NULL
	}
	abstract void displayError();
	abstract void displaySuccess();
	
}