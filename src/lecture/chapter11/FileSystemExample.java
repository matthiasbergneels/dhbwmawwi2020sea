package lecture.chapter11;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class FileSystemExample {

    public static void main(String[] args) {

        // Laufwerke
        File[] rootList = File.listRoots();

        for(File root : rootList){
            System.out.println("Absoluter Pfad: " + root.getAbsolutePath());
            System.out.println("- Pfad: " + root.getPath());
            System.out.println("- Existiert: " + root.exists());
            System.out.println("- Lesezugriff: " + root.canRead());
            System.out.println("- Schreibzugriff: " + root.canWrite());
        }



        // System Properties
        System.getProperties().list(System.out);

        // Rekursive Ausgabe von Ordner und deren Inhalten
        System.out.println(System.getProperty("user.dir"));
        File currentDirectory = new File(System.getProperty("user.dir"));
        System.out.println("Ausgabe für Verzeichnis: " + currentDirectory.getPath());
        listDirectoryAndContent(currentDirectory, 0);


        // Verzeichnisse modifizieren
        File newDirectory = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "myDirectory");
        File renameDirectory = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "myRenamedDirectory");

        // verzeichnis anlegen
        if(!newDirectory.exists()){
            newDirectory.mkdir();
            System.out.println(newDirectory.getPath() + " - " + newDirectory.exists());
            System.out.println(renameDirectory.getPath() + " - " + renameDirectory.exists());
        }

        // Verzeichnisse umbenennen
        if(newDirectory.exists() && !renameDirectory.exists()){
            newDirectory.renameTo(renameDirectory);
            System.out.println(newDirectory.getPath() + " - " + newDirectory.exists());
            System.out.println(renameDirectory.getPath() + " - " + renameDirectory.exists());
        }

        // ****************
        // Dateien modifizieren

        File newFile = new File(renameDirectory.getAbsolutePath() + System.getProperty("file.separator") + "myTextFile.txt");
        File renameFile = new File(renameDirectory.getAbsolutePath() + System.getProperty("file.separator") + "myrenamedTextFile.txt");

        try {
            // Datei anlegen
            if (!newFile.exists()) {
                newFile.createNewFile();
                System.out.println(newFile.getPath() + " - " + newFile.exists());
                System.out.println(renameFile.getPath() + " - " + renameFile.exists());
            }

            // Datei umbenennen
            if (newFile.exists() && !renameFile.exists()) {
                newFile.renameTo(renameFile);
                System.out.println(newFile.getPath() + " - " + newFile.exists());
                System.out.println(renameFile.getPath() + " - " + renameFile.exists());
            }


            // Datei-Inhalt über StreamReader
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String consoleInput = "";
            ArrayList<String> preparedFileContent = new ArrayList<>();
            System.out.println("Texteingabe (Beenden mit exit):");

            do{
                consoleInput = bufferedReader.readLine();
                if(!consoleInput.equalsIgnoreCase("exit")){
                    preparedFileContent.add(consoleInput);
                }
            }while(!consoleInput.equalsIgnoreCase("exit"));


            System.out.println("Vorbereiteter Datei-Inhalt:");
            for(String line : preparedFileContent){
                System.out.println(line);
            }


            // Datei-Inhalt schreiben
            try(FileWriter renamdFileWriter = new FileWriter(renameFile); BufferedWriter bufferedRenameFileWriter = new BufferedWriter(renamdFileWriter)){
                if(renameFile.canWrite()){
                    for(String line : preparedFileContent){
                        bufferedRenameFileWriter.write(line);
                        bufferedRenameFileWriter.newLine();
                    }
                }
            }catch (IOException e){
                System.out.println("Fehler beim schreiben der Datei!");
            }

            // Datei-Inhalt auslesen
            System.out.println("Geschriebener Datei-Inhalt:");
            try(FileReader renameFileReader = new FileReader(renameFile);
                BufferedReader bufferedRenameFileReader = new BufferedReader(renameFileReader)){
                if(renameFile.canRead()){
                    String line;

                    while ((line = bufferedRenameFileReader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }catch (IOException e){
                System.out.println("Fehler beim lesen der Datei!");
            }


            File targetCopyFile = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "targetFile.dat");
            if(targetCopyFile.exists()){
                targetCopyFile.delete();
            }
            targetCopyFile.createNewFile();

            // Datei kopieren (mit Puffer)
            try(FileInputStream renameFileInputStream = new FileInputStream(renameFile);
                FileOutputStream targetCopyFileOutputStream = new FileOutputStream(targetCopyFile)){

                final int CACHE_SIZE = 1;
                int i = 0;
                int buffer = 0;
                byte[] cache = new byte[CACHE_SIZE];

                while (true){
                    buffer = renameFileInputStream.read(cache, i, CACHE_SIZE);
                    if (buffer == -1)
                        break;
                    targetCopyFileOutputStream.write(cache, i, CACHE_SIZE);
                }

            }catch(IOException e){
                System.out.println("Fehler beim kopieren der Datei");
            }

            // Datei löschen
            if (renameFile.exists()) {
                System.out.println(renameFile.getName() +" - "+ (renameFile.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; " +(renameFile.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff") + "; " + renameFile.getAbsoluteFile().length() + " Byte");
                renameFile.delete();
                System.out.println(newFile.getPath() + " - " + newFile.exists());
                System.out.println(renameFile.getPath() + " - " + renameFile.exists());
            }

        }catch(IOException e){
            System.out.println("Fehler während Datei-Modifikation.");
        }

        // Verzeichnis löschen
        if(renameDirectory.exists()){
            renameDirectory.delete();
            System.out.println(newDirectory.getPath() + " - " + newDirectory.exists());
            System.out.println(renameDirectory.getPath() + " - " + renameDirectory.exists());
        }


        // Internationalisierung
        String messageBundleIdentifier = "resources.i18n.messages";

        ResourceBundle messageBundle = ResourceBundle.getBundle(messageBundleIdentifier);
        System.out.println(messageBundle.getString("hello"));
        System.out.println(messageBundle.getString("end"));
        System.out.println(messageBundle.getString("generic"));

        Locale.setDefault(new Locale("en"));
        messageBundle = ResourceBundle.getBundle(messageBundleIdentifier);
        System.out.println(messageBundle.getString("hello"));
        System.out.println(messageBundle.getString("end"));
        System.out.println(messageBundle.getString("generic"));
    }

    private static void listDirectoryAndContent(File currentDirectory, int indentation){
        printlnWithIndentation("+" + currentDirectory.getName() +" - "+ (currentDirectory.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; " +(currentDirectory.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff"), indentation );

        File[] currentDirectoryContent = currentDirectory.listFiles();
        for(File currentFile : currentDirectoryContent){
            if(currentFile.isDirectory()){
                listDirectoryAndContent(currentFile, indentation+1);
            }else if(currentFile.isFile()){
                printlnWithIndentation("-" + currentFile.getName() +" - "+ (currentFile.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; " +(currentFile.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff") + "; " + currentFile.getAbsoluteFile().length() + " Byte", indentation+1 );
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
