package org.bot;
import java.util.Scanner;

public class SimpleBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var bot = new Bot("Aid");

        System.out.println(bot.getGreeting());
        System.out.println("Please, remind me your name.");
        System.out.println(bot.getMeeting(scanner.next()));

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        System.out.println(bot.getAgeGuess(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble()));

        System.out.println("Now I will prove to you that I can count to any number you want.");
        System.out.println(bot.getCounter(scanner.nextInt()));
        System.out.println("Completed, have a nice day!");

        System.out.println("Let's test your programming knowledge.");
        var test = new Test();
        test.printQuestion();
        test.checkAnswer(scanner);
    }
}

