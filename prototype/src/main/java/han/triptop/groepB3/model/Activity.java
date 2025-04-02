package han.triptop.groepB3.model;

import java.util.Map;

/**
 * Interface representing any type of activity that can be searched via the TripAdvisor API
 */
public interface Activity {
    /**
     * Get the type of activity
     * 
     * @return The activity type
     */
    ActivityType getType();
    
    /**
     * Get the API endpoint path for this activity type
     * 
     * @return String representing the endpoint path
     */
    String getEndpoint();
    
    /**
     * Get the query parameters for this activity type
     * 
     * @return Map of query parameters and their values
     */
    Map<String, String> getQueryParams();
} 