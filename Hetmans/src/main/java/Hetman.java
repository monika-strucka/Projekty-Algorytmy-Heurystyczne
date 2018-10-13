public class Hetman {

    private static int counter = 0; // ilość rozstawionych hetmanów

    public static void addHetman(int row, int size, boolean columns[], boolean hetmans[][], boolean diagonals_left[], boolean diagonals_right[]) {

        //left zmniejszona -1 right zwiekszona bez -1
        for (int i = 0; i < size; i++) {
            if (!columns[i] && !diagonals_left[row - i + size - 1] && !diagonals_right[i + row]) { //kolumna i dwa rodzaje przekątnych muszą być wolne
                columns[i] = true; // zajęcie kolumny
                diagonals_left[row - i + size - 1] = true; //zajęcie przekątnej
                diagonals_right[i + row] = true; //zajęcie przekątnej
                hetmans[row][i] = true; // ustawienie hetmana
                if (row < size - 1) {
                    addHetman(row + 1, size, columns, hetmans, diagonals_left, diagonals_right); //pozostały jeszcze wiersze do rozstawienia hetmanów
                } else {                          //ostatni hetman
                    counter++;
                    display(size, hetmans);
                }
                diagonals_right[i + row] = false;  //usuwanie hetmana po zakończeniu rekurencji dla row + 1
                diagonals_left[row - i + size - 1] = false;
                columns[i] = false;
                hetmans[row][i] = false;
            }
        }
    }

    public static void display(int size, boolean hetmans[][]) {
        int x = 1;
        int y = 1;
        System.out.println("Plansza numer: " + counter);
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(x + "  ");
            x = x + 1;
        }
        System.out.println("");
        for (int j = 0; j < size; j++) {
            System.out.print(y);
            y = y + 1;
            for (int z = 0; z < size; z++) {
                if (hetmans[j][z]) {
//                    if (z == 0) System.out.print(" ");
                    System.out.print(" X");
                } else System.out.print("   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}

