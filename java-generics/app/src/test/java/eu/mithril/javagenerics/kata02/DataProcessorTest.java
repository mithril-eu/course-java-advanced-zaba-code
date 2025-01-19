package eu.mithril.javagenerics.kata02;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Data Processor Tests")
public class DataProcessorTest {

    @Test
    @DisplayName("Should handle Integer data correctly")
    void shouldHandleIntegerData() {
        DataProcessor<Integer> processor = new DataProcessor<>();
        processor.addData(5);
        processor.addData(10);
        processor.addData(15);

        assertEquals(10.0, processor.getAverage(), 0.001);
    }

    @Test
    @DisplayName("Should accept list of numbers using wildcards")
    void shouldAcceptNumberList() {
        DataProcessor<Number> processor = new DataProcessor<>();
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(4.0, 5.0, 6.0);

        processor.addAll(integers);
        processor.addAll(doubles);

        assertEquals(3.5, processor.getAverage(), 0.001);
    }

    @Test
    @DisplayName("Should copy to destination list using super wildcard")
    void shouldCopyToDestination() {
        DataProcessor<Integer> processor = new DataProcessor<>();
        processor.addData(1);
        processor.addData(2);

        List<Number> destination = new ArrayList<>();
        processor.copyTo(destination);

        assertEquals(2, destination.size());
        assertTrue(destination.contains(1));
        assertTrue(destination.contains(2));
    }

    @Test
    @DisplayName("Should process data using handler")
    void shouldProcessDataWithHandler() {
        DataProcessor<Integer> processor = new DataProcessor<>();
        processor.addData(3);
        processor.addData(6);

        SummaryStatistics stats = new SummaryStatistics();
        processor.processData(stats::accept);

        assertEquals(4.5, stats.getAverage(), 0.001);
        assertEquals(3.0, stats.getMin(), 0.001);
        assertEquals(6.0, stats.getMax(), 0.001);
    }

    @Test
    @DisplayName("Should handle type hierarchies correctly")
    void shouldHandleTypeHierarchies() {
        DataProcessor<Number> processor = new DataProcessor<>();
        List<Integer> integers = List.of(1, 2);
        List<Double> doubles = List.of(3.0, 4.0);

        processor.addAll(integers);
        processor.addAll(doubles);

        List<Object> destination = new ArrayList<>();
        processor.copyTo(destination);

        assertEquals(4, destination.size());
    }

    @Test
    @DisplayName("Should accumulate statistics correctly")
    void shouldAccumulateStatistics() {
        DataProcessor<Double> processor = new DataProcessor<>();
        processor.addData(1.5);
        processor.addData(2.5);
        processor.addData(3.5);

        SummaryStatistics stats = new SummaryStatistics();
        processor.processData(stats::accept);

        assertEquals(2.5, stats.getAverage(), 0.001);
        assertEquals(1.5, stats.getMin(), 0.001);
        assertEquals(3.5, stats.getMax(), 0.001);
        assertEquals(3, stats.getCount());
    }
}