package view.commands;

import view.ConsoleUI;

public class ShowNotesList extends Command {
    public ShowNotesList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "показ списка заметок.";
    }
    @Override
    public void execute() {
        consoleUI.showNotesList();
    }
}
