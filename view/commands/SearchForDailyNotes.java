package view.commands;

import view.ConsoleUI;

public class SearchForDailyNotes extends Command {
    public SearchForDailyNotes(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "поиск заметок за день.";
    }

    @Override
    public void execute() {
        consoleUI.searchForDailyNotes();
    }
}