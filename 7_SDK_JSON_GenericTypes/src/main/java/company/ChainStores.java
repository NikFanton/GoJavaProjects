package company;

import java.util.ArrayList;

public class ChainStores {
    public ArrayList<Shop> shops = new ArrayList<>();

    public double companyBalance() {
        double moneyBalance = 0;
        for (Shop shop : shops) {
            moneyBalance += shop.storage.moneyBalance;
        }
        return moneyBalance;
    }

    @Override
    public String toString() {
        return "Chain Stores: " + "{" + shops + "}";
    }
}
