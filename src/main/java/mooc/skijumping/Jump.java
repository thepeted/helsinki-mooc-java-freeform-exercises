package mooc.skijumping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Jump {
    private final Jumper jumper;
    private final ArrayList<Integer> judgesScores = new ArrayList<>();
    private final int length;

    public Jump(Jumper jumper) {
        this.jumper = jumper;
        length = getRandomIntFromRange(60, 120);
        generateJudgesScores();

    }

    private void generateJudgesScores() {
        for (int i = 0; i < 5; i++) {
            judgesScores.add(getRandomIntFromRange(10, 20));
        }
    }

    public int getJumpPoints() {
        int sum = 0;
        // total judges scores
        for (int i = 0; i < judgesScores.size(); i++) {
            sum+= judgesScores.get(i);
        }
        // discard max and min scores
        sum-= Collections.max(judgesScores);
        sum-= Collections.min(judgesScores);

        // add jump length
        sum+= length;

        return sum;
    }

    public int getLength() {
        return length;
    }

    public String getJumperName() {
        return jumper.getName();
    }

    public ArrayList<Integer> getJudgesScores() {
        return judgesScores;
    }

    private int getRandomIntFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
