package phonebook;



public class LinearSearch extends SearchingAlgorithm{
    @Override
    public void sort() {
    }


    @Override
    public void find() {
        time.startSearch();
        int found = 0;
        for(String needString : needPhones){
            for(String s : file){
                if (s.contains(needString)) {
                    found++;
                    break;
                }
            }
        }
        time.endSearch();
        time.printFoundEntries(found,needPhones.size());
        time.setLinearSearchTime();
        time.printLinearSearchTime();
    }
}
