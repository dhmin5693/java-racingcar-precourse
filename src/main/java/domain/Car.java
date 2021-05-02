package domain;

public class Car {

    private static final String BLANK = "";
    private static final String SEPARATOR = ": ";
    private static final int MAX_SIZE_OF_NAME = 5;
    private static final char MARK = '-';

    private final String name;
    private final StringBuilder tireMarks;
    private final Engine engine;

    public Car(String name) {
        this(name, Engine.defaultEngine());
    }

    public Car(String name, Engine engine) {
        validateNotNullRule(name);
        this.name = name.trim();
        validateCarNameRule(this.name);

        tireMarks = new StringBuilder();
        this.engine = engine;
    }

    private void validateNotNullRule(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameRule(String name) {
        if (BLANK.equals(name) || name.length() > MAX_SIZE_OF_NAME) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if (engine.isEnoughPower()) {
            tireMarks.append(MARK);
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return tireMarks.length();
    }

    @Override
    public String toString() {
        return name + SEPARATOR + tireMarks.toString();
    }
}
