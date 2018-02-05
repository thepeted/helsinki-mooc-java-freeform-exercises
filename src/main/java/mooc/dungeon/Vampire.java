package mooc.dungeon;

public class Vampire extends Character {
    public Vampire(int startingX, int startingY) {
        super(startingX, startingY);
        this.setDisplayChar('v');
    }

    @Override
    public boolean equals(Object obj) {
        Character toCompare = (Character) obj;
        return this.getX() == toCompare.getX() && this.getY() == toCompare.getY();
    }
}
