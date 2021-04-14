import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeRegister {
    private ArrayList<String> recipes;
    
    public RecipeRegister() {
        recipes = new ArrayList<>();
    }
    
    public void buildRegister(String fileName) {
        // Puts each row of the file into an ArrayList
        ArrayList<String> rows = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while (fileScanner.hasNextLine()) {
                String row = fileScanner.nextLine();
                rows.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        
        // Puts each recipe into it's own index in a new ArrayList
        this.recipes.add(rows.get(0) + ", cooking time: " + rows.get(1));
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).equals("")) {
                this.recipes.add(rows.get(i + 1) + ", cooking time: " + rows.get(i + 2));
            }
        }
    }
    
    public void printRegister() {
        for (String recipe : recipes) {
            System.out.println(recipe);
        }
    }
    
    public void findByName(String userInput) {
        for (String recipe : recipes) {
            if (recipe.contains(userInput)) {
                System.out.println(recipe);
            }
        }
    }
}
