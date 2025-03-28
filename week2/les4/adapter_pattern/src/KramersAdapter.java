public class KramersAdapter implements IDictionaryAdapter {
    private Kramers kramers;

    public KramersAdapter(Kramers kramers) {
        this.kramers = kramers;
    }

    @Override
    public String translate(String word) {
        return kramers.find(word);
    }

    @Override
    public String getName() {
        return this.kramers.name;
    }
}
