package spring.dao;
import java.util.List;

import spring.model.Pet;

public interface PetDAO {
	
	public boolean addPet(Pet p);
	public void updatePet(Pet p);
	public List<Pet> listPets(int userId);
	public Pet getPetById(int id);
	public void removePet(int id);
	public boolean validatePet(Pet p);
	public int getPetCount(int id);
	public boolean isContactInfoSet(int id);
	public int getIdFromUserId(int userId);
}