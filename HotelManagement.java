import java.util.Scanner;
import java.util.regex.Pattern;

public class HotelManagement {

    static int defaultAdminID = 12345;
    static String defaultAdminPassword = "12345";
    static Scanner sc = new Scanner(System.in);
    static CustomerEntity[] user = new CustomerEntity[100];
    static {
        user[0] = new CustomerEntity(1001, "dddfdfd", "fdfdfd", 1111111, "123");
    }
    static CustomerEntity current_user = null;
    static int uindex = 1;

    public static void showHome() {
        int ch;
        do {
            System.out.println("Choose the Option:");
            System.out.println("Enter 1 for User Management");
            System.out.println("Enter 2 for Log in");
            System.out.println("Enter 3 to exit");

            while (!sc.hasNextInt()) {
                System.err.println("Invalid input! Please enter a number.");
                sc.next();
            }
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    verifyAdmin();
                    break;
                case 2:
                    verifyUser();
                    break;
                case 3:
                    break;
                default:
                    System.err.println("Enter Valid Choice");
                    break;
            }
        } while (ch != 3);
    }

    public static boolean isUserIdUnique(int id) {
        for (int i = 0; i < uindex; i++) {
            if (user[i].getId() == id) {
                return false;
            }
        }
        return true;
    }

    public static void verifyAdmin() {
        System.out.println("Verify Admin Function:");
        System.out.println("Enter Admin ID:");
        while (!sc.hasNextInt()) {
            System.err.println("Invalid input! Please enter a valid Admin ID.");
            sc.next();
        }
        int adminID = sc.nextInt();
        System.out.println("Enter Admin Password");
        String adminPassword = sc.next();

        if (adminID == defaultAdminID && adminPassword.equals(defaultAdminPassword)) {
            userManagementMenu();
        } else {
            System.err.println("Invalid Credentials");
        }
    }

    public static void userManagementMenu() {
        int ch;
        do {
            System.out.println("Choose the Option:");
            System.out.println("Enter 1 To register new user");
            System.out.println("Enter 2 To Update the User details");
            System.out.println("Enter 3 To Delete the user");
            System.out.println("Enter 4 To Select users");
            System.out.println("Enter 5 To Go to home menu");
            System.out.println("Enter 6 To Exit");

            while (!sc.hasNextInt()) {
                System.err.println("Invalid input! Please enter a number.");
                sc.next();
            }
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    userManagementFunctionsuserRegister();
                    break;
                case 2:
                    System.out.println("Update user details functionality");
                    break;
                case 3:
                    System.out.println("Delete user functionality");
                    break;
                case 4:
                    System.out.println("Select users functionality");
                    break;
                case 5:
                    showHome();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Enter Valid Choice");
                    break;
            }
        } while (ch != 6);
    }

    public static void userManagementFunctionsuserRegister() {
        System.out.println("Inside user Registration");
        System.out.println("Enter details of User");
        
        int id;
        System.out.println("Enter User ID");
        while (true) {
            while (!sc.hasNextInt()) {
                System.err.println("Invalid input! Please enter a valid User ID.");
                sc.next();
            }
            id = sc.nextInt();
            if (isUserIdUnique(id)) {
                break;
            } else {
                System.err.println("User ID already exists! Please enter a unique User ID.");
            }
        }
        
        System.out.println("Enter Full Name of User");
        String name = sc.next();
        if (name.trim().isEmpty()) {
            System.err.println("Name cannot be empty!");
            return;
        }
        
        System.out.println("Enter User Email");
        String email = sc.next();
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            System.err.println("Invalid email format!");
            return;
        }
        
        System.out.println("Enter Mobile Number");
        while (!sc.hasNextLong()) {
            System.err.println("Invalid input! Please enter a valid mobile number.");
            sc.next();
        }
        long mobile = sc.nextLong();
        if (String.valueOf(mobile).length() != 10) {
            System.err.println("Mobile number must be 10 digits long!");
            return;
        }
        
        System.out.println("Enter Password");
        String password = sc.next();
        user[uindex++] = new CustomerEntity(id, name, email, mobile, password);
        System.out.println("User Created Successfully");
        print(user[uindex - 1]);
    }

    public static void print(CustomerEntity c) {
        System.out.println("User Id: " + c.getId());
        System.out.println("Full Name: " + c.getName());
        System.out.println("Email: " + c.getEmail());
        System.out.println("Mobile No: " + c.getMobile());
        System.out.println("Password: " + c.getPassword());
    }

    public static void verifyUser() {
        System.out.println("Welcome to login");
        System.out.println("Enter user ID: ");
        while (!sc.hasNextInt()) {
            System.err.println("Invalid input! Please enter a valid User ID.");
            sc.next();
        }
        int userID = sc.nextInt();

        if (userID == defaultAdminID) {
            System.out.println("Enter user Password: ");
            String userPassword = sc.next();

            if (userPassword.equals(defaultAdminPassword)) {
                AdminFunctionality.adminMenu();
            }
        } else {
            boolean found = false;
            for (int i = 0; i < uindex; i++) {
                if (userID == user[i].getId()) {
                    System.out.println("Enter user Password:");
                    String userPassword = sc.next();
                    if (userPassword.equals(user[i].getPassword())) {
                        current_user = user[i];
                        CustomerFunctionality.customerMenu();
                        found = true;
                        break;
                    } else {
                        System.err.println("Incorrect password!");
                        return;
                    }
                }
            }
            if (!found) {
                System.err.println("User ID not found!");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hii");
        showHome();
    }
}
