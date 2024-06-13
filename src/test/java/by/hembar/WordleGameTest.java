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

    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("world", List.of(new Color[]{
                        Color.YELLOW, Color.GREEN, Color.BLACK, Color.YELLOW, Color.BLACK
                })),
                Arguments.of("hello", List.of(new Color[]{
                        Color.BLACK, Color.YELLOW, Color.YELLOW, Color.BLACK, Color.YELLOW
                })),
                Arguments.of("again", List.of(new Color[]{
                        Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
                })),
                Arguments.of("tests", List.of(new Color[]{
                        Color.BLACK, Color.YELLOW, Color.BLACK, Color.BLACK, Color.BLACK
                })),
                Arguments.of("tools", List.of(new Color[]{
                        Color.BLACK, Color.GREEN, Color.BLACK, Color.YELLOW, Color.BLACK
                })),
                Arguments.of("terms", List.of(new Color[]{
                        Color.BLACK, Color.YELLOW, Color.BLACK, Color.BLACK, Color.BLACK
                })),
                Arguments.of("ooooo", List.of(new Color[]{
                        Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.BLACK
                })),
                Arguments.of("vvvvv", List.of(new Color[]{
                        Color.GREEN, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
                })),
                Arguments.of("vowle", List.of(new Color[]{
                        Color.GREEN, Color.GREEN, Color.GREEN, Color.YELLOW, Color.YELLOW
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
        String word = "vowel";
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
        assertEquals(List.of(wordleGame.guess(guessWord)), resultColor);
    }
}