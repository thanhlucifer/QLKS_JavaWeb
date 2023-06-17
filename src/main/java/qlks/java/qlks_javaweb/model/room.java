package qlks.java.qlks_javaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//model phong
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
@Getter
@Setter
@JsonIgnoreProperties("rentals")
public class room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_number",unique = true)
    private String roomNumber;

    @Column(name = "room_type")
    private String roomType;

    @Column(name= "image")
    private String image;

    @Column(name = "vip")
    private String vip;

    @Column(name = "price")
    private String price;

    @Column(name = "note")
    private String note;

    //trình trang phong
    @Column(name = "is_empty")
    private String isEmpty;

    @ManyToMany(mappedBy = "rooms")
    private Set<Rental> rentals;

}
