package eu.mithril.javafunctional.kata02;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentAnalyzer {

    private final List<Student> students;

    public StudentAnalyzer(List<Student> students) {
        this.students = students;
    }

    public double getAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public List<Student> getStudentsAboveGrade(double threshold) {
        return students.stream()
                .filter(student -> student.getGrade() > threshold)
                .collect(Collectors.toList());
    }

    public Map<String, List<Student>> groupBySubject() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getSubject));
    }

    public Student getBestStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getGrade))
                .orElse(null);
    }

    public Map<String, Double> getAverageGradeBySubject() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.averagingDouble(Student::getGrade)));
    }
}