package hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.swing.text.html.parser.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {
    @Test
    void testToString() {
        String str = "Student{name=A, marks=[4]}";
        Student student = new Student("A");
        student.addGrade(4);
        assertEquals(str, student.toString());
    }

    @Test
    public void testHashCode() {
        int hash = 2062;
        Student student = new Student("A");
        student.addGrade(3);
        assertEquals(hash, student.hashCode());
    }

    @Test
    public void testFullEquals() {
        Student student = new Student("A");
        Student student1 = new Student("A");
        student.addGrade(3);
        student1.addGrade(3);
        assertEquals(student1, student);
    }

    @Test
    public void testNotEqualsMarks() {
        Student student = new Student("A");
        Student student1 = new Student("A");
        student.addGrade(3);
        student1.addGrade(4);
        assertNotEquals(student, student1);
    }

    @Test
    public void testNotEqualsNames() {
        Student student = new Student("A");
        Student student1 = new Student("B");
        assertNotEquals(student, student1);
    }

    @Test
    public void testNotEqualsObjects() {
        Student student = new Student("A");
        Object student1 = new Object();
        assertNotEquals(student, student1);
    }

    @Test
    public void testSetName() {
        Student student = new Student("A");
        student.setName("S");
        assertEquals("S", student.getName());
    }

    @Test
    public void testGetName() {
        String name = "A";
        Student student = new Student(name);
        assertEquals(name, student.getName());
    }

    @Test
    public void testSetGrade() {
        Student student = new Student("A");
        student.addGrade(2);
        assertEquals(1, student.getGrades().size());
        assertEquals(2, student.getGrades().get(0));
    }

    @RepeatedTest(value = 4, name = "корректные оценки добавляются в список")
    public void marksInRange(RepetitionInfo repetitionInfo) {
        Student stud = new Student("Vasyan");
        int num = repetitionInfo.getCurrentRepetition() + 1;
        stud.addGrade(num);
        assertEquals(stud.getGrades().get(0), num);
    }

    @ParameterizedTest(name = "добавление неверных оценок кидает исключение")
    @MethodSource("hw1.MarksGenerator#ints")
    public void marksNotInRange(int x) {
        Student stud = new Student("Vasyan");
        Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(x));
    }
}
