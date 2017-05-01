package spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.AdminProfileDAO;
import spring.model.AdminProfile;

@Service
public class AdminProfileServiceImpl implements AdminProfileService {
	
	private AdminProfileDAO adminProfileDAO;

	public void setAdminProfileDAO(AdminProfileDAO adminProfileDAO) {
		this.adminProfileDAO = adminProfileDAO;
	}

	@Override
	@Transactional
	public boolean addAdminProfile(AdminProfile p) {
		boolean error=false;
		error=this.adminProfileDAO.addAdminProfile(p);
		return error;
	}

	@Override
	@Transactional
	public void updateAdminProfile(AdminProfile p) {
		this.adminProfileDAO.updateAdminProfile(p);
	}

	@Override
	@Transactional
	public List<AdminProfile> listAdminProfiles() {
		return this.adminProfileDAO.listAdminProfiles();
	}

	@Override
	@Transactional
	public boolean validateAdminProfile(AdminProfile p)
	{
		return this.adminProfileDAO.validateAdminProfile(p);
	}
	@Override
	@Transactional
	public AdminProfile getAdminProfileById(int id) {
		return this.adminProfileDAO.getAdminProfileById(id);
	}

	@Override
	@Transactional
	public void removeAdminProfile(int id) {
		this.adminProfileDAO.removeAdminProfile(id);
	}
	
	@Override
	@Transactional
	public int getAdminProfileCount(int id)
	{
		return this.adminProfileDAO.getAdminProfileCount(id);
	}
	
	@Override
	@Transactional
	public boolean isContactInfoSet(int id)
	{
		return this.adminProfileDAO.isContactInfoSet(id);
	}
	
	@Override
	@Transactional
	public List<String> getExpiredEmails()
	{
		return this.adminProfileDAO.getExpiredEmails();
	}
	
	@Override
	@Transactional
	public void deleteExpiredProfiles()
	{
		this.adminProfileDAO.deleteExpiredProfiles();
	}
}