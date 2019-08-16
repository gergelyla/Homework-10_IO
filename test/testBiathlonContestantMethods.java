

import contestResultsApp.objectDefinitions.BiathlonContestant;
import contestResultsApp.objectDefinitions.SkiResultRpository;
import contestResultsApp.objectDefinitions.SkiTimeResult;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.rules.ExpectedException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class testBiathlonContestantMethods {
    private BiathlonContestant contestant;
    private SkiResultRpository<BiathlonContestant> listOfBiathlonContestants;
    private SkiTimeResult timeResult;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Before
    public void setup() {
        System.out.println("in setup");
        contestant = new BiathlonContestant(10, "Test Subject", "DE", timeResult = new SkiTimeResult(LocalTime.of(0, 30, 15)), "xoxox", "ooxxo", "oxoxo");
        listOfBiathlonContestants = new SkiResultRpository<>();
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testCalculateFinalResult() {
        contestant.calculateFinalResult(contestant).getFinalResultAfterShootings().equals(timeResult = new SkiTimeResult(LocalTime.of(0, 31, 35)));
    }

    @Test
    public void testExtractContestantDataFromImportedLine() {
        BiathlonContestant testContestant = new BiathlonContestant();
        BiathlonContestant resultContestant = new BiathlonContestant(27, "Piotr Smitzer", "CZ", timeResult = new SkiTimeResult(LocalTime.of(0, 30, 10)), "xxxxx", "xxxxx", "xxxxx");
        resultContestant.setFinalResultAfterShootings(timeResult = new SkiTimeResult(LocalTime.of(0, 30, 10)));
        String lineParseTest = "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        testContestant.extractContestantDataFromImportedLine(testContestant, lineParseTest).equals(resultContestant);
    }
}
