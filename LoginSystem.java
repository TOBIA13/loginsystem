import java.io.Console;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        String correctUsername = "username";
        String correctPassword = "password";
        int attempts = 3;
        
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            
            String password;
            if (console != null) {
                char[] passwordArray = console.readPassword("Enter password: ");
                password = new String(passwordArray);
            } else {
                System.out.print("Enter password: ");
                password = scanner.nextLine();
            }
            
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful!");
                scanner.close();
                return;
            } else {
                attempts--;
                System.out.println("Incorrect username or password. Attempts left: " + attempts);
            }
        }
        
        System.out.println("Too many failed attempts. Access denied.");
    }
}
