import java.util.ArrayList;
import java.util.Collections;

public class Distance {

    //lista zawierająca odległości między odwiedzanymi miastami
    private ArrayList distances = new ArrayList<City>();
    // Cache
    private double fitness = 0; //użyteczność, parametr jakościowy
    private int distance = 0;

    //construktor tworzący odległośc o wartości null
    public Distance() {
        for (int i = 0; i < Managment.numberOfCities(); i++) {
            distances.add(null);
        }
    }

    public Distance(ArrayList tour) {
        this.distances = distances;
    }

    // tworzenie pierwszej trasy TODO
    public void generateIndividual() {
        //pętla przechodząca po wszystkich miastach i dodająca je do trasy
        for (int i = 0; i < Managment.numberOfCities(); i++) {
            setCity(i, Managment.getCity(i));
        }
        //losowe kolelejność pierwszej trasy między wszystkimi miastami
        Collections.shuffle(distances);
    }

    // Gets a city from the tour
    public City getCity(int index) {
        return (City) distances.get(index);
    }

    //ustawianie wybranego miasta na określonym miejscu w liście
    public void setCity(int index, City city) {
        distances.set(index, city);
        //zerowanie parametrów po zmianie listy z odwiedzonymi miastami
        fitness = 0;
        distance = 0;
    }

    // Gets the tours fitness TODO ??
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1 / (double) getDistance();
        }
        return fitness;
    }

    // zwraca sumę wszystkich pokonanych odległości
    public int getDistance() {
        if (distance == 0) {
            int tourDistance = 0;
            // przejście przez wszystkie odwiedzone miasta
            for (int cityIndex = 0; cityIndex < distancesSize(); cityIndex++) {
                //przypisanie aktualnie odwiedzanego miasta
                City fromCity = getCity(cityIndex);
                // miasto, które odwiedzone zostanie jako następne
                City destinationCity;
                //sprawdzenie czy aktualne miasto nie jest ostatnim
                //jeśli tak ustawiamy końcowe miasto jako miasto z któego zaczęliśmy
                if (cityIndex + 1 < distancesSize()) {
                    destinationCity = getCity(cityIndex + 1);
                } else {
                    destinationCity = getCity(0);
                }
                // Get the distance between the two cities
                tourDistance += fromCity.getDistance(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // zwracanie ilości odwiedzonych miast
    public int distancesSize() {
        return distances.size();
    }

    // sprawdzenie czy dane miasto zostało odwiedzone
    public boolean containsCity(City city) {
        return distances.contains(city);
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < distancesSize(); i++) {
            geneString += getCity(i) + "|";
        }
        return geneString;
    }
}

