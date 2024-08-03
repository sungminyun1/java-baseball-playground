import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    ResultView resultView = new ResultView();
    InputView inputView = new InputView();
    int[] numbers;

    public void start(){
        boolean isPlay = inputView.StartOrExit();
        if(isPlay) play();
    }

    public void play(){
        numbers = generateInitialNumbers();
    }

    public int[] generateInitialNumbers(){
        int[] numbers = new int[3];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = getValidRandomNumber(numbers);
        }

        return numbers;
    }

    public int getValidRandomNumber(int[] numbers){
        boolean needLoop = true;
        int t = 0;
        while(needLoop){
            t = (int)(Math.random() * 9) + 1;
            needLoop = !isValidNumber(t);
        }
        return t;
    }

    public boolean isValidNumber(int target){
        return true;
    }
}
