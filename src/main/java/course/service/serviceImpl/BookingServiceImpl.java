package course.service.serviceImpl;

import course.entity.Booking;
import course.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
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

    }
}
