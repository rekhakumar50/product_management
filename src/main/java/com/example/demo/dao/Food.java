package com.example.demo.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "foods")
public class Food implements Serializable {

	private static final long serialVersionUID = 805076007959507731L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long foodId;
	
	@Column(unique = true, nullable = false)
	private String foodName;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private boolean available;
	
	@Column(unique = true)
	private String category;
	
	@Column(unique = true)
	private String subCategory;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime registeredDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

}
