package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyPredicate;

import static org.junit.Assert.*;

public class FilterDecoratorTest {

    private SmartArray smartArrayInteger;
    private Object[] exp;
    private MyPredicate pred;

    @Before
    public void setUp() {
        pred = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) >= 1 && ((Integer) t) <= 5;
            }
        };
        Object[] array = new Integer[]{-5, 1, 2, 3, 4, 5, 6, 10, 1};
        exp = new Integer[]{1, 2, 3, 4, 5, 1};
        smartArrayInteger = new FilterDecorator(
                new BaseArray(array), pred);
    }

    @Test
    public void testToArray() {
        assertArrayEquals(exp, smartArrayInteger.toArray());
    }

    @Test
    public void testOperationDescription() {
        assertEquals("FilterDecorator",
                smartArrayInteger.operationDescription());
    }

    @Test
    public void testSize() {
        assertEquals(6, smartArrayInteger.size());
    }
}
