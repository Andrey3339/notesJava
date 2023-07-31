package view.commands;

import view.ConsoleUI;

public class SortNotesById extends Command {
    public SortNotesById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "сортировка заметок по id.";
    }

    @Override
    public void execute() {
        consoleUI.sortNotesById();
    }
}

