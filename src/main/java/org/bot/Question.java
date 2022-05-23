package org.bot;

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
