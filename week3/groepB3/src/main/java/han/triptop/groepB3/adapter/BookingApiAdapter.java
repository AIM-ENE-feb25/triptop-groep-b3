package han.triptop.groepB3.adapter;
import han.triptop.groepB3.service.ImmutableExternalBookingService;
import org.springframework.stereotype.Component;

@Component
public class BookingApiAdapter implements HotelApiAdapter {
    private final ImmutableExternalBookingService bookingService;

    public BookingApiAdapter(ImmutableExternalBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public String fetchHotels() {
        return bookingService.fetchBookingHotels();
    }
}
