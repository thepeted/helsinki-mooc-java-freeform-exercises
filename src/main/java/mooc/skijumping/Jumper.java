package mooc.skijumping;

import java.util.ArrayList;

public class Jumper implements Comparable<Jumper> {
    private final String name;
    private int points = 0;
    private final ArrayList<Integer> jumpLengths = new ArrayList<>();

    public Jumper(String name) {
        this.name = name;
    }

    public void addJumpLength(int length) {
        jumpLengths.add(length);
    }

    public String getJumpLengths() {
        StringBuilder sb = new StringBuilder();
        for (int length: jumpLengths) {
            sb.append(length);
            sb.append(" m");
            sb.append(", ");
        }

        if (sb.toString().length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void addPoints(int points) {
        this.points+= points;
    };

    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.points - jumper.points;
    }
}
