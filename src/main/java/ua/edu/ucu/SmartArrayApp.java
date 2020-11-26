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

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
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
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                    Student[] students) {
        final int year = 2;
        final int gpaPred = 4;

        MyPredicate Year2AndGpa4 = new MyPredicate() {
            @Override
            public boolean test(Object st) {
                return ((Student) st).getYear() == 2
                        && (((Student) st).getGPA()) >= 4;
            }
        };

        MyComparator surnames = new MyComparator() {
            @Override
            public int compare(Object st1, Object st2) {
                return ((Student) st1).getSurname().compareTo(
                        ((Student) st2).getSurname());
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
                                    Year2AndGpa4), surnames), fullName);

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        Object[] result = stArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
