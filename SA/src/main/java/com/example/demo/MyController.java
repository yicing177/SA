package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {

	@GetMapping("/home")
	public String home() {
		// 返回一個視圖名稱（在 templates 資料夾中的 HTML 文件）
		return "index"; // 對應於 src/main/resources/templates/index.html
	}

	@GetMapping("/aLaCarte")
	public String aLaCarte(Model model) {
		model.addAttribute("content", "a_la_carte.html");
		return "navbar";
	}

	@GetMapping("/main_meal")
	public String main_meal(Model model) {
		model.addAttribute("content", "main.html");
		return "navbar";
	}

	@GetMapping("/dessert")
	public String dessert(Model model) {
		model.addAttribute("content", "dessert.html");
		return "navbar";
	}

	@GetMapping("/drink")
	public String drink(Model model) {
		model.addAttribute("content", "drink.html");
		return "navbar";
	}

	@GetMapping("/shoppingCart")
	public String shoppingCart(Model model) {
		return "shoppingCart";
	}

}
