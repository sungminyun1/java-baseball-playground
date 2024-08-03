import java.util.Objects;

public class Ball {
    private final int value, position;

    public Ball(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public BallStatus evaluate(Ball ball){
        if(this.equals(ball)){
            return BallStatus.STRIKE;
        }
        if(value == ball.value){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return value == ball.value && position == ball.position;
    }

}
