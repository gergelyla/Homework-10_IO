import objectDefinitions.BiathlonContestant;
import objectDefinitions.SkiResultRpository;
import objectDefinitions.SkiTimeResult;

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
            Scanner fileReader = new Scanner(new FileReader("test\\BiathlonResults.csv"));
            fileReader.useDelimiter(",");
            while (fileReader.hasNextLine()) {
                String lines = fileReader.nextLine().trim();
                BiathlonContestant contestant = new BiathlonContestant();
                extractContestantDataFromImportedLine(listOfBiathlonContestants, contestant, lines);
            }
            System.out.println(listOfBiathlonContestants);
        } catch (FileNotFoundException e) {
            System.out.println("Input not successful!");
        }
    }

    private static void extractContestantDataFromImportedLine(SkiResultRpository<BiathlonContestant> listOfBiathlonContestants, BiathlonContestant contestant, String lines) {
        String[] words = lines.split(",");
        contestant.setContestantNumber(Integer.parseInt(words[0]));
        contestant.setContestantName(words[1]);
        contestant.setCountryCode(words[2]);
        contestant.setSkiTimeResult(readContestantTimeResult(words));
        contestant.setFirstShootingResult(words[4]);
        contestant.setSecondShootingResult(words[5]);
        contestant.setThirdShootingResult(words[6]);
        contestant.setFinalResultAfterShootings(calculateFinalResult(contestant).getFinalResultAfterShootings());
        listOfBiathlonContestants.addContestant(contestant);
    }

    private static BiathlonContestant calculateFinalResult(BiathlonContestant contestant) {
        String miss = "o";
        contestant.setFinalResultAfterShootings(contestant.getSkiTimeResult());
        for (int i = 0; i < contestant.getFirstShootingResult().length(); i++) {
            if (miss.equalsIgnoreCase(String.valueOf(contestant.getFirstShootingResult().charAt(i)))) {
                calculatePenalty(contestant);
            }
        }
        for (int i = 0; i < contestant.getSecondShootingResult().length(); i++) {
            if (miss.equalsIgnoreCase(String.valueOf(contestant.getSecondShootingResult().charAt(i)))) {
                calculatePenalty(contestant);
            }
        }
        for (int i = 0; i < contestant.getThirdShootingResult().length(); i++) {
            if (miss.equalsIgnoreCase(String.valueOf(contestant.getThirdShootingResult().charAt(i)))) {
                calculatePenalty(contestant);
            }
        }
        return contestant;
    }

    private static void calculatePenalty(BiathlonContestant contestant) {
        LocalTime initialTimeResult = contestant.getFinalResultAfterShootings().getSkiTimeResult();
        LocalTime calculatedTimeResult = initialTimeResult.plusSeconds(10);
        SkiTimeResult finalResultAfterShootings = new SkiTimeResult(calculatedTimeResult);
        contestant.setFinalResultAfterShootings(finalResultAfterShootings);
    }

    private static SkiTimeResult readContestantTimeResult(String[] words) {
        String timeExpression = words[3];
        String[] expression = timeExpression.split(":");
        LocalTime time = LocalTime.of(0, Integer.parseInt(expression[0]), Integer.parseInt(expression[1]));
        SkiTimeResult timeResult = new SkiTimeResult(time);
        return timeResult;
    }
}
