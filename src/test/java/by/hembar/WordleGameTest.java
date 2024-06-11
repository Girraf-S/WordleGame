package by.hembar;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordleGameTest {
    private static String word, fullFailGuess, failGuess, partiallyFailGuess, failLengthGuess, correctGuess;
    private static Color[] correctGuessColor, fullFailGuessColor, failGuessColor, partiallyFailGuessColor;
    private static WordleGame wordleGame;
    @BeforeClass
    public static void init() {
        word = "today";
        wordleGame= new WordleGame(word);

        partiallyFailGuess = "world";
        partiallyFailGuessColor =new Color[]{Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.YELLOW};

        failGuess = "phone";
        failGuessColor = new Color[]{Color.BLACK, Color.BLACK, Color.YELLOW, Color.BLACK, Color.BLACK};

        fullFailGuess = "guess";
        fullFailGuessColor = new Color[]{Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};

        failLengthGuess="carrot";

        correctGuess=word;

        correctGuessColor = new Color[]{Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN};
    }

    @Test
    public void guessMethodThrowException(){
        boolean exceptionThrown = false;
        try{
            wordleGame.guess(failLengthGuess);
        } catch (LenghtException e) {
            exceptionThrown=true;
        }
        assertTrue("Exception not thrown",exceptionThrown);
    }
    @Test
    public void guessMethodNotThrowException(){
        boolean exceptionThrown = false;
        try{
            wordleGame.guess(failGuess );
        } catch (LenghtException e) {
            exceptionThrown=true;
        }
        assertFalse("Exception thrown",exceptionThrown);
    }
    @Test
    public void correctGuess() {
        try {
            assertArrayEquals(correctGuessColor, wordleGame.guess(correctGuess));
        } catch (LenghtException ignored) {}
    }
    @Test
    public void partiallyFailGuess() {
        try {
            assertArrayEquals(partiallyFailGuessColor, wordleGame.guess(partiallyFailGuess));
        } catch (LenghtException ignored) {}
    }
    @Test
    public void failGuess() {
        try {
            assertArrayEquals(failGuessColor, wordleGame.guess(failGuess));
        } catch (LenghtException ignored) {}
    }
    @Test
    public void fullFailGuess() {
        try {
            assertArrayEquals(fullFailGuessColor, wordleGame.guess(fullFailGuess));
        } catch (LenghtException ignored) {}
    }

}