package spring.service;

import java.util.List;

import spring.model.Pet;

public interface PetService
{
	public boolean addPet(Pet p);
	public boolean validatePet(Pet p);
	public void updatePet(Pet p);
	public List<Pet> listPets(int userId);
	public Pet getPetById(int id);
	public void removePet(int id);
	public int getPetCount(int id);
	public boolean isContactInfoSet(int id);
	
}