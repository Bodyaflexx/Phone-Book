package phonebook;


public class BinarySearch extends SearchingAlgorithm {
    private String[] list;

    private int binarySearch(String[] a, String x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid].contains(x)) {
                return 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int getPartition(String[] names, int index1, int index2) {
        String pivotValue = names[index1];
        while (index1 < index2) {
            String value1;
            String value2;
            while ((value1 = names[index1]).compareTo(pivotValue) < 0) {
                index1 += 1;
            }
            while ((value2 = names[index2]).compareTo(pivotValue) > 0) {
                index2 -= 1;
            }
            names[index1] = value2;
            names[index2] = value1;
        }
        return index1;
    }


    private void quicksort(String[] names, int index1, int index2) {
        if (index1 >= index2) {
            return;
        }
        int pivotIndex = getPartition(names, index1, index2);
        quicksort(names, index1, pivotIndex);
        quicksort(names, pivotIndex + 1, index2);
    }


    @Override
    public void sort() {
        time.startSorting();
        String[] arr = file.toArray(new String[0]);
        quicksort(arr, 0, arr.length - 1);
        this.list = arr;
        time.endSorting();
    }

    @Override
    public void find() {
        sort();
        time.startSearch();
        int found = 0;
        for (String request : needPhones) {
            if (binarySearch(list, request) > -1) {
                found++;
            }
        }
        time.endSearch();
        time.printFoundEntries(found, needPhones.size());
        time.printAllTime();
        time.printSortingTime();
        time.printSearchingTime();
        System.out.println();
    }
}
