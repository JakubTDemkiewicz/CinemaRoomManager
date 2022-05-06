package cinema;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private static char[][] cinema;
    private static int rows, columns, currentIncome, ticketsSold;
    private final static Scanner scanner = new Scanner(System.in);
    private final static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        createSeats();
        menu();
    }

    private static void createSeats() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        columns = scanner.nextInt();
        cinema = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(cinema[i], 'S');
        }
    }

    private static void menu() {
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    purchaseTicket();
                    break;
                case 3:
                    statistics();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong option. Please try again");
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    private static void displaySeats() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print(i + 1 + " ");
        }
        for (int j = 0; j < rows; j++) {
            System.out.println(" ");
            System.out.print(j + 1 + " ");
            for (int i = 0; i < columns; i++) {
                System.out.print(cinema[j][i] + " ");
            }
        }
        System.out.println();
    }

    private static void purchaseTicket() {
        System.out.println("\nEnter a row number: ");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int seat = scanner.nextInt();

        if (row > rows || seat > columns) {
            System.out.println("Wrong input!");
            purchaseTicket();
        } else if (cinema[row - 1][seat - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            purchaseTicket();
        } else {
            int price = calculateTicketPrice(row);
            cinema[row - 1][seat - 1] = 'B';
            currentIncome += price;
            ticketsSold += 1;
            System.out.println("Ticket price: $" + price);
        }
    }

    private static int calculateTicketPrice(int row) {
        if (rows * columns < 60) {
            return 10;
        } else {
            if (row <= rows / 2) {
                return 10;
            } else {
                return 8;
            }
        }
    }

    private static void statistics() {
        System.out.printf("\nNumber of purchased tickets: %d", ticketsSold);
        System.out.println("\nPercentage: " + df.format((double) ticketsSold / (rows * columns) * 100) + "%");
        System.out.printf("Current income: $%d", currentIncome);
        System.out.printf("\nTotal income: $%d\n", calculateTotalIncome());
    }

    private static int calculateTotalIncome() {
        if (rows * columns < 60) {
            return rows * columns * 10;
        } else {
            return (10 * (rows - 1) * columns / 2) + ((rows + 1) * columns * 8 / 2);
        }
    }
}
