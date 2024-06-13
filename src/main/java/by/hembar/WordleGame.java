package by.hembar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordleGame {
    private String word;

    public Color[] guess(String guessWord) {
        validator(guessWord);
        Color[] guessResult = initGuessResult();

        for (int i = 0; i < word.length(); i++) {
            if (word.toCharArray()[i] == guessWord.toCharArray()[i]) {
                guessResult[i] = Color.GREEN;
            } else {
                for (int j = 0; j < word.length(); j++) {
                    if (word.toCharArray()[i] == guessWord.toCharArray()[j]) {
                        guessResult[j] = Color.YELLOW;
                        break;
                    }
                }
            }
        }
        return guessResult;
    }

    private void validator(String guessWord) {
        if (StringUtils.isEmpty(guessWord)){
            throw new RuntimeException("Empty argument or NPE");
        }
        if(StringUtils.isEmpty(word)){
            throw new RuntimeException("Empty field \"word\" in class WordleGame");
        }
        if (guessWord.length() != word.length()) {
            throw new LenghtException("Incorrect length of guess");
        }
    }

    private Color[] initGuessResult() {
        Color[] guessResult = new Color[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessResult[i] = Color.BLACK;
        }
        return guessResult;
    }
}
