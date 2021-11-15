package main.interfaces;

import java.util.List;

import main.entities.Employe;

public interface IEmployeInterface {
	List<Employe> getAllEmployes();
	Employe getEmployeById(int id) throws Exception;
	void addNewEmploye(Employe controller) throws Exception;
	void deleteEmploye(int id) throws Exception;
	void updateEmploye(Employe controller) throws Exception;
}
