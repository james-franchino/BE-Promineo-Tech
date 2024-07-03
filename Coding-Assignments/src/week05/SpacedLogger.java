package week05;

public class SpacedLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println(addSpaces(message));
    }

    @Override
    public void error(String message) {
        System.out.println("ERROR: " + addSpaces(message));
    }

    private String addSpaces(String message) {
        StringBuilder spacedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            spacedMessage.append(c).append(' ');
        }
        return spacedMessage.toString().trim();
    }
}