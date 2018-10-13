import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Knapsack {

    private int capacity = 50
    private List<Item> items = new LinkedList<>()

    public Knapsack(int capacity) {
        this.capacity = capacity
    }

    public int checkValue() {
        return this.items.stream().mapToInt({it.getValue()} ).sum()
    }

    public int checkWeight() {
        return this.items.stream().mapToInt({it.getWeight()}).sum()
    }

    public double checkValueDividedByWeight() { //strategia, która wybiera rzeczy najcenniejsze w stosunku do swojej wagi,
        return checkValue() / checkWeight()
    }

    public boolean willExceedSize(Item item) {
        return this.checkWeight() + item.getWeight() > capacity
    }

    public void put(Item item) {
        items.add(item)
    }

    public boolean isFull() {
        return this.checkWeight() == capacity
    }

    public Knapsack copyWithItem(Item item) { //return knapsack full with all items and selected item
        Knapsack knapsack = new Knapsack(this.capacity)

        List<Item> newItems = this.items.collect { new Item(it.getValue(), it.getWeight())}
        newItems.forEach({ knapsack.put(it)})
        knapsack.put(item)
        return knapsack
    }

    public boolean canAdd(List<Item> items) {
        return items.stream().anyMatch { !willExceedSize(it)}
        }

    public List<Item> getItems() {
        return items;
    }

    public void display() {
        System.out.println("Knapsack has capacity " + capacity + " and items: ")
        for (Item item : items) {
            System.out.println(item)
        }
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                ", items=" + items +
                "capacity=" + capacity +
                '}';
    }
}