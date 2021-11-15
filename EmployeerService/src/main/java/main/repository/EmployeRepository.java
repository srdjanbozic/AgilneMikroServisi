package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Integer> {

}
