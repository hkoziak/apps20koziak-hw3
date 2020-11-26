package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;

// Tests every element and
// removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate predicate;

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
        Object[] cleanArr = new Object[idx];
        System.arraycopy(newArray, 0, cleanArr, 0, idx);
        return cleanArr;
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
