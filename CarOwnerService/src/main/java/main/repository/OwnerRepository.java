package main.repository;

//import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {

}
