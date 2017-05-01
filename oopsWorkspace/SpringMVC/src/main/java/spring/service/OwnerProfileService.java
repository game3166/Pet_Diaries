package spring.service;

import java.util.List;

import spring.model.OwnerProfile;
import spring.model.User;

public interface OwnerProfileService
{
	public boolean addOwnerProfile(OwnerProfile p);
	public boolean validateOwnerProfile(OwnerProfile p);
	public void updateOwnerProfile(OwnerProfile p);
	public List<OwnerProfile> listOwnerProfiles();
	public OwnerProfile getOwnerProfileById(int id);
	public void removeOwnerProfile(int id);
	public int getOwnerProfileCount(int id);
	public List<User> listCaretakers(int userId);
	public boolean isContactInfoSet(int id);
}