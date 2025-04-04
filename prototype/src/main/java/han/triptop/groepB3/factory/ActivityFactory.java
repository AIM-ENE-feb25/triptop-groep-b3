package han.triptop.groepB3.factory;

import han.triptop.groepB3.model.*;

public class ActivityFactory {
    
    public Activity createFlightActivity(String query) {
        return new FlightActivity(query);
    }
    
    public Activity createHotelActivity(int pageNumber, String currencyCode, String geoId, String checkIn, String checkOut) {
        return new HotelActivity(pageNumber, currencyCode, geoId, checkIn, checkOut);
    }
    
    public Activity createRestaurantActivity(String locationId) {
        return new RestaurantActivity(locationId);
    }
    
    public Activity createRentalActivity(String sortOrder, int page, String currencyCode, String geoId, String arrival, String departure) {
        return new RentalActivity(sortOrder, page, currencyCode, geoId, arrival, departure);
    }
    
    public Activity createCruiseActivity(String destinationId, String order, int page, String currencyCode) {
        return new CruiseActivity(destinationId, order, page, currencyCode);
    }
    
    public Activity createCarActivity(String order, int driverAge, int page, String currencyCode,
                                     String pickUpPlaceId, String pickUpLocationType,
                                     String pickUpDate, String dropOffDate,
                                     String pickUpTime, String dropOffTime) {
        return new CarActivity(order, driverAge, page, currencyCode, 
                              pickUpPlaceId, pickUpLocationType, 
                              pickUpDate, dropOffDate,
                              pickUpTime, dropOffTime);
    }
} 