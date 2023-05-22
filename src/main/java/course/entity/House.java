package course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import static jakarta.persistence.CascadeType.*;


@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @GeneratedValue(
            generator = "house_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "house_gen",
            sequenceName = "house_seq",
            allocationSize = 1)
    private Long id;
    private String houseType;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    private boolean isBooked;
    private String image;

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, PERSIST})
    private List<Agency> agency;

    @OneToOne(cascade= ALL)
    private Booking booking;

}
