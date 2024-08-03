import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static List<Integer> generateUniqueNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < size) {
            int candi = (int)(Math.random() * 9) + 1;
            addIfUnique(numbers, candi);
        }

        return numbers;
    }

    private static void addIfUnique(List<Integer> numbers, int n) {
        if(!numbers.contains(n)) {
            numbers.add(n);
        }
    }
}
