import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(3, 2);
    }


    @DisplayName("값은 맞지만 위치가 다르면 볼이다")
    @Test
    void ball(){
        Ball userBall = new Ball(3,1);

        BallStatus res = ball.evaluate(userBall);

        assertThat(res).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("값과 위치가 맞으면 스트라이크")
    @Test
    void strike(){
        Ball userBall = new Ball(3,2);

        BallStatus res = ball.evaluate(userBall);

        assertThat(res).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("값과 위치가 모두 다르면 Nothing")
    @Test
    void nothing(){
        Ball userBall = new Ball(5,2);

        BallStatus res = ball.evaluate(userBall);

        assertThat(res).isEqualTo(BallStatus.NOTHING);
    }
}