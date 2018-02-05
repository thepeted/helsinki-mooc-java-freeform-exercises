package mooc.dungeon;

public class Player extends Character {
    public Player(int startingX, int startingY) {
        super(startingX, startingY);
        this.setDisplayChar('@');
    }
}
