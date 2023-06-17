package qlks.java.qlks_javaweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

// model khách thuê
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rental")
@Getter
@Setter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long rentalId;

    @Column(name = "discount")
    private String discount;

    @Column(name = "check_in_date")
    private Date checkInDate;

    @Column(name = "check_out_date")
    private Date checkOutDate;

    @Column(name = "guest_name")
    private String guestName;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "note")
    private String note;

    @Column(name = "room_number",unique = true)
    private String roomNumber;
/*
    @ManyToOne
    @JoinColumn(name = "guest_id",nullable = false)
    private Guest guest;*/

    @ManyToMany
    @JoinTable(name = "rental_room",
            joinColumns = @JoinColumn(name = "rental_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Set<room> rooms;
/*
    @OneToMany(mappedBy = "rental")
    private Set<OrderFood> orderFoods;*/
}
