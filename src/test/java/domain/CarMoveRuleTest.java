package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMoveRuleTest {

    private CarMoveRule carMoveRule;

    @BeforeEach
    void setUp() {
        carMoveRule = new CarMoveRule();
    }

    @DisplayName("생성 숫자가 3 이하인 경우 차량 이동 불가능")
    @Test
    void test01() {
        for (int i = 0; i <= 3; i++) {
            assertFalse(carMoveRule.isMovable(i));
        }
    }

    @DisplayName("생성 숫자가 4 이상인 경우 차량 이동 가능")
    @Test
    void test02() {
        for (int i = 4; i <= 9; i++) {
            assertTrue(carMoveRule.isMovable(i));
        }
    }
}