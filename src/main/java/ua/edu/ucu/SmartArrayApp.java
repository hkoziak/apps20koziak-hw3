package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;

public class SmartArrayApp {

    public static Object[]
            filterPositiveIntegersSortAndMultiplyByTwo(Object[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object firstObj, Object secObj) {
                return ((Integer) firstObj) - ((Integer) secObj);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistStudentNamesFromSecondYearWithGPAgtFourAndOrderedBySurname(
                    Student[] students) {
        final int YEAR = 2;
        final int GPAPR = 4;

        MyPredicate yearTwoAndGpaFour = new MyPredicate() {
            @Override
            public boolean test(Object st) {
                return ((Student) st).getYear() == YEAR
                        && (((Student) st).getGPA()) >= GPAPR;
            }
        };

        MyComparator surnames = new MyComparator() {
            @Override
            public int compare(Object firstObj, Object secObj) {
                return ((Student) firstObj).getSurname().compareTo(
                        ((Student) secObj).getSurname());
            }
        };

        MyFunction fullName = new MyFunction() {
            @Override
            public Object apply(Object st) {
                return ((Student) st).getSurname()
                        + " " +  ((Student) st).getName();
            }
        };

        SmartArray stArray =
                new MapDecorator(
                    new SortDecorator(
                            new FilterDecorator(
                                    new DistinctDecorator(
                                            new BaseArray(students)),
                                    yearTwoAndGpaFour), surnames), fullName);

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        Object[] result = stArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
