package view.commands;

import view.ConsoleUI;

public class SortNotesByDate extends Command {
    public SortNotesByDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "сортировка заметок по дате.";
    }

    @Override
    public void execute() {
        consoleUI.sortNotesByDate();
    }
}
