package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class RentalActivity implements Activity {
    private final String sortOrder;
    private final int page;
    private final String currencyCode;
    private final String geoId;
    private final String arrival;
    private final String departure;
    
    public RentalActivity(String sortOrder, int page, String currencyCode, String geoId, String arrival, String departure) {
        this.sortOrder = sortOrder;
        this.page = page;
        this.currencyCode = currencyCode;
        this.geoId = geoId;
        this.arrival = arrival;
        this.departure = departure;
    }
    
    @Override
    public ActivityType getType() {
        return ActivityType.RENTAL;
    }
    
    @Override
    public String getEndpoint() {
        return "/api/v1/rentals/rentalSearch";
    }
    
    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        params.put("sortOrder", sortOrder);
        params.put("page", String.valueOf(page));
        params.put("currencyCode", currencyCode);
        params.put("geoId", geoId);
        params.put("arrival", arrival);
        params.put("departure", departure);
        return params;
    }
} 