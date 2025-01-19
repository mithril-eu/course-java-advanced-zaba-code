package eu.mithril.javafunctional.kata02;


import java.util.List;
import java.util.Map;

public class StudentAnalyzer {

    private final List<Student> students;

    public StudentAnalyzer(List<Student> students) {
        this.students = students;
    }

    // TODO: Implement using Stream API to calculate average grade for all students
    public double getAverageGrade() {
        return 0.0;
    }

    // TODO: Implement using Stream API to find students with grade above threshold
    public List<Student> getStudentsAboveGrade(double threshold) {
        return List.of();
    }

    // TODO: Implement using Stream API to group students by subject
    public Map<String, List<Student>> groupBySubject() {
        return Map.of();
    }

    // TODO: Implement using Stream API to find student with highest grade
    public Student getBestStudent() {
        return null;
    }

    // TODO: Implement using Stream API to get average grade by subject
    public Map<String, Double> getAverageGradeBySubject() {
        return Map.of();
    }
}