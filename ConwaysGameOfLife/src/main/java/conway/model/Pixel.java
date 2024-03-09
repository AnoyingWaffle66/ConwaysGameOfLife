package conway.model;

public class Pixel {
    public static final int WHITE = -1;
    public static final int BLACK = -16777216;
    private boolean isAlive;
    private int amountOfNeighbors;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getAmountOfNeighbors() {
        return amountOfNeighbors;
    }

    public void setAmountOfNeighbors(int amountOfNeighbors) {
        this.amountOfNeighbors = amountOfNeighbors;
    }
}
