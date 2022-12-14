import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {

    //Skapar en scanner som kan användas i hela klassen
    Scanner myScanner = new Scanner(System.in);
    boolean addToFile = false;
    boolean overwriteFile = false;

    public Files(){

    }

    public void start(){
        //metoden start kallar på metoden addOrOverwrite
        addOrOverwrite();
        //kallar på metoden savePeopleToFile
        savePeopleToFile();
    }

    private void addOrOverwrite(){
        //frågar om man vill lägga till något till filen eller skriva över
        System.out.println("Do you want to add test to the file or overwrite it? (1: add, 2: overwrite)");

        //Läser av svaret och avgör om den ska lägga till något eller skriva över
        String ans = myScanner.next();
        if (ans.equals("1")){
            addToFile = true;
        }
        else if (ans.equals("2")){
            overwriteFile = true;
        }
        //om man inte svarat 1 eller 2 så skriver programet ut dethär:
        else{
            System.out.println("You need to select add or overwrite");
            addOrOverwrite();
        }
    }

    public void findFile(){
        //Hittar filen words.txt
        File myFile = new File("words.txt");
        System.out.println(myFile.getAbsolutePath());


        String[] fileList = myFile.list();

        //Letar igenom alla listor av strings för att hitta information
        for(String aFileName: fileList){
            System.out.println(aFileName);
        }
    }

    private void savePeopleToFile(){
        String[] people = {"Nova", "Smilla", "Kylo", "Skorpan"};
        File peopleFile = new File("people.txt");

        if (peopleFile.canWrite() == false){
            System.out.println("You can't write to people.txt");
            return;
        }

        try {
            FileWriter peopleFileWriter = new FileWriter("people.txt", addToFile);

            for (String person: people){
                System.out.println(person);
                peopleFileWriter.write(person + "\n");
            }
            peopleFileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
