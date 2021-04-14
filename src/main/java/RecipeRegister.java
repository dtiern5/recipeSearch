import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class RecipeRegister {
    private HashMap<String, Integer> recipes;
    
    public RecipeRegister() {
        this.recipes = new HashMap<>();
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
        
        // Puts each recipe into Hashmap<Recipe name, cooking time>
        this.recipes.put(rows.get(0), Integer.valueOf(rows.get(1)));
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).equals("")) {
                this.recipes.put(rows.get(i + 1), Integer.valueOf(rows.get(i + 2)));
            }
        }
    }
    
    public void printRegister() {
        for (String dish : recipes.keySet()) {
            printDish(dish);
        }
    }
    
    public void findByName(String userInput) {
        for (String dish : recipes.keySet()) {
            if (dish.contains(userInput)) {
                printDish(dish);
            }
        }
    }
    
    public void findByMaxTime(int max) {
        for (String dish : recipes.keySet()) {
            if (recipes.get(dish) <= max) {
                printDish(dish);
            }
        }
    }
    
    public void printDish(String dish) {
        System.out.println(dish + ", cooking time: " + recipes.get(dish));
    }
    
    
}
