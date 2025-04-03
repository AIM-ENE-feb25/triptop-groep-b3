package han.triptop.groepB3.adapter;
import han.triptop.groepB3.service.ImmutableExternalTripadvisorService;
import org.springframework.stereotype.Component;

@Component
public class TripadvisorApiAdapter implements HotelApiAdapter{
    private final ImmutableExternalTripadvisorService tripadvisorService;

    public TripadvisorApiAdapter(ImmutableExternalTripadvisorService tripadvisorService) {
        this.tripadvisorService = tripadvisorService;
    }

    @Override
    public String fetchHotels() {
        return tripadvisorService.fetchTripadvisorHotels();
    }
}
