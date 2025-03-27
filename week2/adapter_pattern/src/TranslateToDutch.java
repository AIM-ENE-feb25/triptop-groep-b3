public class TranslateToDutch {
    public static void main(String[] args) {
        Koenen koenen = new Koenen();
        koenen.openEnglishDutch();
        koenen.openDutchEnglish();

        IDictionaryAdapter dictionaryAdapter = new KoenenAdapter(koenen);
        System.out.println(dictionaryAdapter.translate("monkey"));
        System.out.println(dictionaryAdapter.translate("olifant"));
        System.out.println(dictionaryAdapter.translate("haai"));
        System.out.println(dictionaryAdapter.translate("schaap"));
//        System.out.println(dictionaryAdapter.getName());
        System.out.println("--------------------");

        Kramers kramers = new Kramers();
        IDictionaryAdapter dictionaryAdapter2 = new KramersAdapter(kramers);
        System.out.println(dictionaryAdapter2.translate("donkey"));
        System.out.println(dictionaryAdapter2.translate("monkey"));
        System.out.println(dictionaryAdapter2.translate("fox"));
        System.out.println(dictionaryAdapter2.translate("mouse"));
        System.out.println(dictionaryAdapter2.translate("submarine"));
//        System.out.println(dictionaryAdapter2.getName());
        System.out.println("--------------------");
    }
}