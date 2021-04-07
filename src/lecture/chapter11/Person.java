package lecture.chapter11;

import java.io.Serializable;

public class Person implements Serializable {

    static final long serialVersionUID = 1L;

    private String name;
    private String familyName;
    private transient String fullName;

    public Person(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
        this.setFullName();
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

    public String getFullName() {
        return fullName;
    }

    private void setFullName() {
        this.fullName = this.getFamilyName() +"; "+ this.getName();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    private Object readResolve(){
        this.setFullName();
        return this;
    }

}
