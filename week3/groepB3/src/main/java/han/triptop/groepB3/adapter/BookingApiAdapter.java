package han.triptop.groepB3.adapter;

import han.triptop.groepB3.service.BookingService;

public class BookingApiAdapter implements HotelApiAdapter {
    private final BookingService bookingService;

    public BookingApiAdapter(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public String fetchHotels() {
        return bookingService.fetchHotels();
    }
}
