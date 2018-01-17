package mooc.skijumping;

import java.util.ArrayList;
import java.util.Collections;

public class SkiJumping {
    private final ArrayList<Jumper> jumpers = new ArrayList<>();
    private int currentRound = 0;


    public void addJumper(Jumper jumper) {
        jumpers.add(jumper);
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public ArrayList<Jumper> getJumpers() {
        return jumpers;
    }

    public void incrementRound() {
        currentRound++;
    }

    public ArrayList<Jump> doJump() {
        ArrayList<Jump> jumpResults = new ArrayList<>();

        for (Jumper jumper: jumpers) {
            Jump jump = new Jump(jumper);

            jumper.addJumpLength(jump.getLength());
            jumper.addPoints(jump.getJumpPoints());

            jumpResults.add(jump);
        }

        Collections.sort(jumpers);

        return jumpResults;
    }
}
