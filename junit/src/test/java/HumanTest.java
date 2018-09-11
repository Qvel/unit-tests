import entity.Human;
import org.junit.*;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class HumanTest {

    @Parameterized.Parameters
    public static Collection expectedResult(){
        return Stream.of(23).collect(Collectors.toList());
    }

    private int expectedResult;
    private Human human;
    private List mockedList;

    public HumanTest(Integer expectedResult) {
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp(){
        human = new Human();
        mockedList = mock(List.class);
    }

    @After
    public void afterTest(){
        //assertEquals(mockedList.get(0),"first");
    }

    /**
     * Test for entity {@link Human}
     */
    @Test
    @Ignore
    public void testHuman(){
        human.setAge(23);
        assertEquals(expectedResult,human.getAge());
        //fail("testHuman Fail");
    }

    @Test
    public void mockitoStart(){
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).clear();
        verify(mockedList).add("one");
    }

    @Test(expected = RuntimeException.class)
    public void stubbing(){
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        when(mockedList.size()).thenReturn(100);
        System.out.println(mockedList.size());
        System.out.println(mockedList.get(0));
        assertEquals(mockedList.size(),100);
        mockedList.get(1);
    }
}
