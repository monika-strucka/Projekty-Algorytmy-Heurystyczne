public class Population {

    // Klada populacji tras
    Distance[] distances;

    // Tworzenie populacji
    public Population(int populationSize, boolean initialise) {
        distances = new Distance[populationSize];
        // Tworzenie populacji jeśli zmienna initialise ma wartość true
        if (initialise) {
            // tworzenie tylu początkowych tras ile mamy populacji
            for (int i = 0; i < populationSize(); i++) {
                Distance newDistance = new Distance();
                newDistance.generateIndividual();
                saveTour(i, newDistance);
            }
        }
    }

    // Zapisanie danej odległości
    public void saveTour(int index, Distance tour) {
        distances[index] = tour;
    }

    // Zwracanie odległości z populacji
    public Distance getDistance(int index) {
        return distances[index];
    }

    // Zwracanie najlepszej odległości w populacji
    public Distance getFittest() {
        Distance fittest = distances[0];
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getDistance(i).getFitness()) {
                fittest = getDistance(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return distances.length;
    }
}
