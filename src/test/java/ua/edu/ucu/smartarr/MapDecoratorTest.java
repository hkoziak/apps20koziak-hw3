package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyFunction;

import static org.junit.Assert.*;

public class MapDecoratorTest {

    private SmartArray smartArray;
    private MyFunction func;
    private Object[] exp;

    @Before
    public void setUp() {
        func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Integer) t) * 2;
            }
        };
        Object[] array = new Integer[]{1, 2, 3, 4, 5};
        exp = new Integer[]{2, 4, 6, 8, 10};
        smartArray = new MapDecorator(new BaseArray(array), func);
    }

    @Test
    public void testToArray() {
        assertArrayEquals(exp, smartArray.toArray());
    }

    @Test
    public void testOperationDescription() {
        assertEquals("MapDecorator", smartArray.operationDescription());
    }

    @Test
    public void testSize() {
        assertEquals(5, smartArray.size());
    }
}
