package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray.
// Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator  {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    private Object[] deleteRepeats(Object[] oldArray) {
        Object[] newArray = new Object[oldArray.length];
        int idx = 0;
        for (int i = 0; i < oldArray.length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (oldArray[i].equals(oldArray[j])) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                newArray[idx] = oldArray[i];
                idx++;
            }
        }
        Object[] cleanArr = new Object[idx];
        System.arraycopy(newArray, 0, cleanArr, 0, idx);
        return cleanArr;
    }

    @Override
    public Object[] toArray() {
        return deleteRepeats(this.smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
