package han.triptop.groepB3.controller;

import han.triptop.groepB3.factory.HotelFactory;
import han.triptop.groepB3.adapter.HotelApiAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class HotelController {
    private final HotelFactory hotelFactory;

    public HotelController(HotelFactory hotelFactory) {
        this.hotelFactory = hotelFactory;
    }

    @GetMapping("/hotels")
    public String getAvailableHotels(@RequestParam String hotelProvider) throws IOException, InterruptedException {
        HotelApiAdapter apiAdapter = hotelFactory.getAdapter(hotelProvider);
        return apiAdapter.fetchHotels();
    }
}
