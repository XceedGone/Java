import java.util.Scanner;
import java.util.ArrayList;

public class Project {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\033[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static Scanner scanner = new Scanner(System.in); // global scanner

    public static void main(String[] args) {
        boolean isLoggedIn = false;

        Credentials user_1 = new Credentials("test", "1234");

        // User validation
        while(!isLoggedIn) {
            System.out.print("Enter username: ");
            String uName = scanner.nextLine();
            System.out.print("Enter password: ");
            String uPass = scanner.nextLine();

            if (uName.equals(user_1.getUsername()) && uPass.equals(user_1.getPassword())) {
                System.out.println("Logged in");
                isLoggedIn = true;
            } else {
                System.out.println(ANSI_RED + "Error! Please try again." + ANSI_RESET);
            }
        }

        // Contents
        // To-do: Handle exceptionsn when use passes sting in choices. 
        int choice;
        String[] options = {
            "1. Product and Inventory database.",
            "2. Employees and Performance database. ",
            "3. Logout and Exit "
        };
        do {
            System.out.println(ANSI_GREEN  + "-------------------------"+ ANSI_RESET);
            System.out.println(ANSI_GREEN  + "Please choose an option: "+ ANSI_RESET);
            System.out.println(ANSI_GREEN  + "-------------------------"+ ANSI_RESET);
            // Dynamic Loop options array
            for (int i = 0; i < options.length; i++) {
                System.out.println(options[i]);
            }
            // User Response
            System.out.print(ANSI_GREEN  + "Response: "+ ANSI_RESET);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 :
                    productAndInventory();
                break;
                case 2 :
                    employeeAndPerformance();
                break;
            }
        } while (choice != options.length);
    }

    // Choice # 1
    static void productAndInventory () {
        int choice;

        
        ProductInventory product = new ProductInventory();
        product.addProduct(new Product("Keyboard", 50.25));
        product.addProduct(new Product("Guitar", 50.25));
        product.addProduct(new Product("Bass", 50.25));
        do {            
            System.out.println(ANSI_GREEN  + "Please choose an option: "+ ANSI_RESET);
            System.out.println("1. Product Information. ");
            System.out.println("2. Inventory Level. ");
            System.out.println("3. Exit. ");
            
            // User Response
            System.out.print(ANSI_GREEN  + "Response: "+ ANSI_RESET);
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 :
                    int localChoice;
                    int lastOption = product.productCount() + 1; 
                    do {
                        product.showInventory();
                        System.out.println(lastOption + ". Exit. ");

                        // User Response
                        System.out.print(ANSI_GREEN  + "Response: "+ ANSI_RESET);
                        localChoice = Integer.parseInt(scanner.nextLine());
                    } while (localChoice != lastOption);
                break;
                case 2 :
                    // employeeAndPerformance(scanner);
                break;
            }
        } while (choice != 3);
    }

    // Choice # 2
    static void employeeAndPerformance () {
        int choice;
        do {
            System.out.println(ANSI_GREEN  + "Please choose an option: "+ ANSI_RESET);
            System.out.println("1. Employees. ");
            System.out.println("2. Performance. ");
            System.out.println("3. Exit. ");

            // User Response
            System.out.print(ANSI_GREEN  + "Response: "+ ANSI_RESET);
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice != 3);
    }
}


// Object for Login Credentials
class Credentials {
    String username;
    String password;
    Credentials (String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return this.username;
    }

    String getPassword() {
        return this.password;
    }
}

class Product {
    String productName;
    double price;
    Product (String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    String getProductName() {
        return this.productName;
    }

    double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return productName + " ----> P" + price;
    }
}

class ProductInventory {
    private ArrayList<Product> products;

    ProductInventory() {
        products = new ArrayList<Product>();
    }

    public void addProduct (Product product) {
        products.add(product);
    }

    public int productCount () {
        return products.size();
    }

    public void showInventory () {
        int index = 1;
        for (Product product : products) {
            System.out.println(index + ". "+ product);
            index++;
        }
    }
}