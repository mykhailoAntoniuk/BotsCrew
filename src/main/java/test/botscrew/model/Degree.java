package test.botscrew.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Degree {
    ASSISTANT("Assistant"),
    ASSOCIATE_PROFESSOR("Associate Professor"),
    PROFESSOR("Professor");

    private final String stringValue;
}
