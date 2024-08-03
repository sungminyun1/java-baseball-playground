import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    void generateInitialNumbers() {
        int[] res = baseballGame.generateInitialNumbers();

    }

    @Test
    void getValidRandomNumber() {
    }

    @Test
    void isValidNumber() {
    }
}