import java.util.ArrayList;

public class Managment {


    //lista z miastami
    private static ArrayList Cities = new ArrayList<City>();

    //dodawanie miasta do listy
    public static void addCity(City city) {
        Cities.add(city);
    }

    //zwracanie miasta o okreslonym indeksie
    public static City getCity(int index){
        return (City)Cities.get(index);
    }

    //liczba miast
    public static int numberOfCities(){
        return Cities.size();
    }





}
