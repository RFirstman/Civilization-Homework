public class Treasury {
    private int coins;

    public Treasury() {
        coins = 200;
    }

    //Returns number of coins contained in Treasury object
    public int getCoins() {
        return coins;
    }

    //Takes int cost and checks to see if there are sufficient funds to pay the
    //cost. If there are enough, decrement coins and return true.
    //Otherwise, return false
    public boolean spend(int cost) {
        if (coins >= cost) {
            coins -= cost;
            return true;
        }
        return false;
    }

    public void earn(int earnings) {
        coins += earnings;
    }

    public String toString() {
        return "The treasury has " + coins + " gold coins.";
    }
}