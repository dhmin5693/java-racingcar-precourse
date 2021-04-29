public class Car {

    private static final String BLANK = "";
    private static final String SEPARATOR = ": ";
    private static final int MAX_SIZE_OF_NAME = 5;
    private static final char MARK = '-';

    private final String name;
    private final StringBuilder tireMarks;

    public Car(String name) {
        validateNotNullRule(name);
        this.name = name.trim();
        validateCarNameRule(this.name);

        tireMarks = new StringBuilder();
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
        tireMarks.append(MARK);
    }

    @Override
    public String toString() {
        return name + SEPARATOR + tireMarks.toString();
    }
}
