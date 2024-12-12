package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/home")
	public String home(Model model) {
		return "index"; // 對應於 src/main/resources/templates/navbar.html
	}

	@GetMapping("/main")
	public String main_meal(Model model) {
		model.addAttribute("content", "main.html");
		return "navbar";
	}

	@GetMapping("/submeal")
	public String dessert(Model model) {
		model.addAttribute("content", "submeal.html");
		return "navbar";
	}

	@GetMapping("/beverage")
	public String drink(Model model) {
		model.addAttribute("content", "beverage.html");
		return "navbar";
	}

	@GetMapping("/cart")
	public String shoppingCart(Model model) {
		return "cart";
	}

	@Autowired
	private MenuService menuService;

	@GetMapping("/meal")
	public String getMeals(Model model) {
		// 從 MenuService 獲取主餐列表
		List<MainMeal> mainMeals = menuService.getMainMeals();
		model.addAttribute("meals", mainMeals);
		return "meal"; // 對應 meal.html
	}
}
