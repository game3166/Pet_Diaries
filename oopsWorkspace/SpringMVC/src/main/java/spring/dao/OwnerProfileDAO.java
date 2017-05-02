package spring.dao;
import java.util.List;

import spring.model.OwnerProfile;
import spring.model.User;

public interface OwnerProfileDAO {
	
	public boolean addOwnerProfile(OwnerProfile p);
	public void updateOwnerProfile(OwnerProfile p);
	public List<OwnerProfile> listOwnerProfiles();
	public OwnerProfile getOwnerProfileById(int id);
	public void removeOwnerProfile(int id);
	public boolean validateOwnerProfile(OwnerProfile p);
	public int getOwnerProfileCount(int id);
	public boolean isContactInfoSet(int id);
	public List<User> listCaretakers(int userId);
	public User getUserById(int id);
	
}