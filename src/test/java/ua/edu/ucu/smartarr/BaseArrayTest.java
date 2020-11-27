package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseArrayTest {

    private BaseArray baseArray;
    private Object[] preArray;

    @Before
    public void setUp() {
        preArray = new Integer[]{5, 4, 3, 2,1};
        baseArray = new BaseArray(preArray);
    }

    @Test
    public void testBaseArrayToArray() {
        Object[] result = baseArray.toArray();
        assertArrayEquals(preArray, result);
    }

    @Test
    public void testBaseArrayDescription() {
        String result = baseArray.operationDescription();
        assertEquals("BaseArray", result);
    }

    @Test
    public void testSize() {
        int size = baseArray.size();
        assertEquals(5, size);
    }
}
