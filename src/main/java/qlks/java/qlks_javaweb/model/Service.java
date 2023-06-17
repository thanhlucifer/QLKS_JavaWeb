package qlks.java.qlks_javaweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

//model các dich vu khach san
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
@Getter
@Setter
public class Service  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    @Column(name = "service_name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "note")
    private String note;
}
