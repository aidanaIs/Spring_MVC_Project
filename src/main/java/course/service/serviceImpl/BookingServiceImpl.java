package course.service.serviceImpl;

import course.entity.Booking;
import course.entity.Customer;
import course.entity.House;
import course.repository.BookingRepository;
import course.repository.CustomerRepository;
import course.repository.HouseRepository;
import course.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final HouseRepository houseRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, CustomerRepository customerRepository, HouseRepository houseRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.houseRepository = houseRepository;
    }



    @Override
    public void saveBooking(Booking booking, Long idC, Long idH) {
        Customer customer=customerRepository.getCustomerById(idC);
        House house=houseRepository.getHouseById(idH);
        booking.setCustomer_id(customer);
        booking.setHouse_id(house);
        bookingRepository.saveBooking(booking);


       bookingRepository.saveBooking(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.getBookingById(id);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.getAllBooking();
    }


    //
    @Override
    public void updateBookingById(Long id, Booking booking) {
        bookingRepository.updateBookingById(id, booking);
    }

    @Override
    public void deleteBookingById(Long id) {
        Booking booking=bookingRepository.getBookingById(id);
        booking.setCustomer_id(null);
        booking.setHouse_id(null);
        bookingRepository.deleteBookingById(id);

    }
}
