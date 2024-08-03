import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("중복되지않는 1~9까지의 정수를 생성한다")
    @Test
    void generateUniqueNumbers(){
        int size = 3;

        List<Integer> numbers = NumberGenerator.generateUniqueNumbers(size);

        assertThat(numbers.size()).isEqualTo(size);
        assertThat(checkIsUnique(numbers)).isTrue();
    }

    private boolean checkIsUnique(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) return false;
        }
        return true;
    }

}