package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size(){

        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void contains(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @CsvSource({"1, true", "2,true", "3,true", "4,false", "5,false"})
    @ParameterizedTest
    void containsFalse(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
