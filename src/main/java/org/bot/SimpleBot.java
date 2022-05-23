package org.bot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

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

class Test {
    public final ArrayList<Question> questions = new ArrayList<>();
    private final int currentQuestion;
    public Test () {
        this.questions.add(new Question("Why do we use methods?", new String[]{
                "To repeat a statement multiple times.",
                "To decompose a program into several small subroutines.",
                "To determine the execution time of a program.",
                "To interrupt the execution of a program."
        }, 2));
        this.currentQuestion = 0;
    }
    public void printQuestion() {
        var currentQuestion = questions.get(this.currentQuestion);
        System.out.println(currentQuestion.question + "\n" + getAnswers());
    }
    public void checkAnswer(Scanner scanner) {
        while (scanner.hasNextInt()) {
            var answer = scanner.nextInt();
            if (answer == questions.get(this.currentQuestion).correctAnswer) {
                System.out.println("Congratulations, have a nice day!");
                break;
            } else {
                System.out.println("Please, try again.");
            }
        }
    }
    private String getAnswers() {
        AtomicInteger index = new AtomicInteger(0);
        return Arrays.stream(questions.get(currentQuestion).answers).reduce("", (string, question) -> {
            index.getAndIncrement();
            return string + index + ". " + question + "\n";
        }).trim();
    }
}

class Question {
    public final String question;
    public final String[] answers;
    public final int correctAnswer;
    public Question(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}

class Bot {
    private final String name;
    private final Calendar birthDay;

    public Bot(String name) {
        this.name = name;
        this.birthDay = Calendar.getInstance();
    }

    public String getGreeting() {
        String greetingTemplate = "Hello! My name is %s.\nI was created in %s.";
        return String.format(greetingTemplate, name, birthDay.get(Calendar.YEAR));
    }

    public String getMeeting(String name) {
        String answerTemplate = "What a great name you have, %s!";
        return String.format(answerTemplate, name);
    }

    public String getAgeGuess(Double remainder3, Double remainder5, Double remainder7) {
        var age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        String ageGuessTemplate = "Your age is %s; that's a good time to start programming!";
        return String.format(ageGuessTemplate, age);
    }

    public String getCounter(int number) {
        StringBuilder counter = new StringBuilder();
        for (var i = 0; i <= number; i++) {
            counter.append(i).append("!");
            if (i < number) {
                counter.append("\n");
            }
        }
        return counter.toString();
    }
}