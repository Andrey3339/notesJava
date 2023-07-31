package model.writer;

import model.Note;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface WritableLoadable {
    public void writToFile(List<Note> notes, File file) throws IOException, ClassNotFoundException;
    public List<Note> readFromFile(File file) throws IOException, ClassNotFoundException;
}
