package org.bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class Test {
    public final ArrayList<Question> questions = new ArrayList<>();
    private final int currentQuestion;

    public Test() {
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
