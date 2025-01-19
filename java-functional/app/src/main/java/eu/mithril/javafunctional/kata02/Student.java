package eu.mithril.javafunctional.kata02;

public class Student {

    private final String name;
    private final String subject;
    private final double grade;

    public Student(String name, String subject, double grade) {
        this.name = name;
        this.subject = subject;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s: %s - %.2f", name, subject, grade);
    }
}