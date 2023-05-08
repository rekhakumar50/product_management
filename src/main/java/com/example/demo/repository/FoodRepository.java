package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	
	//get food by name
	Optional<Food> findByFoodName(String foodName);

	//get food by name like
	List<Food> findByFoodNameLike(String foodName);
	
	//get food by category
	List<Food> findByCategory(String category);

	//get food by subCategory like
	List<Food> findBySubCategoryLike(String subCategory);
	
}
