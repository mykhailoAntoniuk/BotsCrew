package test.botscrew.strategy;

public interface CommandStrategy {
    String process(String command);
    boolean isCommand(String command);
}
