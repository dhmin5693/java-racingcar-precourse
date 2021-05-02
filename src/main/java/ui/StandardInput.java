package ui;

import java.util.Scanner;

public class StandardInput implements Input {

    private static final Scanner SC = new Scanner(System.in);

    @Override
    public String nextLine() {
        return SC.nextLine();
    }

    @Override
    public int nextInt() {
        return SC.nextInt();
    }
}
