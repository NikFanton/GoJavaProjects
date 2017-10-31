import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    String course;

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public static void printStudents(List<Student> students, String course) {
        for (Student student : students) {
            if (student.getCourse().equals(course)) {
                System.out.println(student.getName());
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return (this.getName().equals(student.getName()) && this.getCourse().equals(student.getCourse()));
        }
        return false;
    }

    @Override
    public String toString() {
        return (this.name + " - " + this.course);
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("John", "GoJava"));
        students.add(new Student("Paul", "GoFrontend"));
        students.add(new Student("Mike", "GoAndroid"));
        students.add(new Student("Ann", "GoFrontend"));
        students.add(new Student("Lisa", "GoJava"));
        students.add(new Student("Bart", "GoAndroid"));
        students.add(new Student("Homer", "GoJava"));
        students.add(new Student("Meggy", "GoFrontend"));
        students.add(new Student("Nikita", "GoJava"));
        students.add(new Student("Marge", "GoJava"));
        Student.printStudents(students, "GoJava");
    }
}
