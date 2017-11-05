package company;

import company.dataformat.Client;

import java.util.ArrayList;

public class Transactions {

    public ArrayList<Client> clients = new ArrayList<>();

    @Override
    public String toString() {
        return "Transactions: {" + clients + "}";
    }
}
