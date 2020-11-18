package lecture.chapter5;

public class CallByValueOrReference {

    public static void main(String[] args) {


        // Call by Value --> Aufruf über den Wert
        // gilt bei allen einfachen / primitiven Datentype (int, boolean, double, ...)

        int numberA = 100;
        int numberB;

        // Call by Value --> es wird der aktuelle WERT übergeben
        numberB = numberA;

        numberA = numberA + 42;

        System.out.println("Wert in numberA: " + numberA); // --> 142
        System.out.println("Wert in numberB: " + numberB); // --> 100


        // Call by Reference --> Aufruf über den "Verweis"
        // gilt bei komplexen Datentypen

        Person ourTeacher = new Person();

        Person matthias;
        Person papa;
        Person hasiPups;

        // Call by Reference --> übergabe der REFERENZ und nicht WERT
        matthias = ourTeacher;
        papa = ourTeacher;
        hasiPups = ourTeacher;

        System.out.println("Blaues Auge ourTeacher? " + ourTeacher.isBlauesAuge());
        System.out.println("Blaues Auge matthias? " + matthias.isBlauesAuge());
        System.out.println("Blaues Auge papa? " + papa.isBlauesAuge());
        System.out.println("Blaues Auge hasiPups? " + hasiPups.isBlauesAuge());

        System.out.println("HasiPups war böse und wurde geschlagen!");
        hasiPups.hitPerson();

        System.out.println("Blaues Auge ourTeacher? " + ourTeacher.isBlauesAuge());
        System.out.println("Blaues Auge matthias? " + matthias.isBlauesAuge());
        System.out.println("Blaues Auge papa? " + papa.isBlauesAuge());
        System.out.println("Blaues Auge hasiPups? " + hasiPups.isBlauesAuge());



    }
}
