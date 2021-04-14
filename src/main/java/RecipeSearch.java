
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("File to read: ");
            String file = scanner.nextLine();

            System.out.println("");
            System.out.println("Commands:");
            System.out.println("list - lists the recipes");
            System.out.println("stop - stops the program");
            System.out.println("find name - searches recipes by name");
            System.out.println("");

            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("list")) {
                ArrayList<String> rowsOfFile = new ArrayList<>();
                rowsOfFile = readFile(file);
                parse(rowsOfFile);
            }
            if (command.equals("stop")) {
                break;
            }

            if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String searchedWord = scanner.nextLine();

            }
        }

    }

    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> rows = new ArrayList<>();
        try ( Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            
            while (fileScanner.hasNextLine()) {

                String row = fileScanner.nextLine();
                rows.add(row);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return rows;

    }

    public static void parse(ArrayList<String> recipes) {
        System.out.println(recipes.get(0) + ", cooking time: " + recipes.get(1));
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).equals("")) {
                System.out.println(recipes.get(i + 1) + ", cooking time: " + recipes.get(i + 2));
            }
        }
    }

}
