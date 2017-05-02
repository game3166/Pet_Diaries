package spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.model.OwnerProfile;
import spring.model.User;

@Repository
public class OwnerProfileDAOImpl implements OwnerProfileDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerProfileDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public boolean addOwnerProfile(OwnerProfile p) {
		boolean error=false;
		Session session = this.sessionFactory.getCurrentSession();
		
		try
		{
			session.save(p);
			//tx.commit();
			System.out.println("OwnerProfile DAO Impl Added ownerProfile without exceptions");
		}
		catch(Exception e)
		{
			session.clear();
			System.out.println(e.getCause());
			error=true;
		}
		
		return error;
		
	//	logger.info("OwnerProfile saved successfully, OwnerProfile Details="+p);
	}

	@Override
	public void updateOwnerProfile(OwnerProfile p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("OwnerProfile updated successfully, OwnerProfile Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OwnerProfile> listOwnerProfiles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<OwnerProfile> ownerProfilesList = session.createQuery("from OwnerProfile").list();
		for(OwnerProfile p : ownerProfilesList){
			logger.info("OwnerProfile List::"+p);
		}
		return ownerProfilesList;
	}

	@Override
	public OwnerProfile getOwnerProfileById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		OwnerProfile p = (OwnerProfile) session.load(OwnerProfile.class, new Integer(id));
		logger.info("OwnerProfile loaded successfully, OwnerProfile details="+p);
		return p;
	}

	@Override
	public void removeOwnerProfile(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		OwnerProfile p = (OwnerProfile) session.load(OwnerProfile.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("OwnerProfile deleted successfully, ownerProfile details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateOwnerProfile(OwnerProfile p)
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<OwnerProfile> ownerProfilesList = session.createQuery("from OwnerProfile").list();
		
	
	//	System.out.println("OwnerProfile DAO Impl doesn't exist");
		return false;
	}
	
	@Override
	public int getOwnerProfileCount(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select count(*) from OwnerProfile where ownerProfileId="+String.valueOf(id);
		int count = ((Long) session.createQuery(hql).uniqueResult()).intValue();
		return count;
	}
	
	@Override
	public boolean isContactInfoSet(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select count(ownerProfileId) from ContactInfo where ownerProfileId="+String.valueOf(id);
		int count = ((Long) session.createQuery(hql).uniqueResult()).intValue();

		if(count>0)
			return true;
		else
			return false;
			
	}
	
	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details="+p);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listCaretakers(int userId)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select caretakerId from History where ownerId="+String.valueOf(userId);
		List<Integer> caretakerIdList=  session.createQuery(hql).list();
		List<User> ul=new ArrayList<User>();
		for(int i:caretakerIdList)
		{
			User u=getUserById(i);
			ul.add(u);
		}
		return ul;
	}

	
	
}