package main.interfaces;

import java.util.List;

import javassist.NotFoundException;
import main.entities.Zone;

public interface IZoneService {
	List<Zone> getAllZOnes();
	Zone GetZoneById(int id) throws NotFoundException;
	void addNewZone(Zone zone) throws Exception;
	void deleteZone(int id) throws Exception;
	void updateZone(Zone zone) throws Exception;
}
