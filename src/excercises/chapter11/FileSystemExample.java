package excercises.chapter11;

import java.io.File;
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
