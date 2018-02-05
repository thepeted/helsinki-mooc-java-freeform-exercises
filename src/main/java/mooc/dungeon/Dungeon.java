package mooc.dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class Dungeon {
    private boolean vampiresMove = false;
    private int moves;
    private int length;
    private int height;
    private ArrayList<Character> characters = new ArrayList<>();

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.moves = moves;

        this.characters.add(new Player(0, 0));
        for (int i=0; i < vampires; i++) {
            // @TODO don't overwrite existing characters! use compare to method first to check if duplicate character exists
            this.characters.add(new Vampire(getRandomIntFromRange(0, height - 1), getRandomIntFromRange(0, length - 1)));
        }
    }

    public int getMoves() {
        return moves;
    }

    public boolean decrementMoves() {
        if (this.moves - 1 == 0) {
            return false;
        }

        moves--;
        return true;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public boolean vampiresMove() {
        return vampiresMove;
    }

    private int getRandomIntFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    public String toString() {
        char[][] array2d = new char[height][length];
        for (int i = 0; i < height; i++) {
            Arrays.fill(array2d[i], '.');
        }

        for ( Character c: characters ) {
            array2d[c.getX()][c.getY()] = c.getDisplayChar();
        }

        // convert to string and format for display
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(array2d[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
