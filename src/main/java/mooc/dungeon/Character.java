package mooc.dungeon;

public abstract class Character {
    private int x;
    private int y;
    private char displayChar;

    public Character(int startingX, int startingY) {
        this.x = startingX;
        this.y = startingY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDisplayChar() {
        return displayChar;
    }

    public void setDisplayChar(char displayChar) {
        this.displayChar = displayChar;
    }

    public void move(int moveX, int moveY, int maxX, int maxY) {
        // check out of bounds

        // update x & y
    }
}
