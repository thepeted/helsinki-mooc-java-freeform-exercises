package mooc.phonebook;

import java.util.HashSet;
import java.util.Set;

public class Contact implements Comparable {
    private final String name;
    private String address = "";
    private final Set<String> phoneNumbers = new HashSet<>();

    public Contact(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(address.length() > 0 ? "  address: "+ address : "  address unknown");
        sb.append("\n");

        if (phoneNumbers.size() > 0) {
            sb.append("  phone numbers:\n");
            for (String phoneNumber: phoneNumbers) {
                sb.append("   " + phoneNumber);
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1); // remove trailing line break

        } else {
            sb.append("  phone number not found");
        }

        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        Contact compareWith = (Contact) o;
        return name.compareTo(compareWith.getName());
    }
}
