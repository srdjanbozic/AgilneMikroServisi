package main.interfaces;
import java.util.List;

import main.entities.Owner;

public interface IOwnerInterface {
	
	List<Owner> getAllOwners();
	Owner getOwnerById(int id) throws Exception;
	void addNewOwner(Owner owner) throws Exception;
	void deleteOwner(int id) throws Exception;
	void updateOwner(Owner owner) throws Exception;
}
