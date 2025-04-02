package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class CarActivity implements Activity {
    private final String order;
    private final int driverAge;
    private final int page;
    private final String currencyCode;
    
    public CarActivity(String order, int driverAge, int page, String currencyCode) {
        this.order = order;
        this.driverAge = driverAge;
        this.page = page;
        this.currencyCode = currencyCode;
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
        return params;
    }
} 