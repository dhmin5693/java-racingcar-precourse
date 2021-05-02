package ui;

public class StandardOutput implements Output {

    @Override
    public void printLine(String line) {
        System.out.println(line);
    }
}
