package main.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.Zone;


public interface ZoneRepository extends JpaRepository<Zone,Integer> {

	Collection<Zone> findByZonetypeContainingIgnoreCase(String name);

}
