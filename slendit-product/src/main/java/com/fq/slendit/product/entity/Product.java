package com.fq.slendit.product.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	private int id;
	private int userId;
	private String productName;
	private String description;
	private String deposit;
	private String iouPerDay;
	private String iouPerWeek;
	private String iouPerMonth;

	private String place;
	private String categoryId;

	private String addressId;
	
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String latitude;
	private String longitude;

	private String location;
	
	private String position;
	
	private String allowNegotiation;
	private String rentalFee;
	
	private String taxAmount;
	
	private String deliveryService;
	private String deliveryChargesPerMile;
	private String deliveryServiceRadius;
	
	private Date created;
	private Date updated;

	private String status;
	private String version;

	private int numOfPendReservations;
	private String nextPickupDate;
	private String nextHandedOffDate;
	
	private String blockStatus;
	
	private String pickupAddress;
}
