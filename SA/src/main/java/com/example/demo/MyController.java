package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

	/*
	 * @GetMapping("/cart") public String shoppingCart(Model model) { return "cart";
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @GetMapping("/meal") public String showMenu(Model model) { //
	 * 將所有三個類型的菜單資料放入模型中 model.addAttribute("mainMenu", menuService.getMainMenu());
	 * model.addAttribute("subMealMenu", menuService.getSubMealMenu());
	 * model.addAttribute("beverageMenu", menuService.getBeverageMenu()); return
	 * "meal"; }
	 */
	private final MenuService menuService;
	private final CartService cartService;

	@Autowired
	public MyController(MenuService menuService, CartService cartService) {
		this.menuService = menuService;
		this.cartService = cartService;
	}

	@GetMapping("/meal")
	public String getMenu(Model model) {
		model.addAttribute("allMenuItems", menuService.getAllMenuItems());
		model.addAttribute("mainMenu", menuService.getMainMenu());
		model.addAttribute("subMealMenu", menuService.getSubMealMenu());
		model.addAttribute("beverageMenu", menuService.getBeverageMenu());
		return "meal"; // meal.html 頁面
	}

	@PostMapping("/cart")
	public ResponseEntity<Map<String, String>> addToCart(@RequestBody ItemRecord request) {
		try {
			// 根據 itemID 查找菜單項目
			MenuItem menuItem = menuService.findMenuItemByID(request.getItemID());
			cartService.addItem(menuItem, request.getAmount(), request.getContent());
			
			// 返回成功的訊息
			Map<String, String> response = new HashMap<>();
			response.put("message", "成功加入購物車!");
			response.put("continueLink", "/meal"); // 繼續點餐的連結
	        response.put("viewCartLink", "/cart"); // 查看購物車的連結
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			// 返回錯誤訊息
			Map<String, String> response = new HashMap<>();
			response.put("message", "錯誤: " + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	// 顯示購物車
	@GetMapping("/cart")
	public String viewCart(Model model) {
	    // 调用 CartService 的 viewCart 方法，获取购物车内容
	    List<CartService.ItemRecord> itemRecord = cartService.viewCart();

	    // 将购物车内容和总价格添加到 Model
	    model.addAttribute("itemRecords", itemRecord);
	    model.addAttribute("totalPrice", cartService.getTotalPrice());

	    // 返回购物车视图
	    return "cart";
	}
}
