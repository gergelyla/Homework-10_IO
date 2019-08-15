package objectDefinitions;

import java.util.Objects;

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
}
