package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {

	@GetMapping("/home")
	public String home(Model model) {
		return "menu";
	}

	private final MenuService menuService;
	private final CartService cartService;

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

	@GetMapping("/set")
	public String showSetMealPage(@RequestParam String mainItemID, Model model) {
		MenuItem mainItem = menuService.getItemById(mainItemID);
		model.addAttribute("mainItem", mainItem);
		model.addAttribute("subMealMenu", menuService.getSubMealMenu());
		model.addAttribute("beverageMenu", menuService.getBeverageMenu());

		return "set"; // 返回 set.html
	}

	@PostMapping("/cart")
	public ResponseEntity<Map<String, String>> addToCart(@RequestBody Map<String, Object> request) {
		try {
			String mealType = (String) request.get("mealType");
			String mainItemID = (String) request.get("mainItemID");
			String sideItemID = (String) request.get("sideItemID");
			String drinkItemID = (String) request.get("drinkItemID");
			int amount = (int) request.get("amount");

			MenuItem mainItem = menuService.findMenuItemByID(mainItemID);
			MenuItem sideItem = null;
			MenuItem drinkItem = null;

			if ("set".equals(mealType)) {
				
				sideItem = menuService.findMenuItemByID(sideItemID);
				drinkItem = menuService.findMenuItemByID(drinkItemID);

				
				int totalPrice = (mainItem.getPrice() + sideItem.getPrice()) * amount;

				
				cartService.addSetMeal(mainItem, sideItem, drinkItem, amount, totalPrice); 
			} else {
				cartService.addItem(mainItem, amount, ""); 
			}
			Map<String, String> response = new HashMap<>();
			response.put("message", "成功加入購物車！");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "錯誤：" + e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	// 顯示購物車
	@GetMapping("/cart")
	public String viewCart(Model model) {
		
		List<CartService.ItemRecord> itemRecord = cartService.viewCart();
		List<CartService.SetRecord> setRecords = cartService.viewSetCart();
		
		model.addAttribute("itemRecords", itemRecord);
		model.addAttribute("setRecords", setRecords);
		model.addAttribute("totalPrice", cartService.getTotalPrice());

		
		return "cart";
	}

	// 更新單點餐點數量
	@PostMapping("/cart/update/{recordID}")
	public ResponseEntity<?> updateItemQuantity(@PathVariable String recordID,
			@RequestBody Map<String, Integer> payload) {

		int amount = payload.get("amount");
		cartService.updateItemQuantity(recordID, amount);
		return ResponseEntity.ok(Map.of("success", true, "message", "數量更新成功"));
	}

	// 更新套餐數量
	@PostMapping("/cart/update/set/{setRecordID}")
	public ResponseEntity<?> updateSetQuantity(@PathVariable String setRecordID,
			@RequestBody Map<String, Integer> payload) {
		int amount = payload.get("amount");
		cartService.updateSetQuantity(setRecordID, amount);
		return ResponseEntity.ok(Map.of("success", true, "message", "數量更新成功"));
		
	}

	// 刪除單點餐點
	@DeleteMapping("/cart/delete/{recordID}")
	public ResponseEntity<?> deleteItem(@PathVariable String recordID) {
		cartService.deleteItem(recordID);
		return ResponseEntity.ok(Map.of("success", true, "message", "項目刪除成功"));
	}

	// 刪除套餐餐點
	@DeleteMapping("/cart/delete/set/{setRecordID}")
	public ResponseEntity<Map<String, String>> deleteSetItem(@PathVariable String setRecordID) {
		cartService.deleteSetItem(setRecordID);

		Map<String, String> response = new HashMap<>();
		response.put("message", "成功刪除套餐！");
		return ResponseEntity.ok(response);
	}

}
