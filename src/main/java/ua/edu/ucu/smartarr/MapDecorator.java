package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private final MyFunction mapFunc;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.mapFunc = func;
    }

    private Object[] applyMapFunc() {
        Object[] newArray = this.getSmartArray().toArray();
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.mapFunc.apply(newArray[i]);
        }
        return newArray;
    }

    @Override
    public Object[] toArray() {
        return this.applyMapFunc();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
