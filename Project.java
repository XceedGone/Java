import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;

        Credentials user_1 = new Credentials("test", "1234");

        while(!isLoggedIn) {
            System.out.print("Enter username: ");
            String uName = scanner.nextLine();
            System.out.print("Enter password: ");
            String uPass = scanner.nextLine();

            if (uName.equals(user_1.getUsername()) && uPass.equals(user_1.getPassword())) {
                System.out.println("Logged in");
                isLoggedIn = true;
            } else {
                System.out.println("Error! Please try again.");
            }
        }
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