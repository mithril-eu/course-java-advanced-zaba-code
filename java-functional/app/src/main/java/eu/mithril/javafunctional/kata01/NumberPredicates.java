package eu.mithril.javafunctional.kata01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NumberPredicates {

    public static final Predicate<Integer> IS_POSITIVE = num -> num > 0;
    public static final Predicate<Integer> IS_EVEN = num -> num % 2 == 0;
    public static final Predicate<Integer> IS_SINGLE_DIGIT = num -> num >= 0 && num < 10;

    public static Predicate<Integer> createRangePredicate(int min, int max) {
        return num -> num >= min && num <= max;
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