package course.entity;

import course.entity.enums.HouseType;
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
    @Enumerated
    private HouseType houseType;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    private boolean isBooked;
    private String image;

    @OneToMany(cascade = {REFRESH, PERSIST,REMOVE})
    private List<Agency> agency;

    @OneToOne(cascade= {REFRESH, PERSIST,REMOVE})
    private Booking booking;

}
