package spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.model.CaretakerProfile;

@Repository
public class CaretakerProfileDAOImpl implements CaretakerProfileDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CaretakerProfileDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public boolean addCaretakerProfile(CaretakerProfile p) {
		boolean error=false;
		Session session = this.sessionFactory.getCurrentSession();
		
		try
		{
			session.save(p);
			//tx.commit();
			System.out.println("CaretakerProfile DAO Impl Added caretakerProfile without exceptions");
		}
		catch(Exception e)
		{
			session.clear();
			System.out.println(e.getCause());
			error=true;
		}
		
		return error;
		
	//	logger.info("CaretakerProfile saved successfully, CaretakerProfile Details="+p);
	}

	@Override
	public void updateCaretakerProfile(CaretakerProfile p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("CaretakerProfile updated successfully, CaretakerProfile Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CaretakerProfile> listCaretakerProfiles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<CaretakerProfile> caretakerProfilesList = session.createQuery("from CaretakerProfile").list();
		for(CaretakerProfile p : caretakerProfilesList){
			logger.info("CaretakerProfile List::"+p);
		}
		return caretakerProfilesList;
	}

	@Override
	public CaretakerProfile getCaretakerProfileById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		CaretakerProfile p = (CaretakerProfile) session.load(CaretakerProfile.class, new Integer(id));
		logger.info("CaretakerProfile loaded successfully, CaretakerProfile details="+p);
		return p;
	}

	@Override
	public void removeCaretakerProfile(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		CaretakerProfile p = (CaretakerProfile) session.load(CaretakerProfile.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("CaretakerProfile deleted successfully, caretakerProfile details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateCaretakerProfile(CaretakerProfile p)
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<CaretakerProfile> caretakerProfilesList = session.createQuery("from CaretakerProfile").list();
		
	
	//	System.out.println("CaretakerProfile DAO Impl doesn't exist");
		return false;
	}
	
	@Override
	public int getCaretakerProfileCount(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select count(*) from CaretakerProfile where caretakerProfileId="+String.valueOf(id);
		int count = ((Long) session.createQuery(hql).uniqueResult()).intValue();
		return count;
	}
	
	@Override
	public boolean isContactInfoSet(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select count(caretakerProfileId) from ContactInfo where caretakerProfileId="+String.valueOf(id);
		int count = ((Long) session.createQuery(hql).uniqueResult()).intValue();

		if(count>0)
			return true;
		else
			return false;
			
	}
	
	
	
}