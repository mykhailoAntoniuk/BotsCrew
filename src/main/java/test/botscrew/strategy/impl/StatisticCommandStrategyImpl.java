package test.botscrew.strategy.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.botscrew.service.DepartmentService;
import test.botscrew.strategy.CommandStrategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class StatisticCommandStrategyImpl implements CommandStrategy {
    private final DepartmentService departmentService;
    private static final String COMMAND_PATTERN = "show (.+)? statistics";

    @Override
    public String process(String command) {
        String parsedValue = "";
        Pattern pattern = Pattern.compile(COMMAND_PATTERN);
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            parsedValue = matcher.group(1);
        }
        return departmentService.getLectorsStatistic(parsedValue);
    }

    @Override
    public boolean isCommand(String command) {
        return command.matches(COMMAND_PATTERN);
    }
}
