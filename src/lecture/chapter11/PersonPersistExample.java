package lecture.chapter11;

import java.io.*;

public class PersonPersistExample {

    public static void main(String[] args) {

        File personPersistensFile = new File(System.getProperty("user.dir") + File.separator + "Person.dat");

        if(!personPersistensFile.exists()){
            try{
                personPersistensFile.createNewFile();
            }catch (IOException e){
                System.out.println("Fehler beim anlegen der Person-Datei.");
            }
        }

        // Schreiben von Objekten in eine Datei - serialisieren
        try(FileOutputStream personFileOutputStream = new FileOutputStream(personPersistensFile);
            ObjectOutputStream personObjectOutputStream = new ObjectOutputStream(personFileOutputStream)){

            personObjectOutputStream.writeObject(new Person("Klaus", "Müller"));
            personObjectOutputStream.writeObject(new Person("Gabi", "Mayer"));
            personObjectOutputStream.writeObject(new Person("Hanz", "Franz"));
            personObjectOutputStream.writeObject(new Person("Moni", "Franz"));
            personObjectOutputStream.writeObject(new Person("Hanna", "Franz"));

        }catch (IOException e){
            System.out.println("Fehler beim verarbeiten der Datei.");
        }


        // Lesen von Objekten aus einer Datei - deserialisiern
        try(FileInputStream personFileInputStream = new FileInputStream(personPersistensFile);
            ObjectInputStream personObjectInputStream = new ObjectInputStream(personFileInputStream)){

            while(true){
                try {
                    System.out.println(personObjectInputStream.readObject());
                }catch(EOFException e){
                    break;
                }
            }

        }catch (IOException e){
            System.out.println("Fehler beim lesen / schliessen der Datei.");
        }catch(ClassNotFoundException e){
            System.out.println("Klasse nicht bekannt.");
        }



    }
}
