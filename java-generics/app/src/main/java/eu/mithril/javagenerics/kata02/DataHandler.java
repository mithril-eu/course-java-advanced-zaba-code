package eu.mithril.javagenerics.kata02;

/**
 * Interface for handling data processing operations.
 * Demonstrates generic interface with bounded type parameter.
 */
public interface DataHandler<T extends Number> {
    void handle(T value);
}