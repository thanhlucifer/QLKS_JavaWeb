package qlks.java.qlks_javaweb.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CartItem {
    //service info
    private Long id;
    private String name;
    private int price;
    private String note;
    //so luong vé
    private int quantity;
}
