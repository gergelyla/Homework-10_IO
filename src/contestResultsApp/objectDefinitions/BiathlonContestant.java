package contestResultsApp.objectDefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;

public class BiathlonContestant implements Comparable<BiathlonContestant> {
    private int contestantNumber;
    private String contestantName;
    private String countryCode;
    private SkiTimeResult skiTimeResult;
    private String firstShootingResult;
    private String secondShootingResult;
    private String thirdShootingResult;
    private SkiTimeResult finalResultAfterShootings;

    public BiathlonContestant() {
    }

    public BiathlonContestant(int contestantNumber, String contestantName, String countryCode, SkiTimeResult skiTimeResult, String firstShootingResult, String secondShootingResult, String thirdShootingResult) {
        this.contestantNumber = contestantNumber;
        this.contestantName = contestantName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingResult = firstShootingResult;
        this.secondShootingResult = secondShootingResult;
        this.thirdShootingResult = thirdShootingResult;
    }

    public int getContestantNumber() {
        return contestantNumber;
    }

    public String getContestantName() {
        return contestantName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public SkiTimeResult getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getFirstShootingResult() {
        return firstShootingResult;
    }

    public String getSecondShootingResult() {
        return secondShootingResult;
    }

    public String getThirdShootingResult() {
        return thirdShootingResult;
    }

    public void setContestantNumber(int contestantNumber) {
        this.contestantNumber = contestantNumber;
    }

    public void setContestantName(String contestantName) {
        this.contestantName = contestantName;
    }

    public void setSkiTimeResult(SkiTimeResult skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public void setFirstShootingResult(String firstShootingResult) {
        this.firstShootingResult = firstShootingResult;
    }

    public void setSecondShootingResult(String secondShootingResult) {
        this.secondShootingResult = secondShootingResult;
    }

    public void setThirdShootingResult(String thirdShootingResult) {
        this.thirdShootingResult = thirdShootingResult;
    }

    public SkiTimeResult getFinalResultAfterShootings() {
        return finalResultAfterShootings;
    }

    public void setFinalResultAfterShootings(SkiTimeResult finalResultAfterShootings) {
        this.finalResultAfterShootings = finalResultAfterShootings;
    }


    public BiathlonContestant calculateFinalResult(BiathlonContestant contestant) {
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

    public void calculatePenalty(BiathlonContestant contestant) {
        LocalTime initialTimeResult = contestant.getFinalResultAfterShootings().getSkiTimeResult();
        LocalTime calculatedTimeResult = initialTimeResult.plusSeconds(10);
        SkiTimeResult finalResultAfterShootings = new SkiTimeResult(calculatedTimeResult);
        contestant.setFinalResultAfterShootings(finalResultAfterShootings);
    }

    public SkiTimeResult readContestantTimeResult(String[] words) {
        String timeExpression = words[3];
        String[] expression = timeExpression.split(":");
        LocalTime time = LocalTime.of(0, Integer.parseInt(expression[0]), Integer.parseInt(expression[1]));
        SkiTimeResult timeResult = new SkiTimeResult(time);
        return timeResult;
    }

    public BiathlonContestant extractContestantDataFromImportedLine(BiathlonContestant contestant, String lines) {
        String[] words = lines.split(",");
        contestant.setContestantNumber(Integer.parseInt(words[0]));
        contestant.setContestantName(words[1]);
        contestant.setCountryCode(words[2]);
        contestant.setSkiTimeResult(contestant.readContestantTimeResult(words));
        contestant.setFirstShootingResult(words[4]);
        contestant.setSecondShootingResult(words[5]);
        contestant.setThirdShootingResult(words[6]);
        contestant.setFinalResultAfterShootings(contestant.calculateFinalResult(contestant).getFinalResultAfterShootings());
        return contestant;
    }

    @Override
    public int compareTo(BiathlonContestant o) {
        return finalResultAfterShootings.compareTo(o.getFinalResultAfterShootings());
    }

    @Override
    public String toString() {
        return "BiathlonContestant:" +
                " " + contestantNumber +
                " | " + contestantName + " | " + countryCode + " | " + skiTimeResult +
                " | " + firstShootingResult + " | " + secondShootingResult + " | " + thirdShootingResult + " | Final result after miss penalties: " + finalResultAfterShootings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BiathlonContestant)) return false;
        BiathlonContestant that = (BiathlonContestant) o;
        return contestantNumber == that.contestantNumber &&
                contestantName == that.contestantName &&
                countryCode == that.countryCode &&
                skiTimeResult == that.skiTimeResult &&
                firstShootingResult == that.firstShootingResult &&
                secondShootingResult == that.secondShootingResult &&
                thirdShootingResult == that.thirdShootingResult &&
                finalResultAfterShootings == that.finalResultAfterShootings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestantNumber, contestantName, countryCode, skiTimeResult, firstShootingResult, secondShootingResult, thirdShootingResult, finalResultAfterShootings);
    }
}
