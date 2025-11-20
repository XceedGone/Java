import java.util.Scanner;

public class Project {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\033[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        do {
            System.out.println(ANSI_GREEN  + "Please choose an option: "+ ANSI_RESET);
            System.out.println("1. Product and Inventory database. ");
            System.out.println("2. Employees and Performance database. ");
            System.out.println("3. Logout and Exit ");
            choice = Integer.parseInt(scanner.nextLine());
            
            System.out.println("You Choose : " + choice);
            switch (choice) {
                case 1 :
                    productAndInventory(scanner);
                break;
            }
        } while (choice != 3);
    }

    static void productAndInventory (Scanner scanner) {
        int choice;
        do {
            System.out.println(ANSI_GREEN  + "Please choose an option: "+ ANSI_RESET);
            System.out.println("1. Product Information. ");
            System.out.println("2. Exit. ");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice != 2);
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