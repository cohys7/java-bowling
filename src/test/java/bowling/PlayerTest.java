package bowling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"ab", "123", "ab1", "abcd", "ab*"})
    void 이름_알파벳_3글자_아님(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(BowlingGameException.class)
                .hasMessage(ErrorMessage.WRONG_NAME_FORMAT.getMessage());
    }

    @Test
    void 이름_알파벳_3글자() {
        assertThatNoException().isThrownBy(() -> new Player("abc"));
    }
}
