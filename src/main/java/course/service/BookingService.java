package course.service;

import course.entity.Booking;

import java.util.List;

public interface BookingService {
    void saveBooking(Booking booking, Long idC, Long idH);
    Booking getBookingById(Long id);
    List<Booking> getAllBooking();
    void updateBookingById(Long id, Booking booking);
    void deleteBookingById(Long id);
}
