package han.triptop.groepB3.model;

import java.util.Map;

public interface Activity {
    ActivityType getType();
    
    String getEndpoint();
    
    Map<String, String> getQueryParams();
} 