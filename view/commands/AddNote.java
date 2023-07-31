package view.commands;

import view.ConsoleUI;

public class AddNote extends Command {
    public AddNote(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "добавление заметки.";
    }
    @Override
    public void execute() {
        consoleUI.addNote();
    }
}
