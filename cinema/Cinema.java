package cinema;

import java.util.Scanner;

public class Cinema {

    final static int rows = 7;
    final static int cols = 8;
    char seats[][] = new char[rows][cols];

    public static void main(String[] args) {
        // printSeats();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int cols = scanner.nextInt();
        int profit = calculateProfit(rows, cols);
        System.out.printf("Total income:\n$%d", profit);
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

    static int calculateProfit(int rows, int cols) {
        int seatsCount = rows * cols;
        int profit = 0;

        if(seatsCount <= 60) {
            profit = seatsCount * 10;
        } else {
            int expensive = rows / 2 * cols * 10;
            int cheap = (rows - (rows / 2)) * cols * 8;
            profit = expensive + cheap;
        }

        return profit;
    }
}