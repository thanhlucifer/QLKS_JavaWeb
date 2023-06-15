package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.repository.FoodItemRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FoodItemService {
    @Autowired
    private  FoodItemRepository foodItemRepository;

    public List<food_item> GetAll() {
        return foodItemRepository.findAll();
    }

    public void add(food_item newfooditem) {
        foodItemRepository.save(newfooditem);
    }

    public food_item get(long foodId) {
        return foodItemRepository.findById(foodId).stream().findFirst().orElse(null);
    }

    public food_item getProductById(long foodId){
        Optional<food_item> optional = foodItemRepository.findById(foodId);
        food_item foodItem = null;
        if (optional.isPresent()) {
            foodItem = optional.get();
        } else {
            throw  new RuntimeException("laptop not found for id :: " + foodId);
        } return foodItem;
    }

    public void edit(food_item editfooditem) {
        food_item find = get(editfooditem.getFoodId());
        if(find!=null) {
            find.setFoodImage(editfooditem.getFoodImage());
            find.setFoodName(editfooditem.getFoodName());
            find.setFoodPrice(editfooditem.getFoodPrice());

        }
    }
    public void remove(long foodId) {
        foodItemRepository.deleteById(foodId);
    }
}
