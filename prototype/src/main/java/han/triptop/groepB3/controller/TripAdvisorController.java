package han.triptop.groepB3.controller;

import han.triptop.groepB3.factory.ActivityFactory;
import han.triptop.groepB3.model.Activity;
import han.triptop.groepB3.service.TripAdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/tripadvisor")
public class TripAdvisorController {

    private final TripAdvisorService tripAdvisorService;
    private final ActivityFactory activityFactory;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    public TripAdvisorController(TripAdvisorService tripAdvisorService, ActivityFactory activityFactory) {
        this.tripAdvisorService = tripAdvisorService;
        this.activityFactory = activityFactory;
    }

    @GetMapping("/flights")
    public ResponseEntity<String> searchFlights(@RequestParam String query) {
        Activity activity = activityFactory.createFlightActivity(query);
        String response = tripAdvisorService.searchActivity(activity);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hotels")
    public ResponseEntity<String> searchHotels(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "USD") String currencyCode,
            @RequestParam(required = true) String geoId,
            @RequestParam(required = false) String checkIn,
            @RequestParam(required = false) String checkOut) {
        
        // If dates not provided, use current date + 1 day for check-in and current date + 3 days for check-out
        LocalDate today = LocalDate.now();
        String checkInDate = checkIn != null ? checkIn : today.plusDays(1).format(dateFormatter);
        String checkOutDate = checkOut != null ? checkOut : today.plusDays(3).format(dateFormatter);
        
        Activity activity = activityFactory.createHotelActivity(pageNumber, currencyCode, geoId, checkInDate, checkOutDate);
        String response = tripAdvisorService.searchActivity(activity);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<String> searchRestaurants(@RequestParam String locationId) {
        Activity activity = activityFactory.createRestaurantActivity(locationId);
        String response = tripAdvisorService.searchActivity(activity);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rentals")
    public ResponseEntity<String> searchRentals(
            @RequestParam(defaultValue = "POPULARITY") String sortOrder,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "USD") String currencyCode,
            @RequestParam(required = true) String geoId,
            @RequestParam(required = false) String arrival,
            @RequestParam(required = false) String departure) {
        
        // If dates not provided, use current date + 1 day for arrival and current date + 7 days for departure
        LocalDate today = LocalDate.now();
        String arrivalDate = arrival != null ? arrival : today.plusDays(1).format(dateFormatter);
        String departureDate = departure != null ? departure : today.plusDays(7).format(dateFormatter);
        
        Activity activity = activityFactory.createRentalActivity(sortOrder, page, currencyCode, geoId, arrivalDate, departureDate);
        String response = tripAdvisorService.searchActivity(activity);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cruises")
    public ResponseEntity<String> searchCruises(
            @RequestParam String destinationId,
            @RequestParam(defaultValue = "popularity") String order,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "USD") String currencyCode) {
        Activity activity = activityFactory.createCruiseActivity(destinationId, order, page, currencyCode);
        String response = tripAdvisorService.searchActivity(activity);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cars")
    public ResponseEntity<String> searchCars(
            @RequestParam(defaultValue = "RECOMMENDED") String order,
            @RequestParam(defaultValue = "20") int driverAge,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "USD") String currencyCode,
            @RequestParam(required = true) String pickUpPlaceId,
            @RequestParam(defaultValue = "AIRPORT") String pickUpLocationType,
            @RequestParam(required = false) String pickUpDate,
            @RequestParam(required = false) String dropOffDate,
            @RequestParam(defaultValue = "12:00") String pickUpTime,
            @RequestParam(defaultValue = "12:00") String dropOffTime) {
        
        // If dates not provided, use current date + 1 day for pickup and current date + 3 days for dropoff
        LocalDate today = LocalDate.now();
        String pickupDate = pickUpDate != null ? pickUpDate : today.plusDays(1).format(dateFormatter);
        String dropoffDate = dropOffDate != null ? dropOffDate : today.plusDays(3).format(dateFormatter);
        
        Activity activity = activityFactory.createCarActivity(order, driverAge, page, currencyCode,
                pickUpPlaceId, pickUpLocationType, pickupDate, dropoffDate, pickUpTime, dropOffTime);
        String response = tripAdvisorService.searchActivity(activity);
        return ResponseEntity.ok(response);
    }
} 