import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetProcessor {

    public static void printCollection(Collection collection) {
        for (Object element : collection) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    public static Set<Student> union(Set<Student> set1, Set<Student> set2) {
        Set<Student> unionSet = new HashSet<Student>();
        for (Student set1Element : set1) {
            unionSet.add(set1Element);
        }
        boolean isUnique = true;
        for (Student set2Element : set1) {
            for (Student set1Element : set2) {
                if (set1Element.equals(set2Element)) {
                    isUnique = false;
                }
            }
            if (isUnique) {
                unionSet.add(set2Element);
            }
            isUnique = true;
        }
        return unionSet;
    }

    public static Set<Student> intersect(Set<Student> set1, Set<Student> set2) {
        Set<Student> intersectSet = new HashSet<Student>();
        boolean isUnique = true;
        for (Student set2Element : set1) {
            for (Student set1Element : set2) {
                if (set1Element.equals(set2Element)) {
                    isUnique = false;
                }
            }
            if (!isUnique) {
                intersectSet.add(set2Element);
            }
            isUnique = true;
        }
        return intersectSet;
    }

    public static void main(String[] args) {
        Set<Student> studentsSet1 = new HashSet<Student>();
        studentsSet1.add(new Student("John", "GoJava"));
        studentsSet1.add(new Student("Paul", "GoFrontend"));
        studentsSet1.add(new Student("Mike", "GoAndroid"));
        studentsSet1.add(new Student("Peter", "GoFrontend"));
        studentsSet1.add(new Student("Lisa", "GoJava"));
        studentsSet1.add(new Student("Bart", "GoAndroid"));
        studentsSet1.add(new Student("Homer", "GoJava"));
        studentsSet1.add(new Student("Meggy", "GoFrontend"));
        studentsSet1.add(new Student("Nikita", "GoJava"));
        studentsSet1.add(new Student("Marge", "GoJava"));
        studentsSet1.add(new Student("Antony", "GoJava"));

        Set<Student> studentsSet2 = new HashSet<Student>();
        studentsSet2.add(new Student("John", "GoJava"));
        studentsSet2.add(new Student("Paul", "GoFrontend"));
        studentsSet2.add(new Student("Mike", "GoAndroid"));
        studentsSet2.add(new Student("Homer", "GoFrontend"));
        studentsSet2.add(new Student("Lisa", "GoJava"));
        studentsSet2.add(new Student("Kate", "GoAndroid"));
        studentsSet2.add(new Student("Nike", "GoJava"));
        studentsSet2.add(new Student("Meggy", "GoFrontend"));
        studentsSet2.add(new Student("Nikita", "GoJava"));
        studentsSet2.add(new Student("Marge", "GoJava"));
        studentsSet2.add(new Student("Antony", "GoJava"));

        Set<Student> unionStudentSet = SetProcessor.union(studentsSet1, studentsSet2);
        Set<Student> intersectStudentSet = SetProcessor.intersect(studentsSet1, studentsSet2);
        System.out.print("Union: ");
        SetProcessor.printCollection(unionStudentSet);
        System.out.print("Intersect: ");
        SetProcessor.printCollection(intersectStudentSet);
    }
}
