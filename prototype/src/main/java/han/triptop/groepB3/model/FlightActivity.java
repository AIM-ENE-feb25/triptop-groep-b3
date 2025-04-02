package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class FlightActivity implements Activity {
    private final String query;
    
    public FlightActivity(String query) {
        this.query = query;
    }
    
    @Override
    public ActivityType getType() {
        return ActivityType.FLIGHT;
    }
    
    @Override
    public String getEndpoint() {
        return "/api/v1/flights/searchAirport";
    }
    
    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        params.put("query", query);
        return params;
    }
} 