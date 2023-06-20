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
import java.util.NoSuchElementException;
import java.util.Optional;


public interface FoodItemService {
    List<food_item> GetAll();
    void add(food_item newfooditem);
    food_item get(long foodId);
    food_item getProductById(long foodId);
    void edit(food_item editfooditem);
    void remove(long foodId);
    Page<food_item> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
