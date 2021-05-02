package domain;

@FunctionalInterface
public interface MoveRule {
    boolean isMovable(int number);
}
