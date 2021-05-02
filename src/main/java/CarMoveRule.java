public class CarMoveRule implements MoveRule {

    private static final int REQUIRED_MINIMUM_NUMBER_TO_MOVE = 4;

    @Override
    public boolean isMovable(int number) {
        return number >= REQUIRED_MINIMUM_NUMBER_TO_MOVE;
    }
}
