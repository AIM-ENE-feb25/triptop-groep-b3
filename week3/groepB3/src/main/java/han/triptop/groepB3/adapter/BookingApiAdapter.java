package han.triptop.groepB3.adapter;
import han.triptop.groepB3.service.ImmutableExternalBookingService;

public class BookingApiAdapter implements HotelApiAdapter {
    private final ImmutableExternalBookingService bookingService;

    public BookingApiAdapter() {
        this.bookingService = new ImmutableExternalBookingService();
    }

    @Override
    public String fetchHotels() {
        return bookingService.fetchBookingHotels();
    }
}
