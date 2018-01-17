package mooc.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    private final Map<String,Contact> contacts = new HashMap<>();

    public void addNumber(String name, String number) {
        addIfNoKeyExists(name);
        contacts.get(name).addPhoneNumber(number);
    }

    public void addAddress(String name, String street, String city) {
        addIfNoKeyExists(name);
        contacts.get(name).setAddress(street + " " + city);
    }

    public void deleteContact(String name) {
        contacts.remove(name);
    }

    public Set<String> getNumbersFromName(String name) {
        Contact contact = contacts.get(name);
        if (contact == null) {
            return null;
        }
        return contact.getPhoneNumbers();
    }

    public String getNameFromNumber(String phoneNumber) {
        for (String key: contacts.keySet()) {
            if (contacts.get(key).getPhoneNumbers().contains(phoneNumber)) {
                return key;
            }
        }
        return null;
    }

    public Contact getFullRecordFromName(String name) {
        return contacts.get(name);
    }

    public Set<Contact> getFilteredList(String searchTerm) {
        Set<Contact> matches = new TreeSet<>();

        for (String key: contacts.keySet()) {
            Contact contact = contacts.get(key);
            if (contact.getName().contains(searchTerm) || contact.getAddress().contains(searchTerm) || searchTerm.equals("")) {
                matches.add(contact);
            }
        }

        return matches;
    }

    private void addIfNoKeyExists(String name) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, new Contact(name));
        }
    }
}
