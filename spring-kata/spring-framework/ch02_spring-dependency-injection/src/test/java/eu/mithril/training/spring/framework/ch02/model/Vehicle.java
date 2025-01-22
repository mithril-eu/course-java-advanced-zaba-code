package eu.mithril.training.spring.framework.ch02.model;

public class Vehicle {

    private String type = "car";

    private int year = 2017;

    public Vehicle() {
    }

    public Vehicle(final String type, final int year) {
        this.type = type;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return year + " " + type;
    }
}
