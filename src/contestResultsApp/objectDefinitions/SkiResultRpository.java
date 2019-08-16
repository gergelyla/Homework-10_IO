package contestResultsApp.objectDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkiResultRpository<T extends BiathlonContestant> {
    private List<BiathlonContestant> listOfBiathlonContestants = new ArrayList<>();

    public void addContestant(T obj) {
        listOfBiathlonContestants.add(obj);
    }

    public void listResultRepository() {
        for (int i = 0; i < listOfBiathlonContestants.size(); i++) {
            System.out.println(listOfBiathlonContestants.get(i));
        }
    }

    public void listSpecificPlace(int counter) {
        System.out.println(listOfBiathlonContestants.get(counter));
    }

    public void sortRepository() {
        Collections.sort(listOfBiathlonContestants);
    }
}
