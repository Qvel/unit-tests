import entity.Human;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class HumanTest {
    /**
     * Rule for all tests
     */
    @Rule
    public TestRule timeout = new Timeout(100L,TimeUnit.MILLISECONDS);


    @Parameterized.Parameters
    public static Collection expectedResult(){
        return Stream.of(23).collect(Collectors.toList());
    }

    private int expectedResult;
    private Human human;

    public HumanTest(Integer expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp(){
        human = new Human();
    }

    @After
    public void afterTest(){

    }

    /**
     * Test for entity {@link Human}
     */
    @Test
    public void testHuman(){
        human.setAge(23);
        assertEquals(expectedResult,human.getAge());
        //fail("testHuman Fail");
    }
}
