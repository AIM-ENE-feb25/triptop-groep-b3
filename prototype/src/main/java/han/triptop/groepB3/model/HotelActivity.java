package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class HotelActivity implements Activity {
    private final int pageNumber;
    private final String currencyCode;
    
    public HotelActivity(int pageNumber, String currencyCode) {
        this.pageNumber = pageNumber;
        this.currencyCode = currencyCode;
    }
    
    @Override
    public ActivityType getType() {
        return ActivityType.HOTEL;
    }
    
    @Override
    public String getEndpoint() {
        return "/api/v1/hotels/searchHotels";
    }
    
    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        params.put("pageNumber", String.valueOf(pageNumber));
        params.put("currencyCode", currencyCode);
        return params;
    }
} 