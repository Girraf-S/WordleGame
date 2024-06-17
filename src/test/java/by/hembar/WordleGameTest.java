package by.hembar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WordleGameTest {
    private static WordleGame wordleGame;
//ataat
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("aaaat", List.of(new Color[]{
                        Color.GREEN, Color.BLACK, Color.GREEN, Color.GREEN, Color.GREEN
                })),
                Arguments.of("taaha", List.of(new Color[]{
                        Color.YELLOW, Color.YELLOW, Color.GREEN, Color.BLACK, Color.YELLOW
                })),
                Arguments.of("hhhhk", List.of(new Color[]{
                        Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
                })),
                Arguments.of("ataat", List.of(new Color[]{
                        Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN
                })),
                Arguments.of("ttatt", List.of(new Color[]{
                        Color.BLACK, Color.GREEN, Color.GREEN, Color.BLACK, Color.GREEN
                })),
                Arguments.of("tatta", List.of(new Color[]{
                        Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.BLACK, Color.YELLOW
                }))
        );
    }

    private static Stream<Arguments> exceptionParams() {
        return Stream.of(
                Arguments.of(null, "smth", "Empty field \"word\" in class WordleGame"),
                Arguments.of("", "smth", "Empty field \"word\" in class WordleGame"),
                Arguments.of("smth", null, "Empty argument or NPE"),
                Arguments.of("smth", "", "Empty argument or NPE"),
                Arguments.of("something", "smth", "Incorrect length of guess")
        );
    }

    @BeforeAll
    public static void init() {
        String word = "ataat";
        wordleGame = new WordleGame(word);
    }

    @ParameterizedTest
    @MethodSource("exceptionParams")
    public void guessMethodThrowException(String word, String guessWord, String message) {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new WordleGame(word).guess(guessWord), message);
        assertEquals(exception.getMessage(), message);
    }

    @ParameterizedTest
    @MethodSource("params")
    public void guess(String guessWord, List<Color> resultColor) {
        assertEquals(resultColor, List.of(wordleGame.guess(guessWord)));
    }
}