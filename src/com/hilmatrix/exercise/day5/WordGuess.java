package com.hilmatrix.exercise.day5;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    public String[] WORDS;
    public Random random;
    public Scanner scanner;
    public String chosenWord;
    public String hiddenWord;
    public int guessLeft;

    public WordGuess(String[] WORDS) {
        this.WORDS = WORDS;
        random = new Random();
        scanner = new Scanner(System.in);
        guessLeft = 0;
    }

    public String selectRandomWord() {
        return chosenWord = WORDS[random.nextInt(WORDS.length)];
    }

    public String hideWord(String word) {
        String hiddenWord = "";
        for (int loop = 0; loop < word.length(); loop++)
            hiddenWord += "_";
        return hiddenWord;
    }

    public boolean isGameOver() {
        return guessLeft <= 0;
    }

    public boolean isWinning() {
        for (int loop = 0; loop < hiddenWord.length(); loop++) {
            if (hiddenWord.charAt(loop) == '_')
                return false;
        }
        return true;
    }

    public void startGame() {
        chosenWord = selectRandomWord();
        hiddenWord = hideWord(chosenWord);
        guessLeft = chosenWord.length();

        loopGame();
    }

    public String getPlayerGuess() {
        System.out.print("Your guess : ");
        return scanner.nextLine();
    }

    public boolean isAlreadyGuessed(char charGuess) {
        return hiddenWord.contains(String.valueOf(charGuess));
    }

    public boolean isGuessCorrect(String word, char guess) {
        return word.contains(String.valueOf(guess));
    }

    public String updateHiddenWord(String word, String hiddenWord, char guess) {
        String result = "";
        for (int loop = 0; loop < hiddenWord.length(); loop++) {
            if (Character.toLowerCase(word.charAt(loop)) == Character.toLowerCase(guess))
                result += guess;
            else
                result += hiddenWord.charAt(loop);
        }
        return result;
    }

    public void displayGameResult(String wordToGuess, String hiddenWord, int  attemptsLeft) {
        if (isGameOver()) {
            System.out.println("Game over man !");
        }
        else {
            System.out.println("Congratulations, you win !");
        }
        System.out.println(wordToGuess + " -> " + hiddenWord );
        System.out.println("Attempts Left = " + attemptsLeft);
    }

    public void loopGame() {
        while (!isGameOver() && !isWinning()) {
            System.out.println("Current guess : " + hiddenWord);
            System.out.println("Attempt left : " + guessLeft);
            String inputGuess = getPlayerGuess();

            if (inputGuess.length() < 1) {
                System.out.println("Invalid empty input");
                System.out.println();
                continue;
            }

            char charGuess = inputGuess.charAt(0);

            if (isAlreadyGuessed(charGuess)) {
                System.out.println("That character is already guessed");
                System.out.println();
                continue;
            }

            if (isGuessCorrect(chosenWord, charGuess)) {
                System.out.println("Correct !");
                System.out.println();
                hiddenWord = updateHiddenWord(chosenWord, hiddenWord, charGuess);
            } else {
                System.out.println("Wrong !");
                System.out.println();
                guessLeft--;
            }
        }
        displayGameResult(chosenWord, hiddenWord, guessLeft);
    }
}
