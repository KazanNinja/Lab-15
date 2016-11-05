import java.util.Random;

public class Coin {

    private String face;
    private double bias;

    public Coin() {
        face = "Heads";
        bias = 0.5;
    }

    public Coin(double inputBias) {
        face = "Heads";
        bias = inputBias;
    }

    public void flip() {
        double random = Math.random();

        if (random <= bias) {
            face = "Heads";
        }
        else {
            face = "Tails";
        }

        System.out.println("Face: " + face);
    }
    public void flip(int n) {
        int heads = 0;
        int tails = 0;
        for(int i = 0; i < n; i++) {
            double random = Math.random();

            if (random <= bias) {
                face = "Heads";
                heads++;
            }
            else {
                face = "Tails";
                tails++;
            }
        }


        System.out.println("Heads: " + heads);
        System.out.println("Tails: " + tails);
    }

    public boolean isHeads() {
        return face.equals("Heads");
    }

    public boolean isTails() {
        return face.equals("Tails");
    }

    public String toString() {
        return face;
    }

    public boolean equals(Coin other) {
        return (isHeads() && other.isHeads()) || (isTails() && other.isTails());
    }

}
