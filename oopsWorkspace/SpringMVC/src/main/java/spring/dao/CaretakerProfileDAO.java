package spring.dao;
import java.util.List;

import spring.model.CaretakerProfile;

public interface CaretakerProfileDAO {
	
	public boolean addCaretakerProfile(CaretakerProfile p);
	public void updateCaretakerProfile(CaretakerProfile p);
	public List<CaretakerProfile> listCaretakerProfiles();
	public CaretakerProfile getCaretakerProfileById(int id);
	public void removeCaretakerProfile(int id);
	public boolean validateCaretakerProfile(CaretakerProfile p);
	public int getCaretakerProfileCount(int id);
	public boolean isContactInfoSet(int id);
	
}