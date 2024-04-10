import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Ex4b {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            String fileName = "file" + i + ".txt";
            executorService.submit(() -> {
                try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
                    lines.forEach(line -> {
                        String[] words = line.split("\\s+");
                        for (String word : words) {
                            wordCount.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        wordCount.forEach((word, count) -> System.out.println(word + " -> " + count));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration);
    }
}
