package by.hembar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordleGame {
    private String word;
    public Color[] guess(String guessWord) throws LenghtException {
        if(guessWord.length()!=word.length()){
            throw new LenghtException("Длинна загаданного слова "+word.length()+"!");
        }
        Color[] guessResult = initGuessResult();

        for (int i = 0; i < word.length(); i++) {
            if(word.toCharArray()[i] == guessWord.toCharArray()[i]){
                guessResult[i] = Color.GREEN;
            }
            else{
                for (int j = 0; j < word.length(); j++) {
                    if(word.toCharArray()[j] == guessWord.toCharArray()[i]){
                        guessResult[i]=Color.YELLOW;
                        break;
                    }
                }
            }
        }
        return guessResult;
    }
    private Color[] initGuessResult(){
        Color[] guessResult = new Color[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessResult[i]=Color.BLACK;
        }
        return guessResult;
    }
}
