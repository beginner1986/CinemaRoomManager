package cinema;

public class Cinema {

    final static int rows = 7;
    final static int cols = 8;
    char seats[][] = new char[rows][cols];

    public static void main(String[] args) {
        printSeats();
    }

    static void printSeats() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for(int i=0; i<cols; i++) { {
            System.out.printf("%d ", i + 1);
        }}
        System.out.println();

        for(int i=0; i<rows; i++) {
            System.out.printf("%d ", i + 1);
            for(int j=0; j<cols; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }
    }
}