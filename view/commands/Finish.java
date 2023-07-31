package view.commands;

import view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "завершение работы.";
    }
    @Override
    public void execute() {
        consoleUI.finish();
    }
}
