package eu.mithril.javafunctional.kata02;


import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Student Analyzer Kata")
class StudentAnalyzerTest {

    private StudentAnalyzer analyzer;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        students = List.of(
                new Student("Ana", "Math", 4.5),
                new Student("Marko", "Math", 5.0),
                new Student("Ivan", "Physics", 4.8),
                new Student("Petra", "Math", 4.2),
                new Student("Luka", "Physics", 4.5),
                new Student("Mia", "Physics", 5.0)
        );
        analyzer = new StudentAnalyzer(students);
    }

    @Nested
    @DisplayName("Basic Analysis")
    class BasicAnalysisTests {
        @Test
        @DisplayName("Should calculate correct average grade")
        void shouldCalculateAverageGrade() {
            assertEquals(4.67, analyzer.getAverageGrade(), 0.01);
        }

        @Test
        @DisplayName("Should find students above grade threshold")
        void shouldFindStudentsAboveGrade() {
            List<Student> highGradeStudents = analyzer.getStudentsAboveGrade(4.5);
            assertEquals(3, highGradeStudents.size());
            assertTrue(highGradeStudents.stream().allMatch(s -> s.getGrade() > 4.5));
        }

        @Test
        @DisplayName("Should find the best student")
        void shouldFindBestStudent() {
            Student best = analyzer.getBestStudent();
            assertNotNull(best);
            assertEquals("Marko", best.getName());
            assertEquals(5.0, best.getGrade());
        }
    }

    @Nested
    @DisplayName("Grouping Operations")
    class GroupingOperationsTests {
        @Test
        @DisplayName("Should correctly group students by subject")
        void shouldGroupBySubject() {
            Map<String, List<Student>> grouped = analyzer.groupBySubject();
            assertEquals(2, grouped.size());
            assertEquals(3, grouped.get("Math").size());
            assertEquals(3, grouped.get("Physics").size());
        }

        @Test
        @DisplayName("Should calculate correct average grade by subject")
        void shouldCalculateAverageGradeBySubject() {
            Map<String, Double> averages = analyzer.getAverageGradeBySubject();
            assertEquals(4.57, averages.get("Math"), 0.01);
            assertEquals(4.77, averages.get("Physics"), 0.01);
        }
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCasesTests {
        @Test
        @DisplayName("Should handle empty student list")
        void shouldHandleEmptyList() {
            StudentAnalyzer emptyAnalyzer = new StudentAnalyzer(List.of());
            assertEquals(0.0, emptyAnalyzer.getAverageGrade());
            assertTrue(emptyAnalyzer.getStudentsAboveGrade(4.0).isEmpty());
            assertTrue(emptyAnalyzer.groupBySubject().isEmpty());
            assertNull(emptyAnalyzer.getBestStudent());
            assertTrue(emptyAnalyzer.getAverageGradeBySubject().isEmpty());
        }

        @Test
        @DisplayName("Should handle no students above threshold")
        void shouldHandleNoStudentsAboveThreshold() {
            List<Student> result = analyzer.getStudentsAboveGrade(5.1);
            assertTrue(result.isEmpty());
        }
    }
}