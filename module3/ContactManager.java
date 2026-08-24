import java.util.ArrayList;
import java.util.HashMap; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("James Cottrell", new Contact("James Cottrell", "+1 617 555 0102"));
        contacts.put("Ryan Badi", new Contact("Ryan Badi", "+1 617 555 0103"));
        contacts.put("Danny Argudo", new Contact("Danny Argudo", "+1 617 555 0104"));
        contacts.put("Shaurya Baranwal", new Contact("Shaurya Baranwal", "+1 617 555 0105"));
 
        // Step 5: look up a contact 
        System.out.println("=== Contact Lookup ===");

        // Contact that exists
        String nameToLookup1 = "Ryan Badi";
        Contact contact = contacts.get(nameToLookup1);
        if (contact != null) {
            System.out.println("Contact found: " + contact);
        } else {
            System.out.println("Contact not found: " + nameToLookup1);
        }

        // Contact that does not exist
        String nameToLookup2 = "John Doe";
        Contact contact2 = contacts.get(nameToLookup2);
        if (contact2 != null) {
            System.out.println("Contact found: " + contact2);
        } else {
            System.out.println("Contact not found: " + nameToLookup2);
        }
 
        System.out.println();
        // Step 6: print sorted list 

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    } 
}