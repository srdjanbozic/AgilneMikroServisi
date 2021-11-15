package main.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;

	private String parkingspot;

	private String paymentdate;

	private String paymentend;

	private String paymentstart;

	private Integer ownerId;

	private Integer parkingLot;

	private Integer vehicleId;
	
	public Payment() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParkingspot() {
		return parkingspot;
	}

	public void setParkingspot(String parkingspot) {
		this.parkingspot = parkingspot;
	}

	public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getPaymentend() {
		return paymentend;
	}

	public void setPaymentend(String paymentend) {
		this.paymentend = paymentend;
	}

	public String getPaymentstart() {
		return paymentstart;
	}

	public void setPaymentstart(String paymentstart) {
		this.paymentstart = paymentstart;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(Integer parkingLot) {
		this.parkingLot = parkingLot;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
}
