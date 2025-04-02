package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class RestaurantActivity implements Activity {
    private final String locationId;
    
    public RestaurantActivity(String locationId) {
        this.locationId = locationId;
    }
    
    @Override
    public ActivityType getType() {
        return ActivityType.RESTAURANT;
    }
    
    @Override
    public String getEndpoint() {
        return "/api/v1/restaurant/searchRestaurants";
    }
    
    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        params.put("locationId", locationId);
        return params;
    }
} 