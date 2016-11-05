
public class CoinDriver {
    public static void main(String[] args) {
        Coin fairCoin = new Coin();
        Coin biasedCoin = new Coin(0.7);

        biasedCoin.flip();
        fairCoin.flip();

    }
}
