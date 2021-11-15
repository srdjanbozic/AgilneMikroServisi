package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.Fine;

public interface FineRepository extends JpaRepository<Fine,Integer> {

}
