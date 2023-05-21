package course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Agency {
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
    private String country;
    private String phoneNumber;
    private String email;
    private String image;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;


    @OneToMany(cascade = CascadeType.ALL)
    private List<House> houses;


}
