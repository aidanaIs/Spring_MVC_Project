package course.entity;

import course.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(
            generator = "customer_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "customer_gen",
            sequenceName = "customer_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String surName;
    private String email;
    @Enumerated
    private Gender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;


    @ManyToMany(cascade = {REMOVE,REFRESH, PERSIST})
    private List<Agency> agency;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Booking> booking;


}
