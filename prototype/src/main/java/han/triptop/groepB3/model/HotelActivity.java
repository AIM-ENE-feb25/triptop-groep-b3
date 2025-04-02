package han.triptop.groepB3.model;

import java.util.HashMap;
import java.util.Map;

public class HotelActivity implements Activity {
    private final int pageNumber;
    private final String currencyCode;
    private final String geoId;
    private final String checkIn;
    private final String checkOut;
    
    public HotelActivity(int pageNumber, String currencyCode, String geoId, String checkIn, String checkOut) {
        this.pageNumber = pageNumber;
        this.currencyCode = currencyCode;
        this.geoId = geoId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
        params.put("geoId", geoId);
        params.put("checkIn", checkIn);
        params.put("checkOut", checkOut);
        return params;
    }
} 