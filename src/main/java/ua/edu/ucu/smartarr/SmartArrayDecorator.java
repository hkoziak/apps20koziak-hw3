package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    private final SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public SmartArray getSmartArray() {
        return smartArray;
    }
}
