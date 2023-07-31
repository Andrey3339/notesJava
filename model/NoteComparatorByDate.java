package model;

import java.util.Comparator;

public class NoteComparatorByDate<T extends Note> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
