import java.util.*;

public class PerformanceChecker {

    public static void printCollection(Collection collection) {
        for (Object element : collection) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    public static void checkAdding(int count) {
        long timeArrayList;
        long timeLinkedList;
        long timeTreeSet;
        long timeHashSet;

        ArrayList<Student> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayList.add(new Student("John" + i, "GoJava"));
        }
        timeArrayList = System.currentTimeMillis() - start;

        LinkedList<Student> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayList.add(new Student("John" + i, "GoJava"));
        }
        timeLinkedList = System.currentTimeMillis() - start;

        TreeSet<Student> treeSet = new TreeSet<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayList.add(new Student("John" + i, "GoJava"));
        }
        timeTreeSet = System.currentTimeMillis() - start;

        HashSet<Student> hashSet = new HashSet<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayList.add(new Student("John" + i, "GoJava"));
        }
        timeHashSet = System.currentTimeMillis() - start;

        System.out.println("ArrayList:  " + timeArrayList);
        System.out.println("LinkedList: " + timeLinkedList);
        System.out.println("TreeSet:    " + timeTreeSet);
        System.out.println("HashSet:    " + timeHashSet);
    }

    public static void main(String[] args) {
        PerformanceChecker.checkAdding(1000000);
    }
}
