package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;

// Tests every element and
// removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private final MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    private Object[] filterByPred(Object[] array) {
        Object[] newArray = new Object[array.length];
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (this.predicate.test(array[i])) {
                newArray[idx] = array[i];
                idx++;
            }
        }
        return Arrays.copyOf(newArray, idx);
    }

    @Override
    public Object[] toArray() {
        return filterByPred(this.smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
