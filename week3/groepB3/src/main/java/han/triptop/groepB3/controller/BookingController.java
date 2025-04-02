package han.triptop.groepB3.controller;

import han.triptop.groepB3.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/hotels")
    public String getAvailableHotels() throws IOException, InterruptedException {
        return bookingService.findHotels();
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
