package lecture.chapter11;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class FileSystemExample {

    public static void main(String[] args) {

        System.out.println("Liste von Laufwerken / root Verzeichnis: ");
        System.out.println("=========================================");
        File[] rootList = File.listRoots();

        for(File root : rootList){
            System.out.println("Pfad: " + root.getPath());
            System.out.println("- existiert: " + root.exists());
            System.out.println("- Lesezugriff: " + root.canRead());
            System.out.println("- Schreibzugriff: " + root.canWrite());
        }


        System.out.println("System Properties in Java: ");
        System.out.println("=========================================");
        Properties systemProperties = System.getProperties();

        Set systemPropertiesKeys = systemProperties.keySet();
        for(Object key : systemPropertiesKeys){
            System.out.println(key + ": " + systemProperties.get(key));
        }


        System.out.println("Ausgabe von allen Inhalten aus user.dir: ");
        System.out.println("=========================================");

        File userDir = new File(System.getProperty("user.dir"));

        System.out.println("Name: "+ userDir.getName());
        System.out.println("Pfad: "+ userDir.getPath());
        System.out.println("Ist Verzechnis: " + userDir.isDirectory());
        System.out.println("Ist Datei: " + userDir.isFile());
        System.out.println("Berechtigungen:  " + (userDir.canRead() ? "r" : "-") + " / " + (userDir.canWrite() ? "w" : "-"));

        System.out.println("Inhalt von " + userDir.getName() + ":");
        System.out.println("=====================================");

        listDirectoryAndContent(userDir, 0);


        System.out.println("Umgang mit Verzeichnissen und Dateien");
        System.out.println("=====================================");

        System.out.println(System.getProperty("user.dir") + File.separator + "myDirectory");
        File myDirectory = new File(System.getProperty("user.dir") + File.separator + "myDirectory");
        File myRenameDirectory = new File(System.getProperty("user.dir") + File.separator + "myRenamedDirectory");


        // anlegen von Verzeichnissen
        if(!myDirectory.exists()){
            myDirectory.mkdir();
            System.out.println("Verzeichnis " + myDirectory.getPath() + " angelegt.");
            System.out.println(myDirectory.getPath() + ": " + myDirectory.exists());
            System.out.println(myRenameDirectory.getPath() + ": " + myRenameDirectory.exists());
        }

        // umbennenen von Verzeichnissen
        if(myDirectory.exists() && !myRenameDirectory.exists()){
            myDirectory.renameTo(myRenameDirectory);
            System.out.println("Verzeichnis " + myDirectory.getPath() + " umbenennat in " + myRenameDirectory.getPath());
            System.out.println(myDirectory.getPath() + ": " + myDirectory.exists());
            System.out.println(myRenameDirectory.getPath() + ": " + myRenameDirectory.exists());
        }

        // Umgang mit Dateien
        File myFile = new File(myRenameDirectory.getPath() + File.separator + "myFile.txt");
        File myRenamedFile = new File(myRenameDirectory.getPath() + File.separator + "myRenamedFile.txt");

        // Datei anlegen
        if(!myFile.exists()){
            try{
                myFile.createNewFile();
                System.out.println("Datei " + myFile.getName() + " angelegt");
                System.out.println(myFile.getPath() + ": " + myFile.exists());
                System.out.println(myRenamedFile.getPath() + ": " + myRenamedFile.exists());
            }catch (IOException e){
                System.out.println("Datei anlegen ist schief gegangen!");
            }
        }

        // umbenennen von Dateien
        if(myFile.exists() && !myRenamedFile.exists()){

            myFile.renameTo(myRenamedFile);
            System.out.println("Datei " + myFile.getName() + " umbenennat in " + myRenamedFile.getName());
            System.out.println(myFile.getPath() + ": " + myFile.exists());
            System.out.println(myRenamedFile.getPath() + ": " + myRenamedFile.exists());
        }

        // löschen von Dateien
        if(myRenamedFile.exists()){
            myRenamedFile.delete();
            System.out.println("Datei " + myRenamedFile.getName() + " geleöscht");
            System.out.println(myFile.getPath() + ": " + myFile.exists());
            System.out.println(myRenamedFile.getPath() + ": " + myRenamedFile.exists());
        }

        // löschen von Verzeichnissen
        if(myRenameDirectory.exists()){
            myRenameDirectory.delete();
            System.out.println("Verzeichnis " + myRenameDirectory.getPath() + " wurde gelöscht.");
            System.out.println(myDirectory.getPath() + ": " + myDirectory.exists());
            System.out.println(myRenameDirectory.getPath() + ": " + myRenameDirectory.exists());
        }


        System.out.println("Einlesen von Daten über System.in (Bytes)");
        System.out.println("=====================================");

        byte[] input = new byte[255];

        System.out.print("Geben Sie einen Text ein: ");

        try {
            System.in.read(input, 0, 255);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(input);
        System.out.println(new String(input) + "!");

        System.out.println("Einlesen von Daten über System.in (Char)");
        System.out.println("=====================================");

        InputStreamReader systemIn = new InputStreamReader(System.in);
        BufferedReader systemInReader = new BufferedReader(systemIn);

        ArrayList<String> inputTextList = new ArrayList<>();
        String inputText = "";

        System.out.println("Bitte geben Sie einen Text ein (Beenden mit exit):");

        while(true){
            try {
                inputText = systemInReader.readLine();
                if(inputText.equalsIgnoreCase("exit")){
                    break;
                }
                inputTextList.add(inputText);
            }catch (IOException e){
                System.out.println("Fehler bei der Eingabe über Konsole.");
            }
        }

        System.out.println("Eingebener Text:");
        for(String line : inputTextList){
            System.out.println(line);
        }

        File myTextFile = new File(System.getProperty("user.dir") + File.separator + "myTextFile.txt");

        if(!myTextFile.exists()){
            try{
            myTextFile.createNewFile();
            }catch (IOException e){
                System.out.println("Fehler beim Anlegen der Textdatei.");
            }
        }

        try (FileWriter myTextFileWriter = new FileWriter(myTextFile);) {

            for(String line : inputTextList){
                myTextFileWriter.write(line + "\n");
            }
        }catch(IOException e){
            System.out.println("Fehler beim öffnen der Datei.");
        }


        System.out.println("Auslesen aus Datei");
        System.out.println("=====================================");

        try(FileReader myTextFileReader = new FileReader(myTextFile);
            BufferedReader myTextFileBufferedReader = new BufferedReader(myTextFileReader)){

            String line;

            while((line = myTextFileBufferedReader.readLine()) != null){
                System.out.println(line);
            }

        }catch(FileNotFoundException e){
            System.out.println("Datei nicht gefunden.");
        }catch(IOException e){
            System.out.println("Fehler beim lesen / schliessen der Datei.");
        }
    }

    private static void listDirectoryAndContent(File currentDirectory, int indentation){
        printlnWithIndentation("+" + currentDirectory.getName() +" - "
                                    + (currentDirectory.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; "
                                    +(currentDirectory.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff"), indentation );

        File[] currentDirectoryContent = currentDirectory.listFiles();
        for(File currentFile : currentDirectoryContent){
            if(currentFile.isDirectory()){
                listDirectoryAndContent(currentFile, indentation+1);
            }else if(currentFile.isFile()){
                printlnWithIndentation("-" + currentFile.getName()
                                        + " - "+ (currentFile.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; "
                                        +(currentFile.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff") + "; "
                                        + currentFile.length() + " Byte", indentation+1 );
            }
        }

    }

    private static void printlnWithIndentation(String txt, int indentation){
        String indentationText = "";
        for(int i = 0; i < indentation; i++){
            indentationText += "\t";
        }

        System.out.println(indentationText + txt);
    }

}
