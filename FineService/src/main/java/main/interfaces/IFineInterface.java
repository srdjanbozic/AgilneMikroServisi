package main.interfaces;
import java.util.List;

import main.entities.Fine;
public interface IFineInterface {
	
	List<Fine> getAllFines();
	Fine getFineById(int id) throws Exception;
	void addNewFine(Fine fine) throws Exception;
	void deleteFine(int id) throws Exception;
	void updateFine(Fine fine) throws Exception;
	
}
