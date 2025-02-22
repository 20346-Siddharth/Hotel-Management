import java.util.Scanner;

public class HotelManagement {

    static int defaultAdminID = 12345;
    static String defaultAdminPassword = "12345";
    static Scanner sc = new Scanner(System.in);
    static CustomerEntity[] user = new CustomerEntity[100];
     static {
        user[0]= new CustomerEntity(1001, "dddfdfd", "fdfdfd", 1111111, "123");
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

    public static void verifyAdmin() {
        // TODO Auto-generated method stub
        System.out.println("Verify Admin Function:");
        System.out.println("Enter Admin ID:");
        int adminID = sc.nextInt();
        System.out.println("Enter Admin Password");
        String adminPassword = sc.next();

        if (adminID == defaultAdminID && adminPassword.equals(defaultAdminPassword)) {
            userManagementMenu();
        } else {
            System.err.println("Invalid Crediantials");
        }
    }

    public static void userManagementMenu() {

        int ch;

        do {

            System.out.println("Choose the Option:");

            System.out.println("Enter 1 To register new user ");

            System.out.println("Enter 2 To Update the User details");

            System.out.println("Enter 3 To Delete the user");

            System.out.println("Enter 4 To Select users");

            System.out.println("Enter 5 To Go to home menu");

            System.out.println("Enter 6 To Exit");

            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    userManagementFunctionsuserRegister();
                    break;
                case 2:
                    userManagementFunctionsuserUpdate();
                    break;
                case 3:
                    userManagementFunctionsuserDelete();
                    break;
                case 4:
                    userManagementFunctionsuserShowAll();
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

    public static void userManagementFunctionsuserShowAll() {
        System.out.println("All Users are : ");

        if (uindex > 0) {
            for (int i = 0; i < uindex; i++) {
                System.out.println(i + 1 + ":");
                print(user[i]);
            }
        } else {
            System.err.println("No user is registerde");
        }

    }

    public static void userManagementFunctionsuserDelete() {
        System.out.println("Delete User Details:");
        System.out.println("Enter User id to be Deleted");
        int userID = sc.nextInt();
        int pos = -1;
        for (int i = 0; i < uindex; i++) {
            if (userID == user[i].getId()) {
                pos = i;
            }
        }
        if (pos != -1) {
            uindex--;
            for (int i = pos; i < uindex; i++) {
                user[i] = user[i + 1];
            }
            System.out.println("User Deleted Successfully");

        } else {
            System.err.println("User Doesn't Exist");
        }
    }

    public static void userManagementFunctionsuserUpdate() {
        System.out.println("Update User Details:");
        System.out.println("Enter User id to be updated");
        int userID = sc.nextInt();
        // CustomerEntity temp = user[0];
        int confirm = 0;
        boolean found = false;
        for (int i = 0; i < uindex; i++) {
            if (userID == user[i].getId()) {
                found = true;
                System.out.println("Enter old E-mail address:");
                @SuppressWarnings("unused")
                String email = sc.next();
                System.out.println("Enter new E-mail Address");
                String new_email = sc.next();
                System.out.println("Enter 1 to Confirm");
                confirm = sc.nextInt();
                if (confirm == 1) {
                    user[i].setEmail(new_email);
                    System.out.println("User Details are updated successfully");
                } else {
                    System.out.println("Canceling......");
                }
            }
        }

        if (!found) {
            System.out.println("User Doesn't Exist");
        }

    }

    public static void userManagementFunctionsuserRegister() {
        System.out.println("INside user Registration");
        System.out.println("Enter details of User");
        System.out.println("Enter User ID");
        int id = sc.nextInt();
        System.out.println("Enter Full Name of User");
        String name = sc.next();
        System.out.println("Enter User Email");
        String email = sc.next();
        System.out.println("Enter Mobile Number");
        long mobile = sc.nextLong();
        System.out.println("Enter Password");
        String password = sc.next();
        user[uindex++] = new CustomerEntity(id, name, email, mobile, password);
        System.out.println("User Created Successfull");

        print(user[uindex - 1]);

    }

    public static void print(CustomerEntity c) {
        System.out.print("User Id: ");
        System.out.println(c.getId());
        System.out.print("Full Name: ");
        System.out.println(c.getName());
        System.out.print("Email :");
        System.out.println(c.getEmail());
        System.out.print("Mobile No: ");
        System.out.println(c.getMobile());
        System.out.print("Password : ");
        System.out.println(c.getPassword());
    }

    public static void verifyUser() {
        System.out.println("Welcome to login");
        System.out.println("Enter user ID: ");
        int userID = sc.nextInt();

        if (userID == defaultAdminID) {
            System.out.println("Enter user Password: ");
            String userPassword = sc.next();

            if (userPassword.equals(defaultAdminPassword)) {
                AdminFunctionality.adminMenu();
            }
        } else {
            CustomerEntity temp = user[0];
            for (int i = 0; i < uindex; i++) {
                if (userID == user[i].getId()) {
                    System.out.println("Enter user Password:");

                    String userPassword = sc.next();

                    if (userPassword.equals(temp.getPassword())) {
                        current_user = user[i];
                        CustomerFunctionality.customerMenu();
                    }
                }
            }
        }
    }

   

   

   
    public static void main(String[] args) {
        System.out.println("Hii");
        showHome();
    }
}