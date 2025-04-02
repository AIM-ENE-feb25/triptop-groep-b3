package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class RentalActivity implements Activity {
    private final String sortOrder;
    private final int page;
    private final String currencyCode;
    
    public RentalActivity(String sortOrder, int page, String currencyCode) {
        this.sortOrder = sortOrder;
        this.page = page;
        this.currencyCode = currencyCode;
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
        return params;
    }
} 