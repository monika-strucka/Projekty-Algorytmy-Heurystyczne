static void main(String[] args) {

    KnapsackAlgorithm KnapsackAlgorithm = new KnapsackAlgorithm()

    def items = createItems()
    def knapsack = new Knapsack(40)
    def result = KnapsackAlgorithm.packKnapsack(items, knapsack)

    println("Value =" + result.checkValue())
    println("Weight =" + result.checkWeight())
    println("Number of items: " + result.items.size())
    result.display()

        def knapsack2 = new Knapsack(8)
        def items2 = []
        items2.add(new Item(4, 2))
        items2.add(new Item(4, 2))
        items2.add(new Item(4, 2))
        items2.add(new Item(4, 2))
        items2.add(new Item(4, 2))

        def result2 = KnapsackAlgorithm.packKnapsack(items2, knapsack2)

    println("Value =" + result2.checkValue())
    println("Weight =" + result2.checkWeight())
    println("Number of items: " + result2.items.size())
    result2.display()
    }

private List<Item> createItems() {
    return [
            new Item(14, 9),
            new Item(5, 4),
            new Item(7, 8),
            new Item(11, 10),
            new Item(3, 1),
            new Item(1, 3),
            new Item(2, 1),
            new Item(9, 9),
            new Item(7, 7),
            new Item(4, 5),
            new Item(1, 2),
            new Item(7, 5),
    ]
}

