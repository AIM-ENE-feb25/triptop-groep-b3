public class KoenenAdapter implements IDictionaryAdapter {
    private Koenen koenen;

    public KoenenAdapter(Koenen koenen) {
        this.koenen = koenen;
    }

    @Override
    public String translate(String word) {
        return koenen.lookUp(word);
    }

    @Override
    public String getName() {
        return this.koenen.name;
    }
}
