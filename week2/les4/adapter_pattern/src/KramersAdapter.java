public class KramersAdapter implements IDictionaryAdapter {
    private Kramers kramers;

    public KramersAdapter() {
        this.kramers = new Kramers();
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
