package domain;

public class Engine {

    private final MoveRule moveRule;
    private final NumberGenerator numberGenerator;

    public Engine(MoveRule moveRule, NumberGenerator numberGenerator) {
        this.moveRule = moveRule;
        this.numberGenerator = numberGenerator;
    }

    public static Engine defaultEngine() {
        return new Engine(new CarMoveRule(), new RandomNumberGenerator());
    }

    public boolean isEnoughPower() {
        return moveRule.isMovable(numberGenerator.nextNumber());
    }
}
