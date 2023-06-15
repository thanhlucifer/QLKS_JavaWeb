package qlks.java.qlks_javaweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_item")
@Getter
@Setter

public class food_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_item_id")
    private Long foodId;
    @Column(name = "food_item_name",unique = true)
    private String foodName;

    @Column(name = "image")
    private String foodImage;

    @Column(name = "price")
    private String foodPrice;
}
