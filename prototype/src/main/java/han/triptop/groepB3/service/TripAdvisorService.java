package han.triptop.groepB3.service;

import han.triptop.groepB3.model.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Service
public class TripAdvisorService {
    
    private final RestTemplate restTemplate;
    private final String apiHost;
    private final String apiKey;
    private final String baseUrl;
    
    public TripAdvisorService(
            RestTemplate restTemplate,
            @Value("${tripadvisor.api.host}") String apiHost,
            @Value("${tripadvisor.api.key}") String apiKey,
            @Value("${tripadvisor.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.apiHost = apiHost;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }
    
    /**
     * Search for activities based on the given Activity type
     * 
     * @param activity The activity to search for
     * @return The API response as a JSON object
     */
    public ResponseEntity<Object> searchActivity(Activity activity) {
        // Build the URL with query parameters
        URI uri = buildUri(activity);
        
        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", apiHost);
        headers.set("x-rapidapi-key", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // Create request entity
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
        
        // Make the API call
        ResponseEntity<Object> response = restTemplate.exchange(requestEntity, Object.class);
        
        // Return the JSON response object directly
        return response;
    }
    
    /**
     * Build the URI for the API request with query parameters
     * 
     * @param activity The activity containing endpoint and parameters
     * @return The constructed URI
     */
    private URI buildUri(Activity activity) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl + activity.getEndpoint());
        
        // Add query parameters
        Map<String, String> queryParams = activity.getQueryParams();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        
        return builder.build().toUri();
    }
} 