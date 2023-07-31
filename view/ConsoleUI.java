package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private MainMenu mainMenu;
    private Scanner scanner;
    private boolean work;
    public ConsoleUI() {

        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        scanner = new Scanner(System.in);
        work = true;
    }
    public void addNote() {
        System.out.print("Введите название заметки: ");
        String title = scanner.nextLine();

        System.out.print("Введите тело заметки: ");
        String body = scanner.nextLine();

        System.out.print("Введите дату и время: ");
        String date = scanner.nextLine();

        presenter.addNote(title, body, date);
    }
    public void showNotesList() {
        presenter.showNotesList();
    }
    public void saveNoteToFile() {
        presenter.saveNoteToFile();
    }
    public void sortNotesByDate() {
        presenter.sortNotesByDate();
    }
    public void sortNotesById() {

        presenter.sortNotesById();
    }
    public void searchForDailyNotes() {
        System.out.print("Введите дату заметки: ");
        String date = scanner.nextLine();
        presenter.searchForDailyNotes(date);
    }

    public void finish() {
        System.out.println("до скорых встреч.");
        work = false;
    }
    @Override
    public void printAnswer(String text) {
        System.out.print(text);
    }
    @Override
    public void start() {
        presenter.loadAllNotesFromFile();
        while(work) {
            System.out.println();
            System.out.print(mainMenu.menu());
            String line = scanner.nextLine();
            try {
                int choice = Integer.parseInt(line);
                if (choice > 0 & choice <= mainMenu.getSize())
                    mainMenu.execute(choice);
                else
                    System.out.println("Вы ввели что-то не то");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
