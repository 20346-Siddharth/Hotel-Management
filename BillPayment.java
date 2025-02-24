
import java.util.InputMismatchException;
import java.util.Scanner;



import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BillPayment {
    
	
	// pass the totalBill here
	public static void doPayment(double bill) {
		System.out.println("***********************");
		System.out.println("-----------");
		System.out.println("Service Amount : ..... ");
		System.out.println("Payment options :");

		String card = paymentOptions();
		if (card.equalsIgnoreCase("debit") || card.equalsIgnoreCase("credit"))
			cardDetails(card,bill);
		else
			System.out.println(card);
	}

	private static String paymentOptions() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean isValidInput = false;
		String card = null;

		do {
			System.out.println("***********************");
			System.out.println("-----------");
			System.out.println("--> CREDIT : Enter -> 1");
			System.out.println("--> DEBIT  : Enter -> 2");
			System.out.println("--> EXIT   : Enter -> 0");
			System.out.println("-----------");
			System.out.print("Enter your input : ");
			try {
				option = sc.nextInt();
				if (option >= 0 && option <= 2) {
					isValidInput = true;
				} else {
					System.out.println("***********************");
					System.out.println("-----------");
					System.out.println("Wrong input!\nPlease select correct options");
					System.out.println("-----------");
					System.out.println("***********************");
				}
			} catch (InputMismatchException err) {
				System.out.println("***********************");
				System.out.println("-----------");
				System.out.println("Please enter a valid option..");
				System.out.println("-----------");
				System.out.println("***********************");
				sc.next();
			} catch (Exception e) {
				System.out.println("***********************");
				System.out.println("Something went wrong!!");

			}

		} while (!isValidInput);

		switch (option) {
		case 1: {
			card = "CREDIT";
			break;
		}
		case 2: {
			card = "DEBIT";
			break;
		}
		case 0: {
			card = "Payment Cancelled";
			break;
		}
		}
		return card;
	}

	private static void cardDetails(String card,double bill) {
		
		
		
		System.out.println("***********************");
		System.out.println("Enter your " + card + " Details.");

		

		boolean validInputs = false;
		while (!validInputs) {
			try {
				Scanner sca = new Scanner(System.in);
				
				System.out.print("Enter card Holder Name : ");
				String holdername = sca.nextLine();

				System.out.print("Enter Card Number : ");
				int cardNumber = sca.nextInt();sca.nextLine();
				System.out.print("Enter cvv : ");
				int cvv = sca.nextInt();sca.nextLine();

				boolean validDate = false;
				while (!validDate) {
					try {
						System.out.println("Date Expiring : YYYY-MM-DD");
						String input = sca.nextLine();
						LocalDate date = null;
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						date = LocalDate.parse(input, formatter);
						validDate = true;
					} catch (DateTimeParseException e) {
						System.out.println("Wrong Date format");
					}
				}
				System.out.println("Confirm payment Y/N?");
				String str = sca.nextLine();
				if(str.charAt(0)=='N' || str.charAt(0) == 'n') {
					System.out.println("Payment Cancelled");
				}
				// edit this for total bill information
				else {
					 System.out.println("Payment Successfull");
				
					 System.out.println("Invoice : XXXXX");
					 System.out.println("Name : " + holdername);
				}
				
				
				validInputs = true;
				sca.close();

			} catch (InputMismatchException e) {
				System.out.println("Please enter valid  input!");
				return;
			}
		}

	}

}
