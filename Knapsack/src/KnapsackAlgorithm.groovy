import java.security.SecureRandom
import java.util.stream.Collectors;

public class KnapsackAlgorithm {

    private Evaluator valueToWeightEvaluator = new Evaluator()
    private SecureRandom secureRandom = new SecureRandom()

    public Knapsack packKnapsack(List<Item> items, Knapsack knapsack) { // return knapsack with best items
        Knapsack best = knapsack
        int randomIndex = secureRandom.nextInt(items.size())
        best.put(items.get(randomIndex)) //put random item to temporary knapsack

        while (best.canAdd(items) && !best.isFull()) {
            List<Knapsack> possibleNewItems = generateNeighbors(items, best)

            if (!possibleNewItems.isEmpty()) {
                List<Knapsack> sortedByHeuristic = sortByHeuristicEvaluate(possibleNewItems)
                best = sortedByHeuristic.get(0)
                items.remove(best.getItems().get(best.getItems().size() - 1))
            }
        }
        return best
    }

    private List<Knapsack> generateNeighbors(List<Item> items, Knapsack knapsack) {
            return items.stream()
                    .map( {
                if (knapsack.willExceedSize(it))
                    return null;
                else
                    return knapsack.copyWithItem(it)

            })
                    .filter({Objects.nonNull(it)})
                    .collect(Collectors.toList())
        }

    private List<Knapsack> sortByHeuristicEvaluate(List<Knapsack> items) {
        items.sort(Comparator.comparingDouble({valueToWeightEvaluator.evaluate(it)}))
        return items;
    }
}
