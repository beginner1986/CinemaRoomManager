package cinema;

import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int cols = scanner.nextInt();

        // int profit = calculateProfit(rows, cols);
        // System.out.printf("Total income:\n$%d", profit);

        char seats[][] = new char[rows][cols];
        fillSeats(seats);

        int menuChoice = 9;
        while(menuChoice != 0) {
            showMneu();
            menuChoice = scanner.nextInt();

            switch(menuChoice) {
                case 1:
                    printSeats(seats);
                    break;
                case 2:
                    buyTicket(seats);
                    break;
                default:
                    continue;
            }
        }
    }

    static void showMneu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }

    static void fillSeats(char[][] seats) {
        for(int i=0; i<seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'S';
            }
        }
    }

    static void printSeats(char seats[][]) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for(int i=0; i< seats[0].length; i++) { {
            System.out.printf("%d ", i + 1);
        }}
        System.out.println();

        for(int i=0; i<seats.length; i++) {
            System.out.printf("%d ", i + 1);
            for(int j=0; j<seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
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

    static int calculateTicketPrice(char seats[][], int row, int col) {
        int price = 0;
        int seatsCount = seats[0].length * seats.length;

        if(seatsCount <= 60) {
            price = 10;
        } else {
            if(row <= seats.length / 2) {
                price = 10;
            } else {
                price = 8;
            }
        }

        return price;
    }

    static void buyTicket(char[][] seats) {
        System.out.println("\nEnter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int col = scanner.nextInt();
        int price = calculateTicketPrice(seats, row, col);
        System.out.printf("\n Ticket price: $%d\n", price);
        seats[row-1][col-1] = 'B';
    }
}