package han.triptop.groepB3.adapter;
import han.triptop.groepB3.service.ExternalBookingService;
import org.springframework.stereotype.Component;

@Component
public class BookingApiAdapter implements HotelApiAdapter {
    private final ExternalBookingService bookingService;

    public BookingApiAdapter(ExternalBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public String fetchHotels() {
        return bookingService.fetchBookingHotels();
    }
}
