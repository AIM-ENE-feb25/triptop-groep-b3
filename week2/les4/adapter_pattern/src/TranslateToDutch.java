public class TranslateToDutch {
    public static void main(String[] args) {
        IDictionaryAdapter dictionaryAdapter = new KoenenAdapter();
        System.out.println(dictionaryAdapter.translate("monkey"));
        System.out.println(dictionaryAdapter.translate("olifant"));
        System.out.println(dictionaryAdapter.translate("haai"));
        System.out.println(dictionaryAdapter.translate("schaap"));
//        System.out.println(dictionaryAdapter.getName());
        System.out.println("--------------------");

        IDictionaryAdapter dictionaryAdapter2 = new KramersAdapter();
        System.out.println(dictionaryAdapter2.translate("donkey"));
        System.out.println(dictionaryAdapter2.translate("monkey"));
        System.out.println(dictionaryAdapter2.translate("fox"));
        System.out.println(dictionaryAdapter2.translate("mouse"));
        System.out.println(dictionaryAdapter2.translate("submarine"));
//        System.out.println(dictionaryAdapter2.getName());
        System.out.println("--------------------");
    }
}