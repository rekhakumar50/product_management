package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto {
	
	private long foodId;
	
	private String foodName;
	
	private double price;
	
	private boolean available;
	
	private String category;
	
	private String subCategory;

}
