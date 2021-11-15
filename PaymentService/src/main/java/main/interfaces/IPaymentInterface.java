package main.interfaces;
import java.util.List;

import main.entities.Payment;
public interface IPaymentInterface {
	
	List<Payment> getAllPayments();
	Payment getPaymentById(int id) throws Exception;
	void addNewPayment(Payment payment) throws Exception;
	void deletePayment(int id) throws Exception;
	void updatePayment(Payment payment) throws Exception;
	
}
