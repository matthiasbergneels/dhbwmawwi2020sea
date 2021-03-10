package lecture.chapter9;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentsInContainers {

    public static void main(String[] args) {

        Set<Student> myStudentSet = new TreeSet<Student>();

        myStudentSet.add(new Student(12345, "Gabi", "Zeus", 22));
        myStudentSet.add(new Student(98273, "Hans", "Mayer", 23));
        myStudentSet.add(new Student(73829, "Florian", "Frisch", 21));
        myStudentSet.add(new Student(72112, "Gabi", "Zeus", 22));
        myStudentSet.add(new Student(93821, "Gabi", "Zeus", 22));

        // Dublikat
        myStudentSet.add(new Student(73829, "Florian2", "Frisch", 21));

        Iterator<Student> myStudentSetIterator = myStudentSet.iterator();
        while(myStudentSetIterator.hasNext()){
            Student myStudent = myStudentSetIterator.next();
            System.out.println(myStudent.getStudentId() + ": " + myStudent.getFamilyName() + ", " + myStudent.getName());
        }


        System.out.println("Anzahl Studenten: " + myStudentSet.size());

    }
}
