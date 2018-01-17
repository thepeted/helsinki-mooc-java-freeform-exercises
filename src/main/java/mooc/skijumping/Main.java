package mooc.skijumping;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);
	SkiJumping game = new SkiJumping();
	TextInterface ui = new TextInterface(reader, game);

	ui.start();

    }
}
