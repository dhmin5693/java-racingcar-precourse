package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final static Random RANDOM = new Random();

    @Override
    public int nextNumber() {
        return RANDOM.nextInt(BOUND);
    }
}
