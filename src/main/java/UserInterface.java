
import java.util.Scanner;

public class UserInterface {

    private RecipeRegister recipeRegister;
    private Scanner scanner;

    public UserInterface(RecipeRegister register, Scanner scanner) {
        this.recipeRegister = register;
        this.scanner = scanner;
    }

    public void start() {
        System.out.print("File to read: ");
        String file = scanner.nextLine();
        recipeRegister.buildRegister(file);
        System.out.println("");
            System.out.println("Commands:");
            System.out.println("list - lists the recipes");
            System.out.println("stop - stops the program");
            System.out.println("find name - searches recipes by name");
            System.out.println("find cooking time - searches recipes by cooking time");
            
            
        while (true) {
            System.out.println("");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
                        
            if (command.equals("list")) {
                System.out.println("");
                recipeRegister.printRegister();
            }

            if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String searchedWord = scanner.nextLine();
                System.out.println("");
                System.out.println("Recipes:");
                recipeRegister.findByName(searchedWord);
            }
            
            if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int userCookingTime = Integer.valueOf(scanner.nextLine());
                System.out.println("");
                System.out.println("Recipes:");
                recipeRegister.findByMaxTime(userCookingTime);
                
            }
        }
    }
}
