package han.triptop.groepB3.factory;

import han.triptop.groepB3.model.*;

/**
 * Factory class for creating different types of Activity objects.
 * This implements the Factory design pattern to create different activity types
 * without the client needing to know the specific implementation details.
 */
public class ActivityFactory {
    
    /**
     * Creates a Flight activity
     * 
     * @param query The airport query string
     * @return A Flight activity
     */
    public Activity createFlightActivity(String query) {
        return new FlightActivity(query);
    }
    
    /**
     * Creates a Hotel activity
     * 
     * @param pageNumber The page number for pagination
     * @param currencyCode The currency code (e.g., USD)
     * @return A Hotel activity
     */
    public Activity createHotelActivity(int pageNumber, String currencyCode) {
        return new HotelActivity(pageNumber, currencyCode);
    }
    
    /**
     * Creates a Restaurant activity
     * 
     * @param locationId The location ID
     * @return A Restaurant activity
     */
    public Activity createRestaurantActivity(String locationId) {
        return new RestaurantActivity(locationId);
    }
    
    /**
     * Creates a Rental activity
     * 
     * @param sortOrder The sort order
     * @param page The page number
     * @param currencyCode The currency code
     * @return A Rental activity
     */
    public Activity createRentalActivity(String sortOrder, int page, String currencyCode) {
        return new RentalActivity(sortOrder, page, currencyCode);
    }
    
    /**
     * Creates a Cruise activity
     * 
     * @param destinationId The destination ID
     * @param order The sort order
     * @param page The page number
     * @param currencyCode The currency code
     * @return A Cruise activity
     */
    public Activity createCruiseActivity(String destinationId, String order, int page, String currencyCode) {
        return new CruiseActivity(destinationId, order, page, currencyCode);
    }
    
    /**
     * Creates a Car activity
     * 
     * @param order The sort order
     * @param driverAge The driver's age
     * @param page The page number
     * @param currencyCode The currency code
     * @return A Car activity
     */
    public Activity createCarActivity(String order, int driverAge, int page, String currencyCode) {
        return new CarActivity(order, driverAge, page, currencyCode);
    }
} 