package Utility;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalenpw on 4/15/17.
 */
public class FileHandler {
    String _FilePathAndName;

    public FileHandler(String filePathAndName){
        _FilePathAndName = filePathAndName;
    }

    /**
     * Returns all the lines of set file
     * @return List of String all the lines in a file
     */
    public List<String> readAllLines(){
        List<String> fileLines = new ArrayList<String>();
        Path filePath = Paths.get(_FilePathAndName);
        System.out.println(System.getProperty("user.dir"));
        try{
            fileLines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

        }
        catch(IOException e ){
            e.printStackTrace();
        }
        return fileLines;
    }
}
