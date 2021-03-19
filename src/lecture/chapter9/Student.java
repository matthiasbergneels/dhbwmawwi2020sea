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


    /* --> selbst implementierte equals() und hashCode() Methode

    @Override
    public boolean equals(Object o){
        // alias Check
        if(this == o){
            return true;
        }

        // not null check
        if(o == null){
            return false;
        }

        // typ check --> wäre auch mit instance of möglich
        if(this.getClass() != o.getClass()){
            return false;
        }

        // Feld (Attribut) Vergleich
        Student s = (Student)o;

        if(this.getStudentId() != s.getStudentId()){
            return false;
        }

        if(!this.getFamilyName().equals(s.getFamilyName())){
            return false;
        }

        if(!this.getName().equals(s.getName())){
            return false;
        }
        // --> konsistent zu compareTo()
        //if(this.getAge() != s.getAge()){
        //    return false;
        //}



        return true;
    }

    @Override
    public int hashCode(){
        // --> konsistent zu compareTo()
        //return this.getStudentId() ^ this.getFamilyName().hashCode() ^ this.getName().hashCode() ^ this.getAge();

        return this.getStudentId() ^ this.getFamilyName().hashCode() ^ this.getName().hashCode();
    }

    */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return familyName != null ? familyName.equals(student.familyName) : student.familyName == null;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        return result;
    }
}
