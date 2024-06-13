package by.hembar;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class LenghtException extends RuntimeException{
    public LenghtException(String message){
        super(message);
    }

}
