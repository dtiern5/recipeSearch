
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeRegister register = new RecipeRegister();
        UserInterface userInterface = new UserInterface(register, scanner);
        userInterface.start();

    }   
}
