package bowling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {
    public static Stream<Arguments> provideScoresAndResult() {
        return Stream.of(
                Arguments.of(new Scores(10), true),
                Arguments.of(new Scores(9, 1), true),
                Arguments.of(new Scores(0, 0), true),
                Arguments.of(new Scores(2), false)
        );
    }

    @Test
    void 생성() {
        assertThat(new Frame().getScores().size()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("provideScoresAndResult")
    void 프레임_완료_확인(Scores scores, boolean result) {
        assertThat(new Frame(scores).isEnd()).isEqualTo(result);
    }


    @Test
    void 입력값_프레임에_추가() {
        Frame frame = new Frame();
        frame.addScore(new Score(10));
        assertThat(frame.getScores().getScores()).contains(new Score(10));
    }
}
