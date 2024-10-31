package OOP;

public class Coin {
    private int faceUp;

    Coin() {
        this.faceUp = 1;
    }

    public int showFace() {
        return this.faceUp;
    }

    public void flipCoin() {
        double rand = Math.random();
        if (rand > .5) {
            this.faceUp = 0;
        } else {
            this.faceUp = 1;
        }
    }
}