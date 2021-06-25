package ru.job4j.tracker;

public class StubInput implements Input { //класс заменяет пользовательский ввод
    private String[] answers; //поле с вариантами ответов пользователя
    private int position = 0;
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        return askInt(question);

    }
}
