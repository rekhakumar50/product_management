package com.example.demo.controller;

import static com.example.demo.constant.Constants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FoodDto;
import com.example.demo.dto.Response;
import com.example.demo.service.FoodService;
import com.example.demo.transformer.ResponseTransformer;

@RestController
@RequestMapping("/api")
public class FoodController {
	
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private ResponseTransformer responseTransformer;
	
	
	@PostMapping(value = "/food", consumes = "application/json")
	public ResponseEntity<Response> addFood(@RequestBody FoodDto foodDto) {
		try {
			foodService.addFood(foodDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.CREATED.value(), DATA_SAVED);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/food", consumes = "application/json")
	public ResponseEntity<Response> updateFood(@RequestBody FoodDto foodDto) {
		try {
			foodService.updateFood(foodDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_UPDATED);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/food", consumes = "application/json")
	public ResponseEntity<Response> deleteFood(@RequestBody FoodDto foodDto) {
		try {
			foodService.deleteFood(foodDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_DELETED);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
	@GetMapping(value = "/foods", consumes = "application/json")
	public ResponseEntity<List<FoodDto>> getAllFood() {
		List<FoodDto> foods = null;
		try {
			foods = foodService.getAllFood();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_RETRIEVED);
		response.setFoodDto(foods);
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/foods/foodName", consumes = "application/json")
	public ResponseEntity<List<FoodDto>> getFoodByNameLike(@RequestParam String foodName) {
		List<FoodDto> foods = null;
		try {
			foods = foodService.getFoodByNameLike(foodName);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_RETRIEVED);
		response.setFoodDto(foods);
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/foods/{category}", consumes = "application/json")
	public ResponseEntity<List<FoodDto>> getFoodByCategory(@PathVariable String category) {
		List<FoodDto> foods = null;
		try {
			foods = foodService.getFoodByCategory(category);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_RETRIEVED);
		response.setFoodDto(foods);
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/foods/subCategory", consumes = "application/json")
	public ResponseEntity<List<FoodDto>> getFoodBySubCategoryLike(@RequestParam String subCategory) {
		List<FoodDto> foods = null;
		try {
			foods = foodService.getFoodBySubCategoryLike(subCategory);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), "Data Retrieved!!");
		response.setFoodDto(foods);
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}
	

}
