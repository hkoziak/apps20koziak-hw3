package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] array;

    public BaseArray(Object[] arguments) {
        this.array = arguments.clone();
    }

    public Object[] toArray() {
        return array.clone();
    }

    public String operationDescription() {
        return "BaseArray";
    }

    public int size() {
        return array.length;
    }
}