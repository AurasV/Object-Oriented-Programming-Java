// logging class, for better understanding of (normal logs don't give accurate data, as in they're not
// displayed out of order)
public class Logging {
    public static synchronized void log(String message) {
        System.out.println(message);
    }
}
