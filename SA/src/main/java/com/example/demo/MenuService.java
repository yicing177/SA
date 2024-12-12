package com.example.demo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class MenuService {
    public List<MenuItem> getMenu() {
        List<MenuItem> meal = new ArrayList<>();
        meal.add(new MenuItem("main", 1L, "辦層級式保", 5.99,"好吃不貴！" ));
        meal.add(new MenuItem("submeal", 2L, "薯餅", 7.99,"香噴噴！" ));
        meal.add(new MenuItem("beverage", 3L, "可悲樂", 3.99,"好喝喔！" ));
        return meal;
    }
}
