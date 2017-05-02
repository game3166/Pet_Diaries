package spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.CaretakerProfileDAO;
import spring.model.CaretakerProfile;

@Service
public class CaretakerProfileServiceImpl implements CaretakerProfileService {
	
	private CaretakerProfileDAO caretakerProfileDAO;

	public void setCaretakerProfileDAO(CaretakerProfileDAO caretakerProfileDAO) {
		this.caretakerProfileDAO = caretakerProfileDAO;
	}

	@Override
	@Transactional
	public boolean addCaretakerProfile(CaretakerProfile p) {
		boolean error=false;
		error=this.caretakerProfileDAO.addCaretakerProfile(p);
		return error;
	}

	@Override
	@Transactional
	public void updateCaretakerProfile(CaretakerProfile p) {
		this.caretakerProfileDAO.updateCaretakerProfile(p);
	}

	@Override
	@Transactional
	public List<CaretakerProfile> listCaretakerProfiles() {
		return this.caretakerProfileDAO.listCaretakerProfiles();
	}

	@Override
	@Transactional
	public boolean validateCaretakerProfile(CaretakerProfile p)
	{
		return this.caretakerProfileDAO.validateCaretakerProfile(p);
	}
	@Override
	@Transactional
	public CaretakerProfile getCaretakerProfileById(int id) {
		return this.caretakerProfileDAO.getCaretakerProfileById(id);
	}

	@Override
	@Transactional
	public void removeCaretakerProfile(int id) {
		this.caretakerProfileDAO.removeCaretakerProfile(id);
	}
	
	@Override
	@Transactional
	public int getCaretakerProfileCount(int id)
	{
		return this.caretakerProfileDAO.getCaretakerProfileCount(id);
	}
	
	@Override
	@Transactional
	public boolean isContactInfoSet(int id)
	{
		return this.caretakerProfileDAO.isContactInfoSet(id);
	}
	
}