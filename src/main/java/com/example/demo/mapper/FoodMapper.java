package com.example.demo.mapper;

import com.example.demo.dao.Food;
import com.example.demo.dto.FoodDto;

public class FoodMapper {
	
	
	public static FoodDto convertToFoodDto(Food food) {
		FoodDto foodDto = new FoodDto();
		foodDto.setFoodId(food.getFoodId());
		foodDto.setFoodName(food.getFoodName());
		foodDto.setPrice(food.getPrice());
		foodDto.setAvailable(food.isAvailable());
		foodDto.setCategory(food.getCategory());
		foodDto.setSubCategory(food.getSubCategory());

		return foodDto;
	}
	
	
	public static Food convertToFood(FoodDto foodDto) {
		Food food = new Food();
		food.setFoodId(foodDto.getFoodId());
		food.setFoodName(foodDto.getFoodName());
		food.setPrice(foodDto.getPrice());
		food.setAvailable(foodDto.isAvailable());
		food.setCategory(foodDto.getCategory());
		food.setSubCategory(foodDto.getSubCategory());

		return food;
	}

}
