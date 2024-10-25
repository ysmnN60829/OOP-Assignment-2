import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) {
        Directory directory = new Directory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
        	 System.out.println("                          ");
        	System.out.println("************************");
            System.out.println("Contact Directory Menu:");
            System.out.println("************************");
            System.out.println("                          ");
            System.out.println("Choose an action from below");
            System.out.println("                          ");
            System.out.println("1. Add Contacts");
            System.out.println("2. Search for Contact");
            System.out.println("3. Delete a Contact");
            System.out.println("4. Replace a Number");
            System.out.println("5. Display All");
            System.out.println("6. Block a number");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1: 
                    System.out.print("Enter first name: ");
                    String f = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String l = scanner.nextLine();
                    System.out.print("Enter phone numbers (comma-separated): ");
                    String[] p = scanner.nextLine().split(",");
                    System.out.print("Enter address: ");
                    String a = scanner.nextLine();
                    System.out.print("Enter occupation: ");
                    String o = scanner.nextLine();
                    System.out.print("Enter notes: ");
                    String n = scanner.nextLine();
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    String[] dobParts = scanner.nextLine().split("-");
                    GregorianCalendar dob = new GregorianCalendar(
                            Integer.parseInt(dobParts[0]),
                            Integer.parseInt(dobParts[1]) - 1,
                            Integer.parseInt(dobParts[2])
                    );
                    directory.addContact(f, l, p, a, o, n, dob);
                    break;

                case 2: 
                    System.out.print("Enter first name to search for a contact: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = directory.search(searchName);
                    if (foundContact != null) {
                        System.out.println(foundContact);
                    } else {
                        System.out.println("Contact does not exist.");
                    }
                    break;

                case 3:
                    System.out.print("Enter first name to delete from list: ");
                    String deleteName = scanner.nextLine();
                    boolean deleted = directory.deleteContact(deleteName);
                    if (deleted) {
                        System.out.println("Contact deleted.");
                    } else {
                        System.out.println("Contact does not exist.");
                    }
                    break;

                case 4:
                    System.out.print("Enter first name to replace the number: ");
                    String replaceName = scanner.nextLine();
                    Contact contactToReplace = directory.search(replaceName);
                    if (contactToReplace != null) {
                        System.out.print("Enter old number: ");
                        String oldNumber = scanner.nextLine();
                        System.out.print("Enter new number: ");
                        String newNumber = scanner.nextLine();
                        contactToReplace.replaceNumber(oldNumber, newNumber);
                        System.out.println("Number replaced.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5: 
                    System.out.println(directory.toString());
                    break;

                case 6: 
                    System.out.print("Enter first name to block: ");
                    String blockName = scanner.nextLine();
                    Contact blockContact = directory.search(blockName);
                    if (blockContact != null) {
                        blockContact.setBlocked(true);
                        System.out.println("Contact blocked.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 7: 
                	System.out.println("Exiting the program");
                    running = false;
                    break;

                default:
            }
        }
        scanner.close();
    }
}
