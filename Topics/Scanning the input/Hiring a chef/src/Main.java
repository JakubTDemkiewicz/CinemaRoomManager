import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final int numberOfFields = 3;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        int countLines = 0;

        while (countLines < numberOfFields) {
            answers.add(scanner.nextLine());
            countLines++;
        }

        System.out.println("The form for " + answers.get(0) + " is completed. We will contact you if we need a chef " +
                "who cooks " + answers.get(answers.size() - 1) + " dishes and has " + answers.get(1) +
                " years of experience.");
    }
}