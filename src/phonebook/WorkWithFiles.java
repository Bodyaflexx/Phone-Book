package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkWithFiles {
    private String pathToFIle;

    public void setPathToFIle(String pathToFIle) {
        this.pathToFIle = pathToFIle;
    }

    public List<String> readFile() {
        File file = new File(pathToFIle);
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ignored) {
        }
        return result;
    }
}
