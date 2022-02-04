package ru.job4j.tracker;

/**
 * класс для загрузки действия и проверки выполнения теста
 * выбрали пункт меню или нет
 */
public class StubAction implements UserAction {
    private boolean call = false;
    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        call = true;
        return false;
    }
    public boolean isCall() {
        return call;
    }
}
