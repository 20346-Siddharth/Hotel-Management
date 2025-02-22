import java.util.Scanner;

public class AdminFunctionality {
    static Scanner sc= new Scanner(System.in);
    public static void adminMenu() {
        int ch;
        do {
            System.out.println("Welcome Admin : ");
            System.out.println("Choose the Option:");
            System.out.println("Enter 1 To Booking Hotel services ");
            System.out.println("Enter 2 To Booking History");
            System.out.println("Enter 3 To Booking History by ID");
            System.out.println("Enter 4 To Room Status");
            System.out.println("Enter 5 To Check-out billing invoice");
            System.out.println("Enter 6 To View complaint");
            System.out.println("Enter 7 To Return to home menu");
            System.out.println("Enter 8 To Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    adminBookingHotelServices();
                    break;

                case 2:
                    adminBookingHistory();
                    break;
                case 3:
                    adminBookingHistoryById();
                    break;
                case 4:
                    adminRoomStatus();
                    break;

                case 5:
                    adminCheckOutBillingStatus();
                    break;

                case 6:
                    adminViewComplaint();
                    break;

                case 7:
                    HotelManagement.showHome();
                    break;

                case 8:
                    System.exit(0);

            }
        } while (ch != 8);

    }

    public static void adminBookingHistoryById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adminBookingHistoryById'");
    }

    public static void adminCheckOutBillingStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adminCheckOutBillingStatus'");
    }

    public static void adminRoomStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adminRoomStatus'");
    }

    public static void adminBookingHistory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adminBookingHistory'");
    }

    public static void adminBookingHotelServices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adminBookingHotelServices'");
    }

    public static void adminViewComplaint() {

    }

}
