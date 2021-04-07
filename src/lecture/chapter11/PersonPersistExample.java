package lecture.chapter11;

import java.io.*;

public class PersonPersistExample {

    public static void main(String[] args) {

        File personPersistentFile = new File(System.getProperty("user.dir") + File.separator + "Person.dat");

        if(!personPersistentFile.exists()){
            try {
                personPersistentFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Schreibe eine Datei mit Objekt Stream
        try(FileOutputStream personFileOutputStream = new FileOutputStream(personPersistentFile);
            ObjectOutputStream personObjectOutputStream = new ObjectOutputStream(personFileOutputStream)){

            personObjectOutputStream.writeObject(new Person("Klaus", "Müller"));
            personObjectOutputStream.writeObject(new Person("Gabi", "Mayer"));
            personObjectOutputStream.writeObject(new Person("Hans", "Franz"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(FileInputStream personFileInputStream = new FileInputStream(personPersistentFile);
            ObjectInputStream personObjectInputStream = new ObjectInputStream(personFileInputStream)){

            while(true){
                try{
                    System.out.println(personObjectInputStream.readObject());
                }catch (EOFException e){
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
