package mooc.phonebook;

public class Main {

    public static void main(String[] args) {
	PhoneBook phoneBook = new PhoneBook();
	Reader reader = new Reader();
	TextInterface ui = new TextInterface(reader, phoneBook);
	ui.start();
    }
}
