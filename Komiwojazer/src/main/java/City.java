import java.util.Random;

public class City {
    int x;
    int y;
    Random generator = new Random();

    //konstruktor tworzący miasto z losowymi współrzędnymi
    public City() {
        this.x = generator.nextInt(200);
        this.y = generator.nextInt(200);
    }

    //konstruktor tworzący miasto z określonymi współrzędnymi
    public City(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //funkcja zwracająca odległość do danego miasta
    public double getDistance(City city) {
        int x = Math.abs(getX() - city.getX());
        int y = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( x*x + y*y);

        return distance;
    }

    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}

