package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.*;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
