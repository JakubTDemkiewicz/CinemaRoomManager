import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final int maxSum = 1000;
        final int zero = 0;

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int number = -1;

        while (sum < maxSum && number != zero) {
            number = scanner.nextInt();
            sum += number;
        }

        if (sum >= maxSum) {
            System.out.println(sum - maxSum);
        } else {
            System.out.println(sum);
        }
    }
}