package qlks.java.qlks_javaweb.model;

import jakarta.persistence.*;
import lombok.*;
//model
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_food")
@Getter
@Setter
public class OrderFood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_food_id")
    private Long id;

    @Column(name = "total_price")
    private String totalPrice;

    @Column(name = "people_number")
    private String peopleNumber;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "discount")
    private String discount;

    @Column(name = "note")
    private String note;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
