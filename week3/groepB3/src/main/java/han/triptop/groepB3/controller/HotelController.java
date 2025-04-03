package han.triptop.groepB3.controller;

import han.triptop.groepB3.adapter.BookingApiAdapter;
import han.triptop.groepB3.adapter.HotelApiAdapter;
import han.triptop.groepB3.adapter.TripadvisorApiAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class HotelController {
    private HotelApiAdapter bookingApiAdapter;

    public HotelController() {
        this.bookingApiAdapter = new BookingApiAdapter();
    }

    @GetMapping("/hotels")
    public String getAvailableHotelsBooking(@RequestParam String hotelProvider) throws IOException, InterruptedException {
        if(hotelProvider.equals("booking")){
            this.bookingApiAdapter = new BookingApiAdapter();
        } else if (hotelProvider.equals("tripadvisor")){
            this.bookingApiAdapter = new TripadvisorApiAdapter();
        }
        return bookingApiAdapter.fetchHotels();
    }
}
