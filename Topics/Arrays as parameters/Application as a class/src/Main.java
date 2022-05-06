import java.util.Arrays;

class Application {

    void run(String[] args) {
        Arrays.stream(args).forEach(System.out::println);
    }
}