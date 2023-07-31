package presenter;

import model.Service;
import view.View;
public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addNote(String title, String body, String date) {

        service.addNote(title, body, date);
    }
    public void showNotesList() {
        String notesList = service.showNotesList();
        view.printAnswer(notesList);
    }
    public void saveNoteToFile() {

        service.saveNoteToFile();
    }
    public void sortNotesByDate() {

        service.sortNotesByDate();
        String notesList = service.showNotesList();
        view.printAnswer(notesList);
    }
    public void sortNotesById() {

        service.sortNotesById();
        String notesList = service.showNotesList();
        view.printAnswer(notesList);
    }
    public void searchForDailyNotes(String date) {

        String searchNoteList = service.searchForDailyNotes(date);
        view.printAnswer(searchNoteList);

    }
    public void loadAllNotesFromFile() {
        service.loadAllNotesFromFile();
    }
}
