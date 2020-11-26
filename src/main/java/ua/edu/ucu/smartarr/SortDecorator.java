package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator com) {
        super(smartArray);
        this.comparator = com;
    }

    @Override
    public Object[] toArray() {
        Object[] array = this.smartArray.toArray();
        Arrays.sort(array, this.comparator);
        return array.clone();
    }

    @Override
    public String operationDescription() {
        return "SortDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
