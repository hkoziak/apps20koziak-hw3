package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class DistinctDecoratorTest {

    private SmartArray smartArray;
    private Object[] array;

    @Before
    public void setUp() {
        array = new String[]{"a", "b", "c", "d", "a", "b"};
        smartArray = new DistinctDecorator(new BaseArray(array));
        array = new String[]{"a", "b", "c", "d"};
    }

    @Test
    public void testToArray() {
        assertArrayEquals(array, smartArray.toArray());
    }

    @Test
    public void testOperationDescription() {
        assertEquals("DistinctDecorator",
                smartArray.operationDescription());
    }

    @Test
    public void testSize() {
        assertEquals(4, smartArray.size());
    }
}
