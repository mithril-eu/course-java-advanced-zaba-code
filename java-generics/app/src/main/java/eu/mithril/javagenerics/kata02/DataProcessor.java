package eu.mithril.javagenerics.kata02;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic data processor that works with numeric data types.
 * Demonstrates bounded type parameters and wildcard usage.
 */
public class DataProcessor<T extends Number> {
    private final List<T> data;

    public DataProcessor() {
        this.data = new ArrayList<>();
    }

    /**
     * Adds a single value to the processor.
     *
     * @param value the numeric value to add
     */
    public void addData(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        data.add(value);
    }

    /**
     * Adds all values from the provided list.
     * Uses extends wildcard as this method only reads from the list.
     *
     * @param values list of values to add
     */
    public void addAll(List<? extends T> values) {
        if (values == null) {
            throw new IllegalArgumentException("Values list cannot be null");
        }
        data.addAll(values);
    }

    /**
     * Copies all data to the destination list.
     * Uses super wildcard as this method only writes to the list.
     *
     * @param destination list to copy values to
     */
    public void copyTo(List<? super T> destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination list cannot be null");
        }
        destination.addAll(data);
    }

    /**
     * Calculates the average of all stored values.
     *
     * @return the average as a double
     */
    public double getAverage() {
        if (data.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (T value : data) {
            sum += value.doubleValue();
        }
        return sum / data.size();
    }

    /**
     * Processes each value using the provided handler.
     * Uses super wildcard as the handler accepts this type or any supertype.
     *
     * @param handler the data handler to process values
     */
    public void processData(DataHandler<? super T> handler) {
        if (handler == null) {
            throw new IllegalArgumentException("Handler cannot be null");
        }
        for (T value : data) {
            handler.handle(value);
        }
    }

    /**
     * Returns a copy of the stored data.
     *
     * @return list containing all stored values
     */
    public List<T> getData() {
        return new ArrayList<>(data);
    }
}