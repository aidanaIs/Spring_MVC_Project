package course.api;

import course.service.AgencyService;
import course.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingApi {
    private final BookingService bookingService;


}
