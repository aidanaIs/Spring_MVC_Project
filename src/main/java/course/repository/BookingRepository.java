package course.repository;

import course.entity.Booking;

import java.util.List;

public interface BookingRepository {
    void saveBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBooking();
    void updateBookingById(Long id, Booking booking);
    void deleteBookingById(Long id);
}
