package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class CarActivity implements Activity {
    private final String order;
    private final int driverAge;
    private final int page;
    private final String currencyCode;
    private final String pickUpPlaceId;
    private final String pickUpLocationType;
    private final String pickUpDate;
    private final String dropOffDate;
    private final String pickUpTime;
    private final String dropOffTime;
    
    public CarActivity(String order, int driverAge, int page, String currencyCode, 
                      String pickUpPlaceId, String pickUpLocationType, 
                      String pickUpDate, String dropOffDate,
                      String pickUpTime, String dropOffTime) {
        this.order = order;
        this.driverAge = driverAge;
        this.page = page;
        this.currencyCode = currencyCode;
        this.pickUpPlaceId = pickUpPlaceId;
        this.pickUpLocationType = pickUpLocationType;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }
    
    @Override
    public ActivityType getType() {
        return ActivityType.CAR;
    }
    
    @Override
    public String getEndpoint() {
        return "/api/v1/cars/searchCarsSameDropOff";
    }
    
    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        params.put("order", order);
        params.put("driverAge", String.valueOf(driverAge));
        params.put("page", String.valueOf(page));
        params.put("currencyCode", currencyCode);
        params.put("pickUpPlaceId", pickUpPlaceId);
        params.put("pickUpLocationType", pickUpLocationType);
        params.put("pickUpDate", pickUpDate);
        params.put("dropOffDate", dropOffDate);
        params.put("pickUpTime", pickUpTime);
        params.put("dropOffTime", dropOffTime);
        return params;
    }
} 