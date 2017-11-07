package products;

public class Company {
    Store<FruitProduct> fruitStore;
    Store<TechProduct> techStore;
    Store<AnimalProduct> animalStore;

    public Company(Store<FruitProduct> fruitStore,
                   Store<TechProduct> techStore,
                   Store<AnimalProduct> animalStore) {
        this.fruitStore = fruitStore;
        this.techStore = techStore;
        this.animalStore = animalStore;
    }

    @Override
    public String toString() {
        return fruitStore + "\n"
                + techStore + "\n"
                + animalStore + "\n";
    }
}
