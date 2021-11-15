package main.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import main.entities.Zone;
import main.interfaces.IZoneService;
import main.repositories.ZoneRepository;

@Service
public class ZoneService implements IZoneService {

	@Autowired
	ZoneRepository zoneRepository;
	
	@Override
	public List<Zone> getAllZOnes() {
		List<Zone> zones = new ArrayList<Zone>();
		zoneRepository.findAll().forEach(zone -> zones.add(zone));
		return zones;
	}

	@Override
	public Zone GetZoneById(int id) throws NotFoundException {
		Zone zoneById = zoneRepository.findById(id).get();
		
		if(zoneById == null)
			throw new NotFoundException("Zone does't exist");
		
		return zoneById;
	}

	@Override
	public void addNewZone(Zone zone) throws Exception {
		Zone addedZone = zoneRepository.save(zone);
		
		if(addedZone == null) {
			throw new Exception("Bad request");
		}
	}

	@Override
	public void deleteZone(int id) throws Exception {
		if(zoneRepository.existsById(id)) {
			zoneRepository.deleteById(id);			
		} else {
			throw new Exception("Bad Request");
		}
	}

	@Override
	public void updateZone(Zone zone) throws Exception {
		if(zoneRepository.existsById(zone.getId())) {
			zoneRepository.save(zone);
		} else {
			throw new Exception("Bad Request");
		}
	}

}
