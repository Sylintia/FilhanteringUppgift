import java.io.File;

public class Files {

    public Files(){

    }

    //Hittar filer i windows på datorn
    public void findFile(){
        File myFile = new File("C:\\Windows");
        String[] fileList = myFile.list();

        //Letar igenom alla listor av strings för att hitta information
        for(String aFileName: fileList){
            System.out.println(aFileName);
        }
    }

}
