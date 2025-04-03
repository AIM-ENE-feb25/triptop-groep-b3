package han.triptop.groepB3.adapter;
import han.triptop.groepB3.service.ImmutableExternalTripadvisorService;

public class TripadvisorApiAdapter implements HotelApiAdapter{
    private final ImmutableExternalTripadvisorService immutableExternalTripadvisorService;

    public TripadvisorApiAdapter() {
        this.immutableExternalTripadvisorService = new ImmutableExternalTripadvisorService();
    }

    @Override
    public String fetchHotels() {
        return immutableExternalTripadvisorService.fetchTripadvisorHotels();
    }
}
