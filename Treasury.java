public class Treasury {
    private int numCoins;

    public Treasury() {
        numCoins = 200;
    }

    public int getCoins() {
        return numCoins;
    }

    public boolean spend(int cost) {
        if (numCoins >= cost) {
            numCoins -= cost;
            return true;
        } else {
            return false;
        }
    }

    public void earn(int coinsEarned) {
        numCoins += coinsEarned;
    }
}