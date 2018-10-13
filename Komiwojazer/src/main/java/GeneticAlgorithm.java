public class GeneticAlgorithm {

    /* GA parameters */
    private static final double mutationRate = 0.015; //współczynnik mutacji
    private static final int tournamentSize = 5; //rozmiar turnieju
    private static final boolean elitism = true; //parametr wartościowy

    // Ewoluowanie populacji podczas jednej generacji
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);

        // Trzymaj najlepszy dystans o ile elitism = 1
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveTour(0, pop.getFittest());
            elitismOffset = 1;
        }

        // Krzyżowanie populacji
        // Przejście po wszystkich elementach nowej populacji i tworzenie początkowych dystansów z aktualnej populacji
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            // Wybór rodziców
            Distance parent1 = tournamentSelection(pop);
            Distance parent2 = tournamentSelection(pop);
            // Krzyżowanie rodziców
            Distance child = crossover(parent1, parent2);
            // Dodanie dziecka do nowej populacji
            newPopulation.saveTour(i, child);
        }

        // Mutowanie nowej populacji w celu dodania nowego materiału genetycznego
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getDistance(i));
        }

        return newPopulation;
    }

    // Krzyżowania rodziców i stworzenie potomstwa
    public static Distance crossover(Distance parent1, Distance parent2) {
        // Tworzenie odległości dla dzieci
        Distance child = new Distance();

        // Przypisanie początkowej i końcowej sub-odległości dla odległości pierwszego rodzica
        int startPos = (int) (Math.random() * parent1.distancesSize());
        int endPos = (int) (Math.random() * parent1.distancesSize());

        // Dodanie sub-odległości od rodzica1 do dziecka
        for (int i = 0; i < child.distancesSize(); i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            }
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        // Przejście po miastach rodzica 2
        for (int i = 0; i < parent2.distancesSize(); i++) {
            // Jeśli dziecko nie ma tego miasta dodaj je
            if (!child.containsCity(parent2.getCity(i))) {
                // Szukanie pustej pozycji w trasach dziecka
                for (int ii = 0; ii < child.distancesSize(); ii++) {
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutowanie odległości przy użyciu mutacji zamiennej (swap mutation)

    private static void mutate(Distance distance) {
        // Pętla po miastach
        for(int tourPos1=0; tourPos1 < distance.distancesSize(); tourPos1++){
            // Zastosowanie tępa mutacji
            if(Math.random() < mutationRate){
                // Zwrócenie drugiej losowej pozycji dla naszej trasy
                int tourPos2 = (int) (distance.distancesSize() * Math.random());

                // Przypisanie miast na odpowiednich pozycjach
                City city1 = distance.getCity(tourPos1);
                City city2 = distance.getCity(tourPos2);

                // Zamiana miast
                distance.setCity(tourPos2, city1);
                distance.setCity(tourPos1, city2);
            }
        }
    }

    // Wybranie odległości dla mieszanki Selects candidate tour for crossover
    private static Distance tournamentSelection(Population pop) {
        //Stworzenie populacji dla turnieju
        Population tournament = new Population(tournamentSize, false);
        // Dla każdego turnieju dodaj losową odległość
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getDistance(randomId));
        }
        // Get the fittest tour
        Distance fittest = tournament.getFittest();
        return fittest;
    }
}
