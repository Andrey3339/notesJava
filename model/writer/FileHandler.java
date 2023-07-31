package model.writer;

import model.Note;

import java.io.*;
import java.util.List;

public class FileHandler implements WritableLoadable {
    @Override
    public void writToFile(List<Note> notes, File file) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(notes);
        objectOutputStream.close();
    }

    @Override
    public List<Note> readFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        List<Note> notes = (List<Note>) objectInputStream.readObject();
        objectInputStream.close();
        return notes;
    }
}
