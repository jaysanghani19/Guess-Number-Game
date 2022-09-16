package guessnumber;

import java.util.Random;
import java.util.Scanner;

class guessANumber {
    int randomnumber;
    static int takeinput;
    int noofguess = 0;
    Scanner sc = new Scanner(System.in);

    // This is method for recognize wrong choice entered by user and take input again
    public void wronngChoice(int input){
        while (input<0 || input>100){
        if (input<0 || input>100){
            System.out.println("You've Entered Wrongchoice.");
            System.out.println("Make your choice is between 0-100");
        }
            System.out.println(" ");
            System.out.println("Enter your choice Again");
           input=sc.nextInt();
        }
    }
    // This is method for generaterandom number for guess the number

    public void generateRandomNumber() {
        Random random = new Random();
        randomnumber = random.nextInt(100 + 2);

    }
    // Input is method for takeinput from user
    public  void input() {
        takeinput = sc.nextInt();
    }
    // isCorrectNumber method for user input's number is Equal to generatedNumber
    public void isCorrectNumber() {
        if (takeinput == randomnumber) {
            System.out.println("You guessed the right. You won the game");
        } else if (takeinput < randomnumber) {
            System.out.println("Your guess is less than the real value");
        } else if (takeinput > randomnumber) {
            System.out.println("Your guess is greater than the real value");
        } else if (takeinput < 0 || takeinput > 100) {
            System.out.println("You've entered the wrong value");
        }
    }
    // This method return Noofguess
    public int getNoOfGuess() {
        return noofguess;
    }

    public void setNoofguess(int noofguess) {
        this.noofguess = noofguess;
    }
}

public class GuessNumber {
    // This is main loop
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        guessANumber game = new guessANumber();
        game.generateRandomNumber(); // Generate The random number
        int random = game.randomnumber;//Assign the random number to integer

        game.setNoofguess(1);//intialize the  Noofguess
        System.out.println("Welcome to GuessNumberGame by Jay Sanghani");
        System.out.println("Enter Your Guess Between 0-100");
        System.out.println(" ");
        // Taking input
        System.out.println("Enter your Guess ");
        game.input();
        int Rinput = guessANumber.takeinput;
        game.wronngChoice(Rinput);
        game.isCorrectNumber();
        for (int x = 0; x < 99; x++) {

            if (Rinput != random) {
                System.out.println("Enter your Guess ");
                game.input();
                Rinput = game.takeinput;
                game.wronngChoice(Rinput);
                if (Rinput<0 || Rinput>100){
                    System.out.println("You've Entered Wrongchoice.");
                }
                while (Rinput<0 || Rinput>100){
                    System.out.println("Enter your choice");
                    Rinput=sc.nextInt();
                }
                game.isCorrectNumber();
                game.noofguess++;

            } else {
                System.out.println("You've won game in " + game.noofguess+" Guess");
                break;
            }
            System.out.println(" ");
        }
    }
}
