package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EngineTest {

    @DisplayName("차를 움직일 수 있는 조건을 점검")
    @CsvSource(value = {"1,false", "3,false", "5,true", "7,true"})
    @ParameterizedTest
    void test01(int generatedNumber, boolean expected) {

        MoveRule moveRule = (num) -> num > 3;
        NumberGenerator numberGenerator = () -> generatedNumber;

        Engine engine = new Engine(moveRule, numberGenerator);

        boolean actual = engine.isEnoughPower();
        assertEquals(expected, actual);
    }
}