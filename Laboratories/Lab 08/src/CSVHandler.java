import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
    private static final String CSV_FILE = "books.csv";

    public static void writeBook(Book book) {
        try (FileWriter fw = new FileWriter(CSV_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getIsbn() + "," + book.getDescription());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                books.add(new Book(values[0], values[1], values[2], values[3], values[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
    public static void overwriteCSV(List<Book> books) {
        try (FileWriter fw = new FileWriter(CSV_FILE);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Book book : books) {
                out.println(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getIsbn() + "," + book.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
