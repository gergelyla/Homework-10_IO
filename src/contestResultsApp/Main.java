package contestResultsApp;

import contestResultsApp.objectDefinitions.BiathlonContestant;
import contestResultsApp.objectDefinitions.SkiResultRpository;
import contestResultsApp.objectDefinitions.SkiTimeResult;

import java.io.*;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SkiResultRpository<BiathlonContestant> listOfBiathlonContestants = new SkiResultRpository<>();
        readContestantInfoFromFile(listOfBiathlonContestants);
        System.out.println("The list of contestants and related results are: ");
        listOfBiathlonContestants.listResultRepository();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        listOfBiathlonContestants.sortRepository();
        System.out.println("Contestant holding first place: ");
        listOfBiathlonContestants.listSpecificPlace(0);
        System.out.println(" ");
        System.out.println("Contestant holding second place: ");
        listOfBiathlonContestants.listSpecificPlace(1);
        System.out.println(" ");
        System.out.println("Contestant holding third place: ");
        listOfBiathlonContestants.listSpecificPlace(2);
        System.out.println(" ");
    }

    private static void readContestantInfoFromFile(SkiResultRpository<BiathlonContestant> listOfBiathlonContestants) {
        try {
            String filePath="test"+File.separator+"BiathlonResults.csv";
            Scanner fileReader = new Scanner(new FileReader(filePath));
            fileReader.useDelimiter(",");
            while (fileReader.hasNextLine()) {
                String lines = fileReader.nextLine().trim();
                BiathlonContestant contestant = new BiathlonContestant();
                listOfBiathlonContestants.addContestant(contestant.extractContestantDataFromImportedLine(contestant, lines));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input not successful!");
        }
    }

}
