package mooc.phonebook;

import java.util.Scanner;

public class Reader {
    private Scanner reader;

    public Reader() {
        this.reader = new Scanner(System.in);
    }

    public String nextLine() {
        String line = reader.nextLine();
        if (line.length() > 0) {
            return line.trim();
        }
        return "";
    }

    public char getCommand() {
        System.out.print("\ncommand: ");
        String line = reader.nextLine();
        if (line.length() > 0) {
            return line.trim().charAt(0);
        }
        return ' ';
    }
}
