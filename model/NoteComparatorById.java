package model;

import java.util.Comparator;

public class NoteComparatorById <T extends Note> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
