package eu.mithril.javafunctional.kata01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NumberPredicates {

    // TODO: Implement these predicates correctly to make tests pass
    public static final Predicate<Integer> IS_EVEN = num -> false;        // Replace with correct implementation
    public static final Predicate<Integer> IS_POSITIVE = num -> false;    // Replace with correct implementation
    public static final Predicate<Integer> IS_SINGLE_DIGIT = num -> false; // Replace with correct implementation

    // TODO: Implement this method to make tests pass
    public static Predicate<Integer> createRangePredicate(int min, int max) {
        return num -> false; // Replace with correct implementation
    }

    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }

}