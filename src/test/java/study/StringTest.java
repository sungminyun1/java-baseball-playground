package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        //given
        String str = "1,2";

        //when
        String[] spl = str.split(",");

        //then
        assertThat(spl).containsExactly("1", "2");
    }

    @Test
    void split2() {
        //given
        String str = "1";

        //when
        String[] spl = str.split(",");

        //then
        assertThat(spl).containsExactly("1");
    }

    @Test
    void subString() {
        //given
        String str = "(1,2)";

        //when
        String sub = str.substring(1, 4);

        //then
        assertThat(sub).isEqualTo("1,2");
    }

    @DisplayName("charAt method를 이용해 String의 특정 위치 문자를 가져온다")
    @Test
    void charAt() {
        //given
        String str = "abc";

        //when
        char ch = str.charAt(0);

        //then
        assertThat(ch).isEqualTo('a');
    }

    @DisplayName("charAt method를 사용할때 문자열의 길이를 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    @Test
    void charAtException() {
        //given
        String str = "abc";

        //when //then
        assertThatThrownBy(()-> str.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
