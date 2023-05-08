package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Food;
import com.example.demo.dto.FoodDto;
import com.example.demo.repository.FoodRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.demo.mapper.FoodMapper.*;

@Getter
@Setter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class FoodService {
	
	private FoodRepository foodRepository;
	
	
	public void addFood(FoodDto foodDto) {
		Food food = convertToFood(foodDto);
		foodRepository.save(food);
	}
	

	public void updateFood(FoodDto foodDto) {
		Food food = convertToFood(foodDto);
		Optional<Food> foodOp = foodRepository.findByFoodName(food.getFoodName());

		if(foodOp.isPresent()) {
			Food updateFood = foodOp.get();
			updateFood.setAvailable(food.isAvailable());
			updateFood.setPrice(food.getPrice());
			foodRepository.save(updateFood);
		}
	}
		

	public void deleteFood(FoodDto foodDto) {
		Food food = convertToFood(foodDto);
		Optional<Food> foodOp = foodRepository.findByFoodName(food.getFoodName());

		if(foodOp.isPresent()) {
			foodRepository.delete(foodOp.get());
		}
	}
	

	public List<FoodDto> getAllFood() {
		List<FoodDto> foodList = null;
		List<Food> foods = foodRepository.findAll();

		if(CollectionUtils.isNotEmpty(foods)) {
			foodList = foods.stream()
						.map(food -> convertToFoodDto(food))
						.collect(Collectors.toList());	
		}
		return foodList;
	}
		
	
	public List<FoodDto> getFoodByNameLike(String foodName) {
		List<FoodDto> foodList = null;
		List<Food> foods = foodRepository.findByFoodNameLike(foodName);
		
		if(CollectionUtils.isNotEmpty(foods)) {
			foodList = foods.stream()
						.map(food -> convertToFoodDto(food))
						.collect(Collectors.toList());	
		}
		return foodList;
	}
		

	public List<FoodDto> getFoodByCategory(String category) {
		List<FoodDto> foodList = null;
		List<Food> foods = foodRepository.findByCategory(category);
		
		if(CollectionUtils.isNotEmpty(foods)) {
			foodList = foods.stream()
						.map(food -> convertToFoodDto(food))
						.collect(Collectors.toList());	
		}
		return foodList;
	}	
	
	
	public List<FoodDto> getFoodBySubCategoryLike(String subCategory) {
		List<FoodDto> foodList = null;
		List<Food> foods = foodRepository.findBySubCategoryLike(subCategory);
		
		if(CollectionUtils.isNotEmpty(foods)) {
			foodList = foods.stream()
						.map(food -> convertToFoodDto(food))
						.collect(Collectors.toList());	
		}
		return foodList;
	}
	
}
