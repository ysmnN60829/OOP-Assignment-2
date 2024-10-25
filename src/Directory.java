import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Directory {
    private ArrayList<Contact> directory;
    private int num;
    
    public Directory() {
        this.directory = new ArrayList<>();
        this.num = 0;
    }

    public Directory(ArrayList<Contact> directory, int num) {
        this.setDirectory(directory);
        this.setNum(num);
    }

    public Directory(ArrayList<Contact> directory) {
        this.setDirectory(directory);
        this.setNum(directory.size());
    }

    public ArrayList<Contact> getDirectory() {
        return directory;
    }

    public void setDirectory(ArrayList<Contact> directory) {
        this.directory = directory;
        this.setNum(directory.size());
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void addContact(Contact c) {
        this.directory.add(c);
        this.setNum(this.directory.size());
    }

    public void addContact(String firstName, String lastName, String[] phoneNo, String affiliation, 
                           String occupation, String note, GregorianCalendar dob) {
        Contact contact = new Contact(firstName, lastName, phoneNo, affiliation, occupation, note, dob, false);
        this.addContact(contact);
    }

    public Contact search(String firstName) {
        for (Contact contact : directory) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact; 
            }
        }
        return null; 
    }

  
    public boolean deleteContact(String firstName) {
        for (Contact contact : directory) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                directory.remove(contact);
                this.setNum(this.directory.size()); 
                return true; 
            }
        }
        return false;
    }

    
    @Override
    public String toString() {
        String result = "Directory:\n";
        for (int i = 0; i < directory.size(); i++) {
            result += directory.get(i).toString() + "\n";
        }
        return result;
    }

}
