package eu.mithril.javagenerics.kata02;

/**
 * A class to collect statistical information about numeric data.
 */
public class SummaryStatistics {
    private double sum = 0.0;
    private int count = 0;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    public void accept(Number value) {
        double doubleValue = value.doubleValue();
        sum += doubleValue;
        count++;
        min = Math.min(min, doubleValue);
        max = Math.max(max, doubleValue);
    }

    public double getAverage() {
        return count > 0 ? sum / count : 0.0;
    }

    public double getMin() {
        return count > 0 ? min : 0.0;
    }

    public double getMax() {
        return count > 0 ? max : 0.0;
    }

    public int getCount() {
        return count;
    }
}
