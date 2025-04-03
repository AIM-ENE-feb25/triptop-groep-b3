public class KoenenAdapter implements IDictionaryAdapter {
    private Koenen koenen;

    public KoenenAdapter() {
        this.koenen = new Koenen();
        this.koenen.openDutchEnglish();
        this.koenen.openEnglishDutch();
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
