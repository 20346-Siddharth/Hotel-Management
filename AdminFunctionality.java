import java.util.Scanner;

public class AdminFunctionality {
    static Scanner sc = new Scanner(System.in);
    static RoomBookingUS_11[] roomBookings = new RoomBookingUS_11[100];
    static int roomBookingsCount = 0;

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
        System.out.println("Search Bookings by user id");
        System.out.println("Enter User ID");
        int uid = sc.nextInt();
        for (int i = 0; i < HotelManagement.uindex; i++) {
            if (uid == HotelManagement.user[i].getId()) {

                System.out.println("Booking History of " + HotelManagement.user[i].getName() + "are : ");
                for (int j = 0; i < roomBookingsCount; j++) {
                    if (roomBookings[j].getCustomer_id() == HotelManagement.user[i].getId()) {
                        printBookings(roomBookings[j]);
                    }
                }
            }
        }
    }

    public static void printBookings(RoomBookingUS_11 c) {
        System.out.print("Customer Id: ");
        System.out.println(c.getCustomer_id());
        System.out.print("Booking ID: ");
        System.out.println(c.getBookingID());
        System.out.print("Room Type: ");
        System.out.println(c.getRoomTypeSelection());
        System.out.print("Booking Details :");
        System.out.println(c.getBookingDetails());
        System.out.print("Price : ");
        System.out.println(c.getPrice());
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

        int ch;
        do {
            System.out.println("Welcome to Booking services");
            System.out.println("Enter 1 to add new Booking ");
            System.out.println("Enter 2  to update a Booking");
            System.out.println("Enter 3 to Delete a booking");
            System.out.println("Enter 4 to return to home menu");
            System.out.println("Enter 5 to exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    adminAddNewBooking();
                    break;
                case 2:
                    adminUpdateBooking();
                    break;
                case 3:
                    adminDeleteBooking();
                    break;
                case 4:
                    HotelManagement.showHome();
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Please enter valid Choice");

            }
        } while (ch != 5);
    }

    public static void adminDeleteBooking() {
        System.out.println("Delete Booking Details:");
        System.out.println("Enter Booking id to be Deleted");
        int userID = sc.nextInt();
        int pos = -1;
        for (int i = 0; i < roomBookingsCount; i++) {
            if (userID == roomBookings[i].getBookingID()) {
                pos = i;
            }
        }
        if (pos != -1) {
            roomBookingsCount--;
            for (int i = pos; i < roomBookingsCount; i++) {
                roomBookings[i] = roomBookings[i + 1];
            }
            System.out.println("Booking Details are Deleted");

        } else {
            System.err.println("User Doesn't Exist");
        }

    }

    public static void adminUpdateBooking() {
        System.out.println("Update Booking Details:");
        System.out.println("Enter Booking id to be updated");
        int bookingID = sc.nextInt();
        // CustomerEntity temp = user[0];
        int confirm = 0;
        boolean found = false;
        for (int i = 0; i < roomBookingsCount; i++) {
            if (bookingID == roomBookings[i].getBookingID()) {
                found = true;
                System.out.println("Enter old E-mail address:");
                @SuppressWarnings("unused")
                String email = sc.next();
                System.out.println("Enter new Room Type Selection");
                String new_RoomTypeSelection = sc.next();
                System.out.println("Enter 1 to Confirm");
                confirm = sc.nextInt();
                if (confirm == 1) {
                    roomBookings[i].setRoomTypeSelection(new_RoomTypeSelection);
                    System.out.println("Booking Details are Updated");
                } else {
                    System.out.println("Canceling......");
                }
            }
        }

        if (!found) {
            System.out.println("Booking ID  Doesn't Exist");
        }
    }

    public static void adminAddNewBooking() {
        System.out.println("Please add new Booking:");
        System.out.println("Enter ID");
        int bid = sc.nextInt();
        System.out.println("Enter Room Type");
        String roomtype = sc.next();
        System.out.println("Enter Booking Details");
        String bookingDetails = sc.next();
        System.out.println("Enter Price");
        double price = sc.nextDouble();

        roomBookings[roomBookingsCount++] = new RoomBookingUS_11(bid, roomtype, bookingDetails, price,
                HotelManagement.current_user.getId());
        System.out.println("Successfully Registered Booking");
    }

    public static void adminViewComplaint() {

    }

}
