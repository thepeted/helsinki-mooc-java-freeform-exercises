package mooc.phonebook;

import java.util.Set;

public class TextInterface {
    private final Reader reader;
    private final PhoneBook phoneBook;

    public TextInterface(Reader reader, PhoneBook phoneBook) {
        this.reader = reader;
        this.phoneBook = phoneBook;
    }

    public void start() {
        printInstructions();

        while(true) {
            boolean shouldBreak = false;

            switch(reader.getCommand()) {
                case 'x': // quit
                    shouldBreak = true;
                    break;
                case '1': // add a number
                {
                    System.out.print("whose number: ");
                    String name = reader.nextLine();
                    System.out.print("number: ");
                    String phoneNumber = reader.nextLine();

                    phoneBook.addNumber(name, phoneNumber);
                    break;
                }
                case '2': // search for a number
                {
                    System.out.print("whose number: ");
                    String name = reader.nextLine();
                    Set<String> numbers = phoneBook.getNumbersFromName(name);

                    if (numbers != null && numbers.size() > 0) {
                        for (String number: numbers) {
                            System.out.println(" " + number);
                        }
                    } else {
                        System.out.println("  not found");
                    }
                    break;
                }
                case '3': // search for a person by phone number
                {
                    System.out.print("number: ");
                    String name = phoneBook.getNameFromNumber(reader.nextLine());
                    if (name != null) {
                        System.out.println(" " + name);
                    } else {
                        System.out.println("  not found");
                    }
                    break;
                }
                case '4': // add an address
                {
                    System.out.print("whose address: ");
                    String name = reader.nextLine();
                    System.out.print("street: ");
                    String street = reader.nextLine();
                    System.out.print("city: ");
                    String city = reader.nextLine();

                    phoneBook.addAddress(name, street, city);
                    break;
                }
                case '5': // search for personal information
                {
                    System.out.print("whose information: ");
                    String name = reader.nextLine();
                    Contact contact = phoneBook.getFullRecordFromName(name);
                    if (contact != null) {
                        System.out.println(contact);
                    } else {
                        System.out.println("  not found");
                    }
                    break;
                }
                case '6': // delete personal listing
                {
                    System.out.print("whose information: ");
                    String name = reader.nextLine();
                    phoneBook.deleteContact(name);
                    break;
                }
                case '7': // filtered listing
                {
                    System.out.print("keyword (if empty, all listed): ");
                    String searchTerm = reader.nextLine();
                    Set<Contact> contacts = phoneBook.getFilteredList(searchTerm);

                    if (contacts.size() > 0) {
                        int i = 1;
                        for (Contact contact: contacts) {
                            System.out.println(" " + contact.getName());
                            System.out.println(contact);

                            // add line break unless this is the last in the set
                            if (i < contacts.size()) {
                                System.out.println();
                            }
                            i++;
                        }

                    } else {
                        System.out.println(" keyword not found");
                    }
                    break;
                }
            }
            if (shouldBreak) break;
        }
    }

    private void printInstructions() {
        System.out.println("phone search");
        System.out.println("available operations");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }
}
