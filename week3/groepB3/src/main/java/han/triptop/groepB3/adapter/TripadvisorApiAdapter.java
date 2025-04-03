package han.triptop.groepB3.adapter;
import han.triptop.groepB3.service.TripadvisorService;

public class TripadvisorApiAdapter implements HotelApiAdapter{
    private final TripadvisorService tripadvisorService;

    public TripadvisorApiAdapter(TripadvisorService tripadvisorService) {
        this.tripadvisorService = tripadvisorService;
    }

    @Override
    public String fetchHotels() {
        return tripadvisorService.fetchTripadvisorHotels();
    }
}
