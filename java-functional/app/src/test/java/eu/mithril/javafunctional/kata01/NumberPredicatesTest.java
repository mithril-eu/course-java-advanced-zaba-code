package eu.mithril.javafunctional.kata01;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Number Predicates Kata")
class NumberPredicatesTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(
                -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11, 12, 15, 20, 25
        );
    }

    @Nested
    @DisplayName("Basic Predicates")
    class BasicPredicatesTests {

        @Test
        @DisplayName("Should filter even numbers")
        void shouldFilterEvenNumbers() {
            List<Integer> expected = List.of(-4, -2, 0, 2, 4, 6, 8, 10, 12, 20);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, NumberPredicates.IS_EVEN);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should filter positive numbers")
        void shouldFilterPositiveNumbers() {
            List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 20, 25);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, NumberPredicates.IS_POSITIVE);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should filter single digit numbers")
        void shouldFilterSingleDigitNumbers() {
            List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, NumberPredicates.IS_SINGLE_DIGIT);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Combined Predicates")
    class CombinedPredicatesTests {
        @Test
        @DisplayName("Should filter numbers that are both even and positive")
        void shouldFilterEvenAndPositiveNumbers() {
            Predicate<Integer> evenAndPositive = NumberPredicates.IS_EVEN.and(NumberPredicates.IS_POSITIVE);
            List<Integer> expected = List.of(2, 4, 6, 8, 10, 12, 20);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, evenAndPositive);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should filter numbers that are either even or single digit")
        void shouldFilterEvenOrSingleDigitNumbers() {
            Predicate<Integer> evenOrSingleDigit = NumberPredicates.IS_EVEN.or(NumberPredicates.IS_SINGLE_DIGIT);
            List<Integer> expected = List.of(-4, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 20);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, evenOrSingleDigit);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should filter non-even numbers using negate")
        void shouldFilterNotEvenNumbers() {
            List<Integer> expected = List.of(-5, -3, -1, 1, 3, 5, 7, 9, 11, 15, 25);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, NumberPredicates.IS_EVEN.negate());
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Custom Range Predicate")
    class RangePredicateTests {
        @Test
        @DisplayName("Should filter numbers between 0 and 10")
        void shouldFilterNumbersInRange() {
            Predicate<Integer> inRange = NumberPredicates.createRangePredicate(0, 10);
            List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, inRange);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should filter even positive numbers less than 20")
        void shouldFilterEvenPositiveNumbersLessThan20() {
            Predicate<Integer> evenPositiveLessThan20 = NumberPredicates.IS_EVEN
                    .and(NumberPredicates.IS_POSITIVE)
                    .and(NumberPredicates.createRangePredicate(0, 19));

            List<Integer> expected = List.of(2, 4, 6, 8, 10, 12);
            List<Integer> result = NumberPredicates.filterNumbers(numbers, evenPositiveLessThan20);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCasesTests {

        @Test
        @DisplayName("Should handle empty list")
        void shouldHandleEmptyList() {
            List<Integer> emptyList = List.of();
            List<Integer> result = NumberPredicates.filterNumbers(emptyList, NumberPredicates.IS_EVEN);
            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Should handle list with single element")
        void shouldHandleSingleElementList() {
            List<Integer> singleElement = List.of(42);
            List<Integer> result = NumberPredicates.filterNumbers(singleElement, NumberPredicates.IS_EVEN);
            assertEquals(List.of(42), result);
        }

    }
}