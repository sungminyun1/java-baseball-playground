public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public void setResult(BallStatus ballStatus) {
        if(BallStatus.isStrike(ballStatus)) {
            strike++;
            return;
        }

        if(BallStatus.isBall(ballStatus)) {
            ball++;
        }
    }

    public boolean isDone() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
