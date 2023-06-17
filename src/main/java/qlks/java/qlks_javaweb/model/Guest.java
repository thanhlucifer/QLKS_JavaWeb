package qlks.java.qlks_javaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

//model khach hang
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guest")
@Getter
@Setter
@JsonIgnoreProperties("rentals")

public class Guest  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_Id")
    private long guestId;

    @Column(name = "guest_name")
    private String guestName;

    @Column(name = "birth")
    private String birth;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "address")
    private String address;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "vip")
    private String vip;
/*
    @OneToMany(mappedBy ="guest",cascade = CascadeType.ALL)
    private Set<Rental> rentals;
*/
}
