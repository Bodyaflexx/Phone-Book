package phonebook;


public class JumpSearch extends SearchingAlgorithm {
    private boolean isBadSort = false;

    @Override
    public void sort() {
        time.startSorting();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < file.size() - 1; i++) {
                if (file.get(i).compareTo(file.get(i + 1)) > 0) {
                    isSorted = false;

                    String tmp = file.get(i);
                    file.set(i, file.get(i + 1));
                    file.set(i + 1, tmp);
                }
                time.endSorting();
                if (time.getAllSearchingTime() * 15 < time.getAllSortingTime()) {
                    isBadSort = true;
                    break;
                }
            }
            if (isBadSort) {
                break;
            }
        }
        time.endSorting();
    }

    @Override
    public void find() {
        sort();
        int count = 0;
        if (isBadSort) {
            linearSearch();
            time.printFoundEntries(linearSearch(),needPhones.size());
            time.printAllTime();
            time.printSortingTime();
            System.out.print(" - STOPPED, moved to linear search");
            time.printSearchingTime();
            System.out.println();
        } else {
            time.startSearch();
            for (String s : needPhones) {
                int blockSize = (int) Math.floor(Math.sqrt(file.size()));

                int currentLastIndex = blockSize - 1;

                while (currentLastIndex < file.size() && file.get(currentLastIndex).compareTo(s) < 0) {
                    currentLastIndex += blockSize;
                }

                for (int currentSearchIndex = currentLastIndex - blockSize + 1;
                     currentSearchIndex <= currentLastIndex && currentSearchIndex < file.size(); currentSearchIndex++) {
                    if (file.get(currentSearchIndex).contains(s)) {
                        count++;
                    }
                }
            }
            time.endSearch();
            time.printFoundEntries(count,needPhones.size());
            time.printAllTime();
            time.printSortingTime();
            time.printSearchingTime();
        }
    }

    private int linearSearch() {
        time.startSearch();
        int found = 0;
        for (String needString : needPhones) {
            for (String s : file) {
                if (s.contains(needString)) {
                    found++;
                    break;
                }
            }
        }
        time.endSearch();
        return found;
    }
}
