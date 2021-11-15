package main.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import main.entities.ParkingLot;
import main.interfaces.IParkingLotService;
import main.repositories.ParkingLotRepository;

@Service
public class ParkingLotService implements IParkingLotService {

	@Autowired
	ParkingLotRepository parkingRepository;
	
	@Override
	public List<ParkingLot> getAllParkingLots() {
		List<ParkingLot> parkings = new ArrayList<ParkingLot>();
		parkingRepository.findAll().forEach(parking -> parkings.add(parking));
		return parkings;
	}

	@Override
	public ParkingLot GetParingLotById(int id) throws NotFoundException {
		ParkingLot parkingLotById = parkingRepository.findById(id).get();
		
		if(parkingLotById.getId() == null)
			throw new NotFoundException("Parking lot doesn't exist");
		
		return parkingLotById;
	}

	@Override
	public void addNewParkingLot(ParkingLot parkingLot) throws Exception {
		ParkingLot addedParkingLot = parkingRepository.save(parkingLot);
		
		if(addedParkingLot == null)
			throw new Exception("Bad Request");
	}

	@Override
	public void deleteParkingLot(int id) throws Exception {
		if(parkingRepository.existsById(id)) {
			parkingRepository.deleteById(id);
		} else {
			throw new Exception("Bad Request");
		}
		
	}

	@Override
	public void updateParkingLot(ParkingLot parkingLot) throws Exception {
		if(parkingRepository.existsById(parkingLot.getId())) {
			parkingRepository.save(parkingLot);
		} else {
			throw new Exception("Bad request");
		}
	}

}
