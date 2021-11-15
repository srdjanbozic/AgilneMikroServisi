package main.interfaces;

import java.util.List;

import main.entities.Vehicle;

public interface IVehicleInterface {
	List<Vehicle> getAllVehicles();
	Vehicle getVehicleById(int id) throws Exception;
	void addNewVehicle(Vehicle vehicle) throws Exception;
	void deleteVehicle(int id) throws Exception;
	void updateVehicle(Vehicle vehicle) throws Exception;
}
