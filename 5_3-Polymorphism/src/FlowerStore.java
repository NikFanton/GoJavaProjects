import flowers.Chamomile;
import flowers.Rose;
import flowers.SuperFlower;
import flowers.Tulip;

public class FlowerStore {

    private float incomes = 0;

    public float getIncomes() {
        return incomes;
    }

    public SuperFlower[] sell(int numOfRose, int numOfChamomile, int numOfTulip) {
        SuperFlower flowers[] = new SuperFlower[numOfRose + numOfChamomile + numOfTulip];
        int i = 0;
        while (i < numOfRose) {
            flowers[i] = new Rose();
            incomes += flowers[i++].getPrice();
        }
        while (i < numOfChamomile + numOfRose) {
            flowers[i] = new Chamomile();
            incomes += flowers[i++].getPrice();
        }
        while (i < numOfTulip + numOfChamomile + numOfRose) {
            flowers[i] = new Tulip();
            incomes += flowers[i++].getPrice();
        }
        return flowers;
    }

    public SuperFlower[] sellSequence(int numOfRose, int numOfChamomile, int numOfTulip) {
        SuperFlower flowers[] = new SuperFlower[numOfRose + numOfChamomile + numOfTulip];
        int i = 0;
        while (i < flowers.length) {
            if (numOfRose > 0) {
                flowers[i] = new Rose();
                incomes += flowers[i++].getPrice();
                numOfRose--;
            }
            if (numOfChamomile > 0) {
                flowers[i] = new Chamomile();
                incomes += flowers[i++].getPrice();
                numOfChamomile--;
            }
            if (numOfTulip > 0) {
                flowers[i] = new Tulip();
                incomes += flowers[i++].getPrice();
                numOfTulip--;
            }
        }
        return flowers;
    }

    public static void main(String[] args) {
        FlowerStore store = new FlowerStore();
        SuperFlower[] bouquet1 = store.sell(6, 3, 5);
        for (SuperFlower flower : bouquet1) {
            flower.show();
        }
        System.out.println();
        System.out.println("Incomes: " + store.getIncomes());
        SuperFlower[] bouquet2 = store.sellSequence(4, 3, 5);
        for (SuperFlower flower : bouquet2) {
            flower.show();
        }
        System.out.println();
        System.out.println("Incomes: " + store.getIncomes());
    }
}
