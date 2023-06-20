package qlks.java.qlks_javaweb.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rental_id")
    private Long rentalId;

    @Column(name = "discount")
    private String discount;

    @NotNull(message = "Không được trống")
    //@FutureOrPresent(message = "Phải lớn hoặc bằng ngày hiện tại")
    @Column(name = "check_in_date")
    private LocalDateTime checkInDate;

    @NotNull(message = "Không được trống")
    //@FutureOrPresent(message = "Phải lớn hoặc bằng ngày hiện tại")
    @Column(name = "check_out_date")
    private LocalDateTime checkOutDate;

    @NotNull(message = "Không được trống")
    @Column(name = "guest_name")
    private String guestName;

    @NotNull(message = "Không được trống")
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

    @ManyToMany
    @JoinTable(name = "rental_room",
            joinColumns = @JoinColumn(name = "rental_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private Set<room> rooms;

}
