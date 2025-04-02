package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class CruiseActivity implements Activity {
    private final String destinationId;
    private final String order;
    private final int page;
    private final String currencyCode;
    
    public CruiseActivity(String destinationId, String order, int page, String currencyCode) {
        this.destinationId = destinationId;
        this.order = order;
        this.page = page;
        this.currencyCode = currencyCode;
    }
    
    @Override
    public ActivityType getType() {
        return ActivityType.CRUISE;
    }
    
    @Override
    public String getEndpoint() {
        return "/api/v1/cruises/searchCruises";
    }
    
    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        params.put("destinationId", destinationId);
        params.put("order", order);
        params.put("page", String.valueOf(page));
        params.put("currencyCode", currencyCode);
        return params;
    }
} 