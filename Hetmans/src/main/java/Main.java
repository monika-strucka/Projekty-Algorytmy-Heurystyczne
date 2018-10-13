import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą");
        int size = in.nextInt();
        System.out.println("Przedstawiony zostanie problem dla: " + size + " Hetmanów");

        Hetman hetman = new Hetman();
        boolean columns[] = new boolean[size]; //tablica informująca o zajętych kolumnach
        boolean hetmans[][] = new boolean[size][size]; //tablica z rozmieszczonymi hetmanami
        boolean diagonals_left[] = new boolean[2*size - 1]; //lewe przekątne od 0 do 2 razy rozmiar planszy pomniejszony o 2
        boolean diagonals_right[] = new boolean[2*size - 1]; //prawe przekątne od 0 do 2 razy rozmiar planszy pomniejszony o 2
        hetman.addHetman(0, size, columns, hetmans, diagonals_left, diagonals_right);

    }
}
