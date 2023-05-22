package course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "bookings")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Booking {
    @Id
    @GeneratedValue(generator = "user_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_gen",
            sequenceName = "user_seq",
            allocationSize = 1)

    private Long id;
    @OneToMany(cascade = {REMOVE,REFRESH, PERSIST, DETACH})
    List<Customer> customer_id;
    @OneToOne(cascade = {REMOVE,REFRESH, PERSIST, DETACH})
    House house_id;
}
