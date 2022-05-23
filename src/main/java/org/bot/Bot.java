package org.bot;

import java.util.Calendar;

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
