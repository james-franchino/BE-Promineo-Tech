package week05;

public class App {
    public static void main(String[] args) {
        Logger asteriskLogger = new AsteriskLogger();
        Logger spacedLogger = new SpacedLogger();

        // Test Asterisk
        asteriskLogger.log("Hello");
        asteriskLogger.error("Hello");

        // Test spaced
        spacedLogger.log("Hello");
        spacedLogger.error("Hello");
    }
}
