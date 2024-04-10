import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Ex4a {

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            String fileName = "file" + i + ".txt";
            try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
                lines.forEach(line -> {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        wordCount.forEach((word, count) -> System.out.println(word + " -> " + count));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration);
    }
}
