
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    private static final String PATH = "contacts.txt";
    private static ArrayList<Contact> contacts;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
        	FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contacts = (ArrayList<Contact>)(ois.readObject());
            ois.close();
            fis.close();
        } catch(FileNotFoundException e) {
        	
        }
        if(contacts == null) {
            System.out.println("Making new contacts list...");
            contacts = new ArrayList<>();
            saveData();
        }
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("----------------------------------- Contact Manager -----------------------------------");
            System.out.println("\n\t1. View All Contacts\n\t2. Add Contact\n\t3. Delete Contact\n\t4. Edit Contact\n\t5. Search Contact\n\t6. Delete All Contacts\n\t7. Exit\n");
            switch(userInteger("Enter a number: ", scanner)) {
                case 1 -> viewAllContacts();
                case 2 -> addContact(scanner);
                case 3 -> deleteContact(scanner);
                case 4 -> editContact(scanner);
                case 5 -> searchContact(scanner); // linear search as of now
                case 6 -> deleteAllContact(scanner);
                case 7 -> { 
                    System.out.println("--------------------------------------- Exiting ---------------------------------------\n");
                    return; 
                }
                default -> System.out.println("\nInvalid choice. Please try again.\n");
            }
            saveData();
            contacts.sort(null); // sort alphabetically
        }
    }

    
    
    
    public static void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            fos.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public static int userInteger(String question, Scanner scanner) {
        while (true) { 
            System.out.print(question);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid integer.\n");
            }
        }
    }

    public static void viewAllContacts() {
        System.out.println("\n ------------ Contact List ------------\n");
        if(contacts.isEmpty()) {
            System.out.println("\n\tNo contacts found.\n\n");
            return;
        }
        for(Contact c : contacts) {
            System.out.println("\t" + c.getName() + "\n\tPhone Number: " + c.getPhoneNumber());
            if(c.getAge() > -1) {
                System.out.println("\tAge: " + c.getAge());
            }
            if(!c.getEmail().equals("-1")) {
                System.out.println("\tEmail: " + c.getEmail());
            }
            System.out.println("\n --------------------------------------\n");
        }
    }

    public static void addContact(Scanner scanner) {
        System.out.println("\n------------ Add Contact ------------");
        System.out.print("\nEnter new contact's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new contact's phone number: ");
        String phoneNumber = scanner.nextLine();
        phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"); // format it as a phone number
        int age = userInteger("Enter new contact's age (-1 to skip): ", scanner);
        System.out.print("Enter new contact's email (-1 to skip): ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phoneNumber, age, email));
    }

    public static void deleteContact(Scanner scanner) {
        System.out.println("\n------------ Delete Contact ------------");
        System.out.println("\n CONTACTS: ---------------------------------\n");
        for(int i = 0; i < contacts.size();i++) {
            System.out.println("\t" + (i + 1) + ". " + contacts.get(i).getName());
        }
        System.out.println("\n --------------------------------------");
        int choice = userInteger("\nEnter which contact to delete (or enter -1 to cancel): ", scanner);
        if(choice == -1) {
            System.out.println("\nDeletion cancelled.\n");
            return;
        }
        if(choice > 0 && choice <= contacts.size()) {
            contacts.remove(choice - 1);
            System.out.println("\nContact deleted.\n");
        } else {
            System.out.println("\nContact not found.\n");
        }
    }

    public static void editContact(Scanner scanner) {
        System.out.println("\n------------ Edit Contact ------------");
        System.out.println("\n CONTACTS: ---------------------------------\n");
        for(int i = 0; i < contacts.size();i++) {
            System.out.println("\t" + (i + 1) + ". " + contacts.get(i).getName());
        }
        System.out.println("\n --------------------------------------");
        int choice = userInteger("\nEnter which contact to edit (or enter -1 to cancel): ", scanner);
        if(choice == -1) {
            System.out.println("\nDeletion cancelled.\n");
            return;
        }
        while(true) {
            System.out.println("\nWhat would you like to edit?");
            System.out.println("\t1. Name");
            System.out.println("\t2. Phone Number");
            System.out.println("\t3. Age");
            System.out.println("\t4. Email");
            System.out.println("\t5. Cancel");
            switch(userInteger("\nEnter your choice: ", scanner)) {
                case 1 -> {
                    System.out.print("\nEnter new name: ");
                    contacts.get(choice - 1).setName(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("\nEnter new phone number: ");
                    contacts.get(choice - 1).setPhoneNumber(scanner.nextLine().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3")); // formatted as phone number
                }
                case 3 -> contacts.get(choice - 1).setAge(userInteger("Enter new age: ", scanner));
                case 4 -> {
                    System.out.print("\nEnter new email: ");
                    contacts.get(choice - 1).setEmail(scanner.nextLine());
                }
                case 5 -> {
                    System.out.println("\n --------------------------------------");
                    return;
                }
                default -> System.out.println("\nInvalid choice. Please try again.\n");
            }
            
        }
        
        
    }

    public static void searchContact(Scanner scanner) {
        System.out.println("\n------------ Search Contact ------------");
        System.out.print("\nEnter name to search: ");
        String search = scanner.nextLine();
        System.out.println("\n   CONTACTS: ---------------------");
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(search.toLowerCase())) {
                System.out.println("\n\tName: " + contact.getName());
                System.out.println("\tPhone: " + contact.getPhoneNumber());
                if(contact.getAge() != -1)
                    System.out.println("\tAge: " + contact.getAge());
                if(!contact.getEmail().equals("-1"))
                    System.out.println("\tEmail: " + contact.getEmail() + "\n");
                found = true;
                System.out.println("\n   -------------------------------");
            }
        }
        if (!found) {
            System.out.println("\tNo contacts found matching '" + search + "'");
        }
        System.out.println("\n --------------------------------------");
    }

    public static void deleteAllContact(Scanner scanner) {
        System.out.println("\nAre you sure you want to delete all contacts? (y/n)");
        if(Character.toLowerCase(scanner.nextLine().charAt(0)) == 'y') {
        contacts.clear();
        System.out.println("\nAll contacts deleted.\n");
        }
    }

    
}
