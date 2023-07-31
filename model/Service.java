package model;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Service {
    private final List<Note> notesList;
    public Service() {
        notesList = new LinkedList<>();
    }
    public void loadAllNotesFromFile() {
        try (BufferedReader in = new BufferedReader(new FileReader("src/notes.txt"))) {
            String str;
            while((str = in.readLine()) != null) {
                String[] noteString = str.split(":::");
                notesList.add(new Note(noteString[1], noteString[2], noteString[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addNote(String title, String body, String date) {
        Note note = new Note(title, body, date);
        notesList.add(note);
    }
    public String showNotesList() {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Заметки: \n");
        for (Note note: notesList) {
            stringBuilder.append(note);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void saveNoteToFile() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/notes.txt"))) {
            for (Note note : notesList) {
                out.write(note.getId());
                out.write(":::");
                out.write(note.getTitle());
                out.write(":::");
                out.write(note.getBody());
                out.write(":::");
                out.write(note.getDate());
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sortNotesByDate() {
        notesList.sort(new NoteComparatorByDate<Note>());
    }
    public void sortNotesById() {
        notesList.sort(new NoteComparatorById<Note>());
    }
    public String searchForDailyNotes(String date) {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Заметки на дату " + date + ":\n");
        for (Note note: notesList) {
            if (note.getDate().equals(date)) {
                stringBuilder.append(note);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
