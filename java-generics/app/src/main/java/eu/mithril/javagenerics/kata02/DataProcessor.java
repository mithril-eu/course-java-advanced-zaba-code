package eu.mithril.javagenerics.kata02;

import java.util.List;
import java.util.ArrayList;

/**
 * A generic data processor that works with numeric data types.
 * Demonstrates bounded type parameters and wildcard usage.
 */
public class DataProcessor<T extends Number> {
    private List<T> data;

    public DataProcessor() {
        this.data = new ArrayList<>();
    }

    public void addData(T value) {
        return; // TODO: Implement this method
    }

    public void addAll(List<? extends T> values) {
        return; // TODO: Implement this method
    }

    public void copyTo(List<? super T> destination) {
        return; // TODO: Implement this method
    }

    public double getAverage() {
        return 0.0; // TODO: Implement this method
    }

    public void processData(DataHandler<? super T> handler) {
        return; // TODO: Implement this method
    }

    public List<T> getData() {
        return new ArrayList<>(); // TODO: Implement this method
    }
}