package phonebook;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchingAlgorithm {
    Time time = new Time();
    List<String> file = new ArrayList<>();
    List<String> phones = new ArrayList<>();
    List<String> needPhones = new ArrayList<>();


    public void setNeedPhones(List<String> needPhones) {
        this.needPhones = needPhones;
    }

    public void setFile(List<String> file) {
        for(String s : file){
            this.phones.add(s.replaceAll("[^0-9]*","").trim());
        }
        for(String s : file){
            this.file.add(s.replaceAll("[0-9]*","").trim());
        }
    }

    abstract  void sort();
    abstract void find();
}
