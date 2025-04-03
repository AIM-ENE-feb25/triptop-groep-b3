package han.triptop.groepB3.Factory;

import han.triptop.groepB3.adapter.BookingApiAdapter;
import han.triptop.groepB3.adapter.HotelApiAdapter;
import han.triptop.groepB3.adapter.TripadvisorApiAdapter;
import org.springframework.stereotype.Component;

@Component
public class HotelFactory {
    private final BookingApiAdapter bookingApiAdapter;
    private final TripadvisorApiAdapter tripadvisorApiAdapter;

    public HotelFactory(BookingApiAdapter bookingApiAdapter, TripadvisorApiAdapter tripadvisorApiAdapter) {
        this.bookingApiAdapter = bookingApiAdapter;
        this.tripadvisorApiAdapter = tripadvisorApiAdapter;
    }

    public HotelApiAdapter getAdapter(String hotelProvider) {
        if (hotelProvider.equals("booking")) {
            return bookingApiAdapter;
        } else if (hotelProvider.equals("tripadvisor")) {
            return tripadvisorApiAdapter;
        }
        throw new RuntimeException("Geen adapter gevonden!");
    }
}
