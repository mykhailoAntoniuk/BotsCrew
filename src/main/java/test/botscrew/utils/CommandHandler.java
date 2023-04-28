package test.botscrew.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.botscrew.strategy.CommandStrategy;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommandHandler {
    private static final String INCORRECT_COMMAND_MESSAGE = "The command was entered incorrectly, please try again!";
    private final List<CommandStrategy> strategies;

    public String handle(String command) {
        command = command.trim().toLowerCase();
        String finalCommand = command;
        Optional<CommandStrategy> first = strategies.stream()
                .filter(cs -> cs.isCommand(finalCommand))
                .findFirst();
        return first.isPresent() ? first.get().process(command) : INCORRECT_COMMAND_MESSAGE;
    }
}
