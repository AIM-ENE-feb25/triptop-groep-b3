package han.triptop.groepB3.adapter;
import han.triptop.groepB3.service.ExternalTripadvisorService;
import org.springframework.stereotype.Component;

@Component
public class TripadvisorApiAdapter implements HotelApiAdapter{
    private final ExternalTripadvisorService tripadvisorService;

    public TripadvisorApiAdapter(ExternalTripadvisorService tripadvisorService) {
        this.tripadvisorService = tripadvisorService;
    }

    @Override
    public String fetchHotels() {
        return tripadvisorService.fetchTripadvisorHotels();
    }
}
