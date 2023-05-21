package course.repository.repository;

import course.entity.Booking;
import course.repository.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager;

    @Override
    public void saveBooking(Booking booking) {

    }

    @Override
    public Booking getBookingById(Long id) {
        return null;
    }

    @Override
    public List<Booking> getAllBooking() {
        return null;
    }

    @Override
    public void updateBookingById(Long id, Booking booking) {
    }

    @Override
    public void deleteBookingById(Long id) {

        //they are saying that assign method will work with save, so you don't have to add assign
        //
    }
}
