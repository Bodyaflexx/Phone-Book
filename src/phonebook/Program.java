package phonebook;


public class Program {
    private SearchingAlgorithm searchingAlgorithm;

    public void startProgram() {
        lSearch();
        jSearch();
        bSearch();
        tSearch();
    }

    private void lSearch() {
        System.out.println("Start searching (linear search)...");
        searchingAlgorithm = new LinearSearch();
        setFiles();
        searchingAlgorithm.find();
    }

    private void jSearch() {
        System.out.println("\nStart searching (bubble sort + jump search)...");
        searchingAlgorithm = new JumpSearch();
        setFiles();
        searchingAlgorithm.find();
    }

    private void bSearch() {
        System.out.println("Start searching (quick sort + binary search)...");
        searchingAlgorithm = new BinarySearch();
        setFiles();
        searchingAlgorithm.find();
    }

    private void tSearch() {
        System.out.println("Start searching (hash table)...");
        searchingAlgorithm = new HashTableSearch();
        setFiles();
        searchingAlgorithm.find();
    }

    private void setFiles() {
        WorkWithFiles workWithFiles = new WorkWithFiles();
        workWithFiles.setPathToFIle("D:\\java\\Phone Book\\directory.txt\\");
        searchingAlgorithm.setFile(workWithFiles.readFile());
        workWithFiles.setPathToFIle("D:\\java\\Phone Book\\find.txt\\");
        searchingAlgorithm.setNeedPhones(workWithFiles.readFile());
    }

}
