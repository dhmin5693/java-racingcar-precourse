import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomBooleanGeneratorTest {

    @DisplayName("결과는 true/false 중 하나를 무작위로 나와야 한다.")
    @Test
    void test01() {

        Set<Boolean> set = new HashSet<>();
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

        for (int i = 0; i < 100; i++) {
            set.add(randomBooleanGenerator.nextBoolean());
        }

        assertEquals(2, set.size());
    }
}