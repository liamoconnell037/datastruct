import java.util.ArrayList;
import java.util.Scanner;
public class Client {
	private static RealEstateList houses;
	
	public static int userInteger(Scanner scanner, String question) {
		while(true) {
			System.out.print(question);
			String response = scanner.nextLine();
			try {
				return Integer.parseInt(response);
			} catch(NumberFormatException e) {
				System.out.println("\n\n\tPlease enter a valid number.");
			}
		}
	}
	
	public static double userDouble(Scanner scanner, String question) {
		while(true) {
			System.out.print(question);
			String response = scanner.nextLine();
			try {
				return Double.parseDouble(response);
			} catch(NumberFormatException e) {
				System.out.println("\n\n\tPlease enter a valid decimal.");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		createList();
		while(true) {
			System.out.println("\t\tReal Estate Listings");
			System.out.println("************************************************************");
			System.out.println("Please choose what you would like to do:"
					+ "\n\n		1. Add listing to Real Estate List"
					+ "\n		2. Delete listing from Real Estate List"
					+ "\n		3. Print a specific listing from Lot Num"
					+ "\n		4. Print all the listings in price range"
					+ "\n		5. Print all listings"
					+ "\n		6. Exit");
			switch(userInteger(scanner , "\nEnter selection (1-6): ")) {
				case 1 : {
					add(scanner);
					break;
				}
				case 2 : {
					remove(scanner);
					break;
				}
				case 3 : {
					print(scanner);
					break;
				}
				case 4 : {
					listRange(scanner);
					break;
				}
				case 5 : {
					printAll(scanner);
					break;
				}
				case 6 : {
					return;
				}
			}
		}
	}
	
	private static void listRange(Scanner scanner) {
		double low = userDouble(scanner, "\nLow price: $");
		double high = userDouble(scanner, "\nHigh price: $");
		for(HousingList o : houses.getHousesInRange(low, high)) {
			System.out.println(o + "\n\n");
		}
	}
	
	private static void printAll(Scanner scanner) {		
		System.out.println(houses);
	}
	
	private static void print(Scanner scanner) {
		System.out.println("\nPrinting a listing.");
		int lotNum = userInteger(scanner, "Enter lot number of house to print (enter -1 to go back): ");
		if(lotNum == -1) return;
		
		int index = houses.getIndex(lotNum);
		if(index == -1) {
			System.out.println("\n\tHouse not found.");
			return;
		}
		
		System.out.println(houses.get(index));
	}
	
	private static void remove(Scanner scanner) {
		System.out.println("\nRemoving a listing.");
		int lotNum = userInteger(scanner, "Enter lot number of house to remove (enter -1 to go back): ");
		if(lotNum == -1)
			return;
		
		int index = houses.getIndex(lotNum);
		if(index != -1) {
			houses.remove(index);
			System.out.println("\n\tListing removed.");
		}
		else
			System.out.println("\n\tListing not found.");
	}
	
	private static void add(Scanner scanner) {
		System.out.println("\nAdding a new listing.");
		int lotNum = userInteger(scanner, "Enter lot number: ");
		System.out.print("What is the owner's first name: ");
		String firstName = scanner.nextLine();
		System.out.print("What is the owner's last name: ");
		Name name = new Name(firstName, scanner.nextLine());
		double price = userDouble(scanner, "Enter house price: $");
		int sqrft = userInteger(scanner, "Enter square feet: ");
		int beds = userInteger(scanner, "Number of beds: ");
		if(houses.add(new HousingList(lotNum, name, price, sqrft, beds)))
			System.out.println("\n\tAdded new listing.");
		else
			System.out.println("\n\tError: Lot number already exists");
	}
	
	private static void createList() {
		ArrayList<HousingList> list = new ArrayList<>();
		list.add(new HousingList(12345, new Name("Ada", "Lovelace"), 300000, 30000, 4));
		list.add(new HousingList(67890, new Name("Charles", "Babbage"), 250000, 1250, 2));
		list.add(new HousingList(23456, new Name("Grace", "Hopper"), 325000, 2300, 3));
		list.add(new HousingList(34567, new Name("Alan", "Turing"), 455000, 3250, 5));
		list.add(new HousingList(45678, new Name("Steve", "Wozniak"), 285000, 1500, 3));
		list.add(new HousingList(56789, new Name("Katherine", "Johnson"), 425900, 2800, 4));		
		list.add(new HousingList(34342, new Name("Laam", "O'Dconenl"), 500000, 4000, 3));
		list.add(new HousingList(323232, new Name("Something", "Cool"), 1024232, 1000, 1));
		list.add(new HousingList(111111, new Name("BABJGSFJKS", "fsdkf;kldsjfas;of udshiqjaujhflkds"), 12032, 3000, 2));
		list.add(new HousingList(00012, new Name("Another", "Name"), 90000, 2500, 3));
		houses = new RealEstateList(list);
	}
}
/*
Real Estate Listings
************************************************************
Please choose what you would like to do:

1. Add listing to Real Estate List
2. Delete listing from Real Estate List
3. Print a specific listing from Lot Num
4. Print all the listings in price range
5. Print all listings
6. Exit

Enter selection (1-6): 1

Adding a new listing.
Enter lot number: 123456
What is the owner's first name: Jeff
What is the owner's last name: Bac
Enter house price: $1234566
Enter square feet: 325
Number of beds: 0

Added new listing.
Real Estate Listings
************************************************************
Please choose what you would like to do:

1. Add listing to Real Estate List
2. Delete listing from Real Estate List
3. Print a specific listing from Lot Num
4. Print all the listings in price range
5. Print all listings
6. Exit

Enter selection (1-6): 2

Removing a listing.
Enter lot number of house to remove (enter -1 to go back): 12345

Listing removed.
Real Estate Listings
************************************************************
Please choose what you would like to do:

1. Add listing to Real Estate List
2. Delete listing from Real Estate List
3. Print a specific listing from Lot Num
4. Print all the listings in price range
5. Print all listings
6. Exit

Enter selection (1-6): 3

Printing a listing.
Enter lot number of house to print (enter -1 to go back): 123456
Lot #123456 owned by Jeff Bac listed at $1234566.0 with 325 squared feet and 0 number of bedrooms.
Real Estate Listings
************************************************************
Please choose what you would like to do:

1. Add listing to Real Estate List
2. Delete listing from Real Estate List
3. Print a specific listing from Lot Num
4. Print all the listings in price range
5. Print all listings
6. Exit

Enter selection (1-6): 4

Low price: $5

High price: $200000
Lot #111111 owned by BABJGSFJKS fsdkf;kldsjfas;of udshiqjaujhflkds listed at $12032.0 with 3000 squared feet and 2 number of bedrooms.


Lot #10 owned by Another Name listed at $90000.0 with 2500 squared feet and 3 number of bedrooms.


Real Estate Listings
************************************************************
Please choose what you would like to do:

1. Add listing to Real Estate List
2. Delete listing from Real Estate List
3. Print a specific listing from Lot Num
4. Print all the listings in price range
5. Print all listings
6. Exit

Enter selection (1-6): 5
Lot #67890 owned by Charles Babbage listed at $250000.0 with 1250 squared feet and 2 number of bedrooms.

Lot #23456 owned by Grace Hopper listed at $325000.0 with 2300 squared feet and 3 number of bedrooms.

Lot #34567 owned by Alan Turing listed at $455000.0 with 3250 squared feet and 5 number of bedrooms.

Lot #45678 owned by Steve Wozniak listed at $285000.0 with 1500 squared feet and 3 number of bedrooms.

Lot #56789 owned by Katherine Johnson listed at $425900.0 with 2800 squared feet and 4 number of bedrooms.

Lot #34342 owned by Laam O'Dconenl listed at $500000.0 with 4000 squared feet and 3 number of bedrooms.

Lot #323232 owned by Something Cool listed at $1024232.0 with 1000 squared feet and 1 number of bedrooms.

Lot #111111 owned by BABJGSFJKS fsdkf;kldsjfas;of udshiqjaujhflkds listed at $12032.0 with 3000 squared feet and 2 number of bedrooms.

Lot #10 owned by Another Name listed at $90000.0 with 2500 squared feet and 3 number of bedrooms.

Lot #123456 owned by Jeff Bac listed at $1234566.0 with 325 squared feet and 0 number of bedrooms.


Real Estate Listings
************************************************************
Please choose what you would like to do:

1. Add listing to Real Estate List
2. Delete listing from Real Estate List
3. Print a specific listing from Lot Num
4. Print all the listings in price range
5. Print all listings
6. Exit

Enter selection (1-6): 6
*/