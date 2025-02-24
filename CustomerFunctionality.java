

import java.util.InputMismatchException;

import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomerFunctionality {


    static Scanner sc = new Scanner(System.in);
    static Reservation[] reservations = new Reservation[100];
    static Complaint[] complaints = new Complaint[100];
    static Room[] rooms= new Room[100];
    static int size = 0;
    static int complaintSize=-1;
    static int roomSize=10;
    static {
		rooms[0] = new Room(0,"1bhk","vacant","2025/12/01",1500.0,"Mumbai");
		rooms[1] = new Room(1,"2bhk","occupied","2025/10/01",2500.0,"Indore");
		rooms[2] = new Room(2,"3bhk","vacant","2025/12/01",4500.0,"Mumbai");
		rooms[3] = new Room(3,"2bhk","vacant","2025/09/01",1400.0,"Delhi");
		rooms[4] = new Room(4,"1bhk","occupied","2025/12/01",1200.0,"Indore");
		rooms[5] = new Room(5,"2bhk","vacant","2025/08/01",2300.0,"Indore");
		rooms[6] = new Room(6,"1bhk","vacant","2025/12/01",1500.0,"Jaipur");
		rooms[7] = new Room(7,"1bhk","vacant","2025/12/01",2000.0,"Delhi");
		rooms[8] = new Room(8,"3bhk","vacant","2025/12/01",5500.0,"Bhopal");
		rooms[9] = new Room(9,"2bhk","vacant","2025/12/01",3500.0,"Mumbai");	
    }
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
                    toContact();
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
    	System.out.println("Complaint / FeedBack Form");
		System.out.println("Please Fill your Details");
		System.out.print("Enter your Name: ");
		String name=sc.next();
		System.out.print("Contact number: ");
		long mob=sc.nextLong();
		System.out.print("Enter Room Number: ");
		int roomNo=sc.nextInt();
		System.out.println("Choose Type of Complaint");
		int opt;
		String complaintType = "";
		
			
			System.out.println("1 - Poor HouseKeeping");
			System.out.println("2 - Noisy Guests");
			System.out.println("3 - Uncomfortable Beds");
			System.out.println("4 - Slow Service");
			System.out.println("5 - Lack of Amenities");
			System.out.println("6 - Unfriendly staff");
			System.out.println("7 - To Exit");
			opt = sc.nextInt();
			switch(opt) {
			case 1:
				complaintType = "Poor HouseKeeping";
				break;
			case 2:
				complaintType = "Noisy Guests";
				break;
			case 3:
				complaintType = "Uncomfortable Beds";
				break;
			case 4:
				complaintType = "Slow Service";
				break;
			case 5:
				complaintType = "Lack of Amenities";
				break;
			case 6:
				complaintType = "Unfriendly staff";
				break;
			default : System.out.println("Enter value between 1 to 6");
			}
	
		
		System.out.println("Enter rating on scale of 1-5");
		int feedback = sc.nextInt();
		
		complaints[++complaintSize] = new Complaint(name, mob, roomNo, complaintType, feedback);
        System.out.println("Complaint Registered Successfully! Thanks for your feedback");
		
}


    private static void customerCheckOutBilling() {
    	System.out.println("Room Charges: "+20000+"Rs");
		System.out.println("Additional Charges: XXXRS");
		
		int opt;
		do {
			
			System.out.println("Total Bill: "+20000+"Rs");
			System.out.println("1 - Check Out Page");
			System.out.println("2 - Exit");
			opt = sc.nextInt();sc.nextLine();
			switch (opt) {
			case 1:
				BillPayment.doPayment(20000.0);
				return;
			case 2:
				System.out.println("Payment Cancelled!");
				break;
			default:
				System.out.println("Please Enter valid option");
				break;
			}
		}while(opt!=2);
    }

    private static void customerRoomStatus() {
    	for(int i=0;i<roomSize;i++) {
			System.out.println(rooms[i]);
		}
    	//int opt;
    	
    }

    private static void customerBookingHistory() {
        System.out.println(size);
        if(size==0){
            System.out.println("No history available!");
            return;
        }



        for (int i = 0; i < size; i++) {
            System.out.println(reservations[i]);
        }
            System.out.print("Enter 1 to exit ");
            int opt ;
        do {
            opt = sc.nextInt();sc.nextLine();
            if (opt != 1) {
                System.out.println("Invalid input");
            }
            else{
                break;
            }
        } while (opt != 1);
        customerMenu();
    }

    private static void toContact() {
        System.out.println("*****************************");
        System.out.println("* Contact support details:   ");
        System.out.println("* Contact Number: XXXXXXXXx ");
        System.out.println("* Contact Email: XXXXXXXX@gmail.com");
        System.out.println("* Contact Number: XXXXXXXXx yyyy ZZZZ");
        int opt;
        do{
            System.out.print("Enter 1 to exit: ");
            opt = sc.nextInt();sc.nextLine();
            if(opt!=1){
                System.out.println("Invalid input!\nPlease enter correct option");
            }
        }while (opt!=1);
        customerMenu();
    }


    private static void customerReservation() {


        int ch;
        do {
            System.out.println("Welcome to Reservation Page");
            System.out.println("Enter 1 for new Reservation");
            System.out.println("Enter 2 to update Reservation");
            System.out.println("Enter 3 to Delete Reservation");
            System.out.println("Enter 4 to go to home menu");
            System.out.println("Enter 5 to Exit");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    addNewReservation();
                    break;
                case 2:
                    updateReservation();
                    break;
                case 3:
                    deleteReservation();
                    break;
                case 4:
                    customerMenu();
                    break;
                case 5:
                    break;
            }
        } while (ch != 5);
    }

    private static void addNewReservation() {

        if (size >= reservations.length) {
            Reservation[] extend = new Reservation[size * 2];
            for (int i = 0; i < size; i++) {
                extend[i] = reservations[i];
            }
            reservations = extend;
        }
        try {
            System.out.print("Enter check in date in the format : yyyy-mm-dd: ");
            String checkIn = sc.nextLine();
            System.out.print("Enter check out date in the format : yyyy-mm-dd: ");
            String checkOut = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(checkOut, formatter);
            System.out.print("Enter room preference : SINGLE/DOUBLE - ");
            String preference = sc.nextLine();
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter contact number: ");
            long contact = sc.nextLong();
            sc.nextLine();

            reservations[size++] = new Reservation(size+1, checkIn, checkOut, preference, name, contact,HotelManagement.current_user.getId());
            System.out.println(reservations[size - 1]);
            System.out.println("Reservation Successful. ");

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Please use yyyy-mm-dd format");
        }

    }

    private  static  void updateReservation() {

        try {
            System.out.println(size);
            if (size == 0) {
                System.out.println("No Reservations found");
                customerMenu();
                return;
            }

            System.out.println("Enter your ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Reservation ob : reservations) {
                if (ob.getId() == id) {
                    System.out.println("Update your name: ");
                    String name = sc.nextLine();
                    ob.setName(name);
                    break;
                }
            }

            System.out.println("User Updated. ");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!!");
        }

    }

    private static void deleteReservation() {

        try {

            if (size == 0) {
                System.out.println("No Reservations found");
                customerMenu();
                return;
            }
            System.out.println("Enter your ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < size; i++) {
                if (reservations[i].getId() == id) {
                    for (int j = i; j < size - 1; j++) {
                        reservations[j] = reservations[j + 1];
                    }
                    reservations[size - 1] = null;
                    size--;
                    System.out.println("Reservation deleted");
                    return;
                }

            }

            System.out.println("No Reservation found");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!!");
        }

    }
}