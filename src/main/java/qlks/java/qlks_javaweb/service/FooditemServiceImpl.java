package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.repository.FoodItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FooditemServiceImpl implements FoodItemService{
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public List<food_item> GetAll() {
        return foodItemRepository.findAll();
    }

    @Override
    public void add(food_item newfooditem) {
        foodItemRepository.save(newfooditem);
    }

    @Override
    public food_item get(long foodId) {
        return foodItemRepository.findById(foodId).stream().findFirst().orElse(null);
    }

    @Override
    public food_item getProductById(long foodId){
        Optional<food_item> optional = foodItemRepository.findById(foodId);
        food_item foodItem = null;
        if (optional.isPresent()) {
            foodItem = optional.get();
        } else {
            throw  new RuntimeException("laptop not found for id :: " + foodId);
        } return foodItem;
    }

    @Override
    public void edit(food_item editfooditem) {
        food_item find = get(editfooditem.getFoodId());
        if(find!=null) {
            find.setFoodImage(editfooditem.getFoodImage());
            find.setFoodName(editfooditem.getFoodName());
            find.setFoodPrice(editfooditem.getFoodPrice());
        }
    }
    @Override
    public void remove(long foodId) {
        foodItemRepository.deleteById(foodId);
    }

    @Override
    public Page<food_item> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1 ,pageSize,sort);
        return this.foodItemRepository.findAll(pageable);
    }
}
