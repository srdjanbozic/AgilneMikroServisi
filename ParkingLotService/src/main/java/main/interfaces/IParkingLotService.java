package main.interfaces;

import java.util.List;

import javassist.NotFoundException;
import main.entities.ParkingLot;


public interface IParkingLotService {
	List<ParkingLot> getAllParkingLots();
	ParkingLot GetParingLotById(int id) throws NotFoundException;
	void addNewParkingLot(ParkingLot parkingLot) throws Exception;
	void deleteParkingLot(int id) throws Exception;
	void updateParkingLot(ParkingLot parkingLot) throws Exception;
}
