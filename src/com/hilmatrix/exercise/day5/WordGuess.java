package com.hilmatrix.exercise.day5;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {
    public String[] WORDS;
    public Random random;
    public Scanner scanner;

    public WordGuess(String[] WORDS) {
        this.WORDS = WORDS;
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public String selectRandomWord() {
        return WORDS[random.nextInt(WORDS.length)].toLowerCase();
    }

    public String hideWord(String word) {
        return "_".repeat(word.length());
    }

    public boolean isGameOver(int guessLeft) {
        return guessLeft <= 0;
    }

    public boolean isWinning(String hiddenWord) {
        for (int loop = 0; loop < hiddenWord.length(); loop++) {
            if (hiddenWord.charAt(loop) == '_')
                return false;
        }
        return true;
    }

    public String getPlayerGuess() {
        System.out.print("Your guess : ");
        return scanner.nextLine().toLowerCase();
    }

    public boolean isAlreadyGuessed(String hiddenWord, char charGuess) {
        return hiddenWord.contains(String.valueOf(charGuess));
    }

    public boolean isGuessCorrect(String word, char guess) {
        return word.contains(String.valueOf(guess));
    }

    public String updateHiddenWord(String word, String hiddenWord, char guess) {
        StringBuilder result = new StringBuilder();
        for (int loop = 0; loop < hiddenWord.length(); loop++) {
            if (Character.toLowerCase(word.charAt(loop)) == Character.toLowerCase(guess))
                result.append(guess);
            else
                result.append(hiddenWord.charAt(loop));
        }
        return result.toString();
    }

    public void displayGameResult(String wordToGuess, String hiddenWord, int  attemptsLeft) {
        if (isGameOver(attemptsLeft)) {
            System.out.println("Game over man !");
        }
        else {
            System.out.println("Congratulations, you win !");
        }
        System.out.println(wordToGuess + " -> " + hiddenWord );
        System.out.println("Attempts Left = " + attemptsLeft);
    }

    public void startGame() {
        String chosenWord = selectRandomWord();
        String hiddenWord = hideWord(chosenWord);
        int guessLeft = chosenWord.length();

        while (!isGameOver(guessLeft) && !isWinning(hiddenWord)) {
            System.out.println("Current guess : " + hiddenWord);
            System.out.println("Attempt left : " + guessLeft);
            String inputGuess = getPlayerGuess();

            if (inputGuess.isEmpty()) {
                System.out.println("Invalid empty input");
                System.out.println();
                continue;
            }

            char charGuess = inputGuess.charAt(0);

            if (isAlreadyGuessed(hiddenWord, charGuess)) {
                System.out.println("That character is already guessed");
                System.out.println();
                guessLeft--;
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
