package qlks.java.qlks_javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlks.java.qlks_javaweb.model.food_item;

@Repository
public interface FoodRepository extends JpaRepository<food_item,Long> {
}
