import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int height = Integer.parseInt(input[0]);
        int bridges = Integer.parseInt(input[1]);
        int[] bridgesHeights = new int[bridges - 1];

        for (int i = 0; i < bridges - 1; i++) {
            bridgesHeights[i] = Integer.parseInt(scanner.next());
        }

        boolean crashed = false;

        for (int i = 0; i < bridgesHeights.length - 1; i++) {
            if (height >= bridgesHeights[i]) {
                crashed = true;
                System.out.println("Will crash on bridge " + (i + 1));
                break;
            }
        }

        if (!crashed) {
            System.out.println("Will not crash");
        }
    }
}