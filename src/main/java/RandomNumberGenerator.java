import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int BOUND = 9;

    private final Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    @Override
    public int nextNumber() {
        return random.nextInt(BOUND);
    }
}
