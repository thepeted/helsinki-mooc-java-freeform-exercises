package mooc.skijumping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TextInterface {
    private final Scanner reader;
    private final SkiJumping skiJumping;

    public TextInterface(Scanner reader, SkiJumping skiJumping) {
        this.reader = reader;
        this.skiJumping = skiJumping;
    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n");
        doEnterJumpers();
    }

    private void doEnterJumpers() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.\n");

        while(true) {
            System.out.print("Participant name: ");

            String name = reader.nextLine();
            if (name.equals("")) {
                System.out.println();
                doJumps();
                break;
            }
            skiJumping.addJumper(new Jumper(name));
        }
    }

    private void doJumps() {
        System.out.println("The tournament begins!");
        while(true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            if (!reader.nextLine().equals("jump")) {
                System.out.println("\nThanks!\n");
                printResults();
                break;
            }

            skiJumping.incrementRound();

            System.out.println("\nRound " + skiJumping.getCurrentRound());
            System.out.println("\nJumping order:");
            printNumberedList(skiJumping.getJumpers());

            System.out.println("Results of round " + skiJumping.getCurrentRound());
            ArrayList<Jump> jumps = skiJumping.doJump();

            for (Jump jump: jumps) {
                System.out.println("  " + jump.getJumperName());
                System.out.println("    length: " + jump.getLength());
                System.out.println("    judge votes: " + jump.getJudgesScores());
            }
        }
    }

    private void printResults() {
        System.out.println("Tournament results:");
        ArrayList<Jumper> jumpers = skiJumping.getJumpers();
        Collections.reverse(jumpers);

        System.out.println("Position    Name");
        for (int i = 0; i < jumpers.size(); i++) {
            System.out.println(i + 1 + "           " + jumpers.get(i));
            System.out.println("            jump lengths: "  + jumpers.get(i).getJumpLengths());
        }
    }

    private void printNumberedList(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + list.get(i));
        }

        System.out.println();
    }
}
