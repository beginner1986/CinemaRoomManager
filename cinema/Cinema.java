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
            showMenu();
            menuChoice = scanner.nextInt();

            switch(menuChoice) {
                case 1:
                    printSeats(seats);
                    break;
                case 2:
                    buyTicket(seats);
                    break;
                case 3:
                    showStatistics(seats);
                    break;
                default:
                    continue;
            }
        }
    }

    static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
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

    static int calculateTotalIncome(char seats[][]) {
        int rows = seats.length;
        int cols = seats[0].length;

        int seatsCount = rows * cols;
        int income = 0;

        if(seatsCount <= 60) {
            income = 10 * seatsCount;
        } else {
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    income += i >= rows/2 ? 8 : 10;
                }
            }
        }

        return income;
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
        boolean ticketBought = false;

        while(!ticketBought) {
            System.out.println("\nEnter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int col = scanner.nextInt();

            if(row > seats.length || col > seats[0].length) {
                System.out.println("Wrong input!");
                continue;
            }

            if(seats[row - 1][col - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;
            }

            int price = calculateTicketPrice(seats, row, col);
            System.out.printf("\n Ticket price: $%d\n", price);
            seats[row-1][col-1] = 'B';
            ticketBought = true;
        }
    }

    static void showStatistics(char[][] seats) {
        int purchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        for(int i=0; i<seats.length; i++) {
            for(int j=0; j<seats[i].length; j++) {
                if(seats[i][j] == 'B') {
                    purchasedTickets++;
                    currentIncome += i >= seats.length / 2 ? 8 : 10;
                }
            }
        }

        int seatsCount = seats.length * seats[0].length;
        double percentage = Double.valueOf(purchasedTickets) / Double.valueOf(seatsCount) * 100;
        totalIncome = calculateTotalIncome(seats);

        System.out.printf("Number of purchased tickets: %d\n", purchasedTickets);
        System.out.printf("Percentage: %.2f", percentage).print('%');
        System.out.printf("\nCurrent income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n\n", totalIncome);
    }
}