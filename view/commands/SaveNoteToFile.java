package view.commands;

import view.ConsoleUI;

public class SaveNoteToFile extends Command {
     public SaveNoteToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "сохранение заметки в файл.";
    }

    @Override
    public void execute() {
        consoleUI.saveNoteToFile();
    }
}
