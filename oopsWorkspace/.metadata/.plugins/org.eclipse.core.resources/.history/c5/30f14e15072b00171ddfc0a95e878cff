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

import spring.model.Pet;

@Repository
public class PetDAOImpl implements PetDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PetDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public boolean addPet(Pet p) {
		boolean error=false;
		Session session = this.sessionFactory.getCurrentSession();
		
		try
		{
			session.save(p);
			//tx.commit();
			System.out.println("Pet DAO Impl Added pet without exceptions");
		}
		catch(Exception e)
		{
			session.clear();
			System.out.println(e.getCause());
			error=true;
		}
		
		return error;
		
	//	logger.info("Pet saved successfully, Pet Details="+p);
	}

	@Override
	public void updatePet(Pet p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Pet updated successfully, Pet Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pet> listPets() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pet> petsList = session.createQuery("from Pet").list();
		for(Pet p : petsList){
			logger.info("Pet List::"+p);
		}
		return petsList;
	}

	@Override
	public Pet getPetById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Pet p = (Pet) session.load(Pet.class, new Integer(id));
		logger.info("Pet loaded successfully, Pet details="+p);
		return p;
	}

	@Override
	public void removePet(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pet p = (Pet) session.load(Pet.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Pet deleted successfully, pet details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validatePet(Pet p)
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Pet> petsList = session.createQuery("from Pet").list();
		
		for(Pet p1 : petsList){
			
		//	System.out.println("p.getname"+p.getName()+" p1.getname"+p1.getName()+" p.getCountry"+p.getCountry() + " p1.getCountry" +p1.getCountry());
			
			
			{
			//	System.out.println("Pet DAO Impl gotcha");
				System.out.println("Pet Type is" + p1.getPetType());
				p.setPetType(p1.getPetType());
				p.setPetId(p1.getPetId());
				
				return true;
			}
		}
	//	System.out.println("Pet DAO Impl doesn't exist");
		return false;
	}
	
	@Override
	public int getPetCount(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select count(*) from Pet where petId="+String.valueOf(id);
		int count = ((Long) session.createQuery(hql).uniqueResult()).intValue();
		return count;
	}
	
	@Override
	public boolean isContactInfoSet(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select count(petId) from ContactInfo where petId="+String.valueOf(id);
		int count = ((Long) session.createQuery(hql).uniqueResult()).intValue();

		if(count>0)
			return true;
		else
			return false;
			
	}
	
	
	
}