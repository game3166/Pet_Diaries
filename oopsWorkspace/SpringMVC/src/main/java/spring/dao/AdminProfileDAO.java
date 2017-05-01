package spring.dao;

import java.util.List;

import spring.model.AdminProfile;
import spring.model.User;

public interface AdminProfileDAO {
	
	public boolean addAdminProfile(AdminProfile p);
	public void updateAdminProfile(AdminProfile p);
	public List<AdminProfile> listAdminProfiles();
	public AdminProfile getAdminProfileById(int id);
	public void removeAdminProfile(int id);
	public boolean validateAdminProfile(AdminProfile p);
	public int getAdminProfileCount(int id);
	public boolean isContactInfoSet(int id);
	public List<String> getExpiredEmails();
	public void deleteExpiredProfiles();
	public User getUserById(int id);
	public void updateUser(User p);
	public void removeUser(int id);
	public void removePet(int id);
	public void removeContactInfo(int id);
}