import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            source.add(random.nextInt(500) - 250);
        }
        System.out.println(source);

        List<Integer> result = new ArrayList<>();
        for (Integer item : source) {
            if ((item >= 0) && (item % 2 == 0)) {
                result.add(item);
            }
        }

        Integer tempo;
        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(i) > result.get(j)) {
                    tempo = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, tempo);
                }
            }
        }
        System.out.println(result);


        Set<Integer> resultStream = source.stream()
                .filter((item) -> (item >= 0 && item % 2 == 0))
                .sorted()
                .map(x -> x * x)
                .collect(Collectors.toSet());
        System.out.println(resultStream);



        List<Integer> resultStream2 = source.stream()
                .filter((item) -> (item < 0 && item % 2 != 0))
                .sorted()
                .map(x -> x + 10)
                .collect(Collectors.toList());
        System.out.println(resultStream2);
    }
}