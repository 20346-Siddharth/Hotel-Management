import java.util.Scanner;

public class CustomerFunctionality {
    static Scanner sc= new Scanner(System.in);
   public static void customerMenu() {
        
        int ch;
        do {
            System.out.println("Welcome User : " + HotelManagement.current_user.getName());
            System.out.println("Choose the Option:");
            System.out.println("Enter 1 For Reservation ");
            System.out.println("Enter 2 For  Booking History");
            System.out.println("Enter 3 For Room Status");
            System.out.println("Enter 4 for Check out billing");
            System.out.println("Enter 5 To fill Complaint");
            System.out.println("Enter 6 To Contact");
            System.out.println("Enter 7 To Return to home menu");
            System.out.println("Enter 8 To Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    customerReservation();
                    break;
                case 2:
                    customerBookingHistory();
                    break;
                case 3:
                    customerRoomStatus();
                    break;
                case 4:
                    customerCheckOutBilling();
                    break;
                case 5:
                    customerFillComplaint();
                    break;
                case 6:
                    customerMenu();
                    break;
                case 7:
                    HotelManagement.showHome();
                    break;
                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter valid Choice...");

            }
        } while (ch != 8);
    }


    
    private static void customerFillComplaint() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'customerFillComplaint'");
    }

    private static void customerCheckOutBilling() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'customerCheckOutBilling'");
    }

    private static void customerRoomStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'customerRoomStatus'");
    }

    private static void customerBookingHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'customerBookingHistory'");
    }


    private static void customerReservation() {
       
        int ch;
        do{
            System.out.println("Welcome to Reservation Page");
            System.out.println("Enter 1 for new Reservation");
            System.out.println("Enter 2 to update Reservation");
            System.out.println("Enter 3 to Delete Reservation");
            System.out.println("Enter 4 to go to home menu");
            System.out.println("Enter 5 to Exit");
            ch = sc.nextInt();
            switch (ch){
                case 1 : break;
                case 2 : break;
                case 3 : break;
                case 4: break;
                case 5 : break;
            }
        }while (ch !=5);
    }
}
