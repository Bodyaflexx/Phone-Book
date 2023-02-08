package phonebook;

import java.util.Hashtable;

public class HashTableSearch extends SearchingAlgorithm {
    private Hashtable<String, String> hashtable = new Hashtable<>();

    @Override
    public void sort() {
        time.startSorting();
        for (int i = 0; i < file.size(); i++) {
            hashtable.put(file.get(i), phones.get(i));
        }
        time.endSorting();
    }

    @Override
    public void find() {
        sort();
        time.startSearch();
        int found = 0;
        for (String s : needPhones) {
            if (hashtable.get(s) != null) {
                found++;
            }
        }
        time.endSearch();
        time.printFoundEntries(found,needPhones.size());
        time.printAllTime();
        time.printCreatingTime();
        time.printSearchingTime();
    }
}
