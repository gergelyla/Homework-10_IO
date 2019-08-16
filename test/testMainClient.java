

import contestResultsApp.objectDefinitions.BiathlonContestant;
import contestResultsApp.objectDefinitions.SkiResultRpository;
import contestResultsApp.objectDefinitions.SkiTimeResult;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.rules.ExpectedException;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class testMainClient {
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
        contestant = new BiathlonContestant(10,"Test Subject","DE",timeResult=new SkiTimeResult(LocalTime.of(0,30,15)),"xoxox","ooxxo","oxoxo");
        listOfBiathlonContestants=new SkiResultRpository<>();
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testCalculatePenalty() {
        //assertThat(calculatePenalty(contestant).calculateDistance(), is(32.88));
    }

}
