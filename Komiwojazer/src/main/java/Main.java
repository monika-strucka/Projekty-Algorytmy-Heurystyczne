public class Main {
    public static void main(String[] args) {
        
        // Tworzenie miast i dodanie do trasy
        City city = new City(60, 200);
        Managment.addCity(city);
        City city2 = new City(180, 200);
        Managment.addCity(city2);
        City city3 = new City(80, 180);
        Managment.addCity(city3);
        City city4 = new City(140, 180);
        Managment.addCity(city4);
        City city5 = new City(20, 160);
        Managment.addCity(city5);
        City city6 = new City(100, 160);
        Managment.addCity(city6);
        City city7 = new City(200, 160);
        Managment.addCity(city7);
        City city8 = new City(140, 140);
        Managment.addCity(city8);
        City city9 = new City(40, 120);
        Managment.addCity(city9);
        City city10 = new City(100, 120);
        Managment.addCity(city10);
        City city11 = new City(180, 100);
        Managment.addCity(city11);
        City city12 = new City(60, 80);
        Managment.addCity(city12);
        City city13 = new City(120, 80);
        Managment.addCity(city13);
        City city14 = new City(180, 60);
        Managment.addCity(city14);
        City city15 = new City(20, 40);
        Managment.addCity(city15);
        City city16 = new City(100, 40);
        Managment.addCity(city16);
        City city17 = new City(200, 40);
        Managment.addCity(city17);
        City city18 = new City(20, 20);
        Managment.addCity(city18);
        City city19 = new City(60, 20);
        Managment.addCity(city19);
        City city20 = new City(160, 20);
        Managment.addCity(city20);

        // Losowanie populacji początkowej
        Population population = new Population(50, true);
        System.out.println("Początkowa odległość: " + population.getFittest().getDistance());

        // Ewoluowanie populacji przez 100 generacji
        population = GeneticAlgorithm.evolvePopulation(population);
        for (int i = 0; i < 100; i++) {
            population = GeneticAlgorithm.evolvePopulation(population);
        }

        // Print final results
        System.out.println("Zakończono");
        System.out.println("Trasa końcowa: " + population.getFittest().getDistance());
        System.out.println("Rozwiązanie:");
        System.out.println(population.getFittest());


    }
}
