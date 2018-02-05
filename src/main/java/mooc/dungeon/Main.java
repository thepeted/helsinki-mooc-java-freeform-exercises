package mooc.dungeon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon(20, 4,5,10, true);
        System.out.println(dungeon);

        Player player = new Player(0, 0);
        Vampire vampire = new Vampire(0,0);

        System.out.println(player.equals(vampire));
    }
}
