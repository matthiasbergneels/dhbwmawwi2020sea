package lecture.chapter9;

public class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private String familyName;
    private int age;

    public Student(int studentId, String name, String familyName, int age) {
        this.studentId = studentId;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Natürliche Ordnung nach 1. Matrikel#, 2. Nachname, 3. Vorname
    @Override
    public int compareTo(Student o) {

        if(this.getStudentId() != o.getStudentId()){
            return this.getStudentId() - o.getStudentId();
        }

        if(!this.getFamilyName().equals(o.getFamilyName())){
            return this.getFamilyName().compareTo(o.getFamilyName());
        }

        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return studentId + ": " + familyName + ", " + name + "; " + age;
    }
}
