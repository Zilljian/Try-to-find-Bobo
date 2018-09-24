import java.lang.*;
import java.io.File;

public class bobo {
    static boolean isFound = false;

    public static void main(String[] args){
        File initialDir = new File("C://");

        findBobo(initialDir);

        if (!isFound){
            System.out.print("File has not been found ¯＼_(ツ)_/¯");
        }
    }
    static void findBobo(File initialDir) throws NullPointerException{
        try {
            for (File file : initialDir.listFiles()) {
                if (file.isDirectory()) break;
                if (file.isFile() && file.getName().equals("bobo.txt")) {
                    isFound = true;
                    printBoboLocation(file.getPath());
                    return;
                }

            }
            if (!isFound) {
                for (File file : initialDir.listFiles()) {
                    if (file.isDirectory()) {
                        findBobo(file);
                    }
                }
            }
        }
        catch (NullPointerException e){
            return;
        }
    }

    static void printBoboLocation(String path){
        System.out.print("Bobo is hiding here >> " + path);
    }
}
