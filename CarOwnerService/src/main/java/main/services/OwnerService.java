package main.services;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import main.entities.Owner;
import main.interfaces.IOwnerInterface;
import main.repository.OwnerRepository;  

@Service
public class OwnerService implements IOwnerInterface {
	
	@Autowired  
	OwnerRepository ownerRepository;  
	@Override
	public List<Owner> getAllOwners()   
	{  
		List<Owner> owners = new ArrayList<Owner>();  
		ownerRepository.findAll().forEach(owner -> owners.add(owner));  
		return owners;  
	}  
	 
	public Owner getOwnerById(int id) throws Exception
	{
	
		Owner ownerById = ownerRepository.findById(id).get();
		
		if (ownerById.getId() == null)
			throw new NotFoundException("Owner doesn't exist");
		
		return ownerById;  
	}  
	 
	public void addNewOwner(Owner owner)   throws Exception
	{  
		Owner addedOwner = ownerRepository.save(owner);
		
		if (addedOwner == null) 
			throw new Exception ("Bad request"); 
	}  
	  
	public void deleteOwner(int id)   throws Exception
	{  
		if(ownerRepository.existsById(id)) {
			ownerRepository.deleteById(id);  
		} else {
			throw new Exception ("Bad request");
		}
	}  

	public void updateOwner(Owner owner)   throws Exception
	{  
		if(ownerRepository.existsById(owner.getId())) {
			ownerRepository.save(owner);  
		} else {
			throw new Exception ("Bad request");
		}

	}  
}
