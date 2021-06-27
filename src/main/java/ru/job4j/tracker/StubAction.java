package ru.job4j.tracker;

public class StubAction implements UserAction { //класс для загрузки действия и проверки выполнения теста
    private boolean call = false; //выбрали пункт меню или нет
    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        call = true;
        return false;
    }
    public boolean isCall() {
        return call;
    }
}
