public class BaseballGame {
    ResultView resultView = new ResultView();
    InputView inputView = new InputView();

    public void start(){
        boolean isPlay = inputView.StartOrExit();
        if(isPlay) play();
    }

    public void play(){

    }
}
