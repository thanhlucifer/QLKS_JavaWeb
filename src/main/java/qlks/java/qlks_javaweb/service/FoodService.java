package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.repository.FoodRepository;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public List<food_item> getAll() {
        return foodRepository.findAll();
    }
}
