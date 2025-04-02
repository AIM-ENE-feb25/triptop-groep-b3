package han.triptop.groepB3.controller;

import han.triptop.groepB3.factory.ActivityFactory;
import han.triptop.groepB3.model.Activity;
import han.triptop.groepB3.service.TripAdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tripadvisor")
public class TripAdvisorController {

    private final TripAdvisorService tripAdvisorService;
    private final ActivityFactory activityFactory;

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
            @RequestParam(defaultValue = "USD") String currencyCode) {
        Activity activity = activityFactory.createHotelActivity(pageNumber, currencyCode);
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
            @RequestParam(defaultValue = "USD") String currencyCode) {
        Activity activity = activityFactory.createRentalActivity(sortOrder, page, currencyCode);
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
            @RequestParam(defaultValue = "USD") String currencyCode) {
        Activity activity = activityFactory.createCarActivity(order, driverAge, page, currencyCode);
        String response = tripAdvisorService.searchActivity(activity);
        return ResponseEntity.ok(response);
    }
} 