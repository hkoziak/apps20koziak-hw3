package ua.edu.ucu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    private Student student;
    private Student duplicate;
    private Student newStudent;

    @Before
    public void setUp() {
        student = new Student("Ivan", "Petrenko", 10, 5);
        duplicate = new Student(
                "Ivan", "Petrenko", 10, 5);
        newStudent = new Student("Marichka", "Chornychka",
                99, 1);
    }

    @Test
    public void testStudentGetGPA() {
        double gpa = student.getGPA();
        assertEquals(10, gpa, 0.0001);
    }

    @Test
    public void testStudentGetYear() {
        int year = student.getYear();
        assertEquals(5, year);
    }

    @Test
    public void testStudentGetName() {
        String name = student.getName();
        assertEquals("Ivan", name);
    }

    @Test
    public void testStudentGetSurname() {
        String surname = student.getSurname();
        assertEquals("Petrenko", surname);
    }

    @Test
    public void testToString() {
        String str = student.toString();
        assertEquals(
                "Student{name=Ivan, surname=Petrenko, GPA=10.0, year=5}",
                str);
    }

    @Test
    public void testEquals() {
        assertTrue(student.equals(duplicate));
        assertFalse(student.equals(newStudent));
    }

    @Test
    public void testStudentEqualsNull() {
        assertFalse(student.equals(null));
    }

    @Test
    public void testStudentEqualsWrongType() {
        assertFalse(student.equals("not Student object"));
    }
}
