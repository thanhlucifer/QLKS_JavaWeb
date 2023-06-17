package qlks.java.qlks_javaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

//model nhân viên
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNV", nullable = false)
    private Long maNV;

    @Column(name = "tenNV", nullable = false)
    private String TenNV;

    @Column(name = "CCCD", nullable = false)
    private String cccd;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "dia_chi")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "luong")
    private String luong;


    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}
