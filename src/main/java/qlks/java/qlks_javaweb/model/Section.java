package qlks.java.qlks_javaweb.model;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

//model chức vụ trong khách sạn
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "section")
@Getter
@Setter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long sectionId;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "section_manager_id")
    private String sectionManagerId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section")
    private Set<Employee> listEmployee = new HashSet<>();

}
