package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;

import static org.junit.Assert.*;

public class SortDecoratorTest {

    private SmartArray smartArray;
    private MyComparator comp;
    private Object[] exp;

    @Before
    public void setUp() {
        comp = new MyComparator() {
            @Override
            public int compare(Object num1, Object num2) {
                return ((Integer) num1) - ((Integer) num2);
            }
        };
        Object[] array = new Integer[]{1, 5, 3, 2, 4};
        exp = new Integer[]{1, 2, 3, 4, 5};
        smartArray = new SortDecorator(new BaseArray(array), comp);
    }

    @Test
    public void testToArray() {
        assertArrayEquals(exp, smartArray.toArray());
    }

    @Test
    public void testOperationDescription() {
        assertEquals("SortDecorator", smartArray.operationDescription());
    }

    @Test
    public void testSize() {
        assertEquals(5, smartArray.size());
    }
}
