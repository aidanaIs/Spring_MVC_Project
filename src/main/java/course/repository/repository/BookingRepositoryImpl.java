package course.repository.repository;

import course.entity.Booking;
import course.repository.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public BookingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveBooking(Booking booking) {
    entityManager.persist(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public List<Booking> getAllBooking() {
        return  entityManager.createQuery("select a from Booking a order by a.id desc", Booking.class).getResultList();
    }

    @Override
    public void updateBookingById(Long id, Booking booking) {
        Booking upBooking=entityManager.find(Booking.class, id);
        upBooking.setCustomer_id(booking.getCustomer_id());
        upBooking.setHouse_id(booking.getHouse_id());
    }

    @Override
    public void deleteBookingById(Long id) {
        entityManager.remove(entityManager.find(Booking.class, id));
    }
}
