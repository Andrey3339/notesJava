package view;

import presenter.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopUI extends JFrame implements View {
    private Presenter presenter;
    private JLabel showNotesListLabel, addNoteLabel, saveNoteToFileLabel, sortNotesByDateLabel;
    private JLabel sortNotesByIdLabel, searchForDailyNotesLabel, newNameLabel, newBodyLabel, newDateLabel;
    private JTextArea listNotesArea;
    private JLabel listNotesAreaLabel, searchForDailyNotesDateLabel;
    private JTextField newNameField, newBodyField, newDateField, searchForDailyNotesDateField;
    private JButton showNotesButton, addNoteButton, saveNoteToFileButton, sortNotesByDateButton, sortNotesByIdButton;
    private JButton searchForDailyNotesButton;

    public DesktopUI() {
        presenter = new Presenter(this);
    }
    @Override
    public void start() {
        presenter.loadAllNotesFromFile();
        setSize(850,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showNotesListLabel = new JLabel("Список заметок");
        addNoteLabel = new JLabel("Добавить заметку");
        saveNoteToFileLabel = new JLabel("Сохранить заметку");
        sortNotesByDateLabel = new JLabel("Сортировать по дате");
        sortNotesByIdLabel = new JLabel("Сортировать по id");
        searchForDailyNotesLabel = new JLabel("Поиск по дате");

        newNameLabel = new JLabel("Название новой заметки");
        newBodyLabel = new JLabel("Тело новой заметки");
        newDateLabel = new JLabel("Дата новой заметки");
        searchForDailyNotesDateLabel = new JLabel("Поиск заметок по дате");

        listNotesAreaLabel = new JLabel("Список заметок");
        listNotesArea = new JTextArea();

        newNameField = new JTextField();
        newBodyField = new JTextField();
        newDateField = new JTextField();
        searchForDailyNotesDateField = new JTextField();

        showNotesButton = new JButton("Список заметок");
        addNoteButton = new JButton("Добавить заметку");
        saveNoteToFileButton = new JButton("Сохранить заметку");
        sortNotesByDateButton = new JButton("Сортировать по дате");
        sortNotesByIdButton = new JButton("Сортировать по id");
        searchForDailyNotesButton = new JButton("Поиск по дате");

        setLayout(null);

        add(showNotesListLabel); add(addNoteLabel); add(saveNoteToFileLabel); add(sortNotesByDateLabel);
        add(sortNotesByIdLabel); add(searchForDailyNotesLabel); add(newNameLabel); add(newBodyLabel);
        add(newDateLabel); add(listNotesArea); add(newNameField); add(newBodyField); add(newDateField);
        add(searchForDailyNotesDateField); add(showNotesButton); add(addNoteButton); add(saveNoteToFileButton);
        add(sortNotesByDateButton); add(sortNotesByIdButton); add(searchForDailyNotesButton);
        add(listNotesAreaLabel); add(searchForDailyNotesDateLabel);

        showNotesListLabel.setBounds(20,20,120,30); showNotesButton.setBounds(170,20,180,20);
        addNoteLabel.setBounds(20,50,150,30); addNoteButton.setBounds(170,50,180,20);
        saveNoteToFileLabel.setBounds(20, 80, 150, 30); saveNoteToFileButton.setBounds(170,80,180,20);
        sortNotesByDateLabel.setBounds(20,110,150,30); sortNotesByDateButton.setBounds(170,110,180,20);
        sortNotesByIdLabel.setBounds(20,140,150,30); sortNotesByIdButton.setBounds(170,140,180,20);
        searchForDailyNotesLabel.setBounds(20,170,150,30); searchForDailyNotesButton.setBounds(170,170,180,20);

        listNotesAreaLabel.setBounds(380, 20, 150, 30); listNotesArea.setBounds(380, 50, 430, 250);

        newNameLabel.setBounds(20,200,150,20); newNameField.setBounds(170,200,180,20);
        newBodyLabel.setBounds(20,230,150,20); newBodyField.setBounds(170,230,180,20);
        newDateLabel.setBounds(20,260,150,20); newDateField.setBounds(170,260,180,20);
        searchForDailyNotesDateLabel.setBounds(20,290,150,20);
        searchForDailyNotesDateField.setBounds(170,290,180,20);

        setVisible(true);

        showNotesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.showNotesList();
            }
        });
        addNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String title = newNameField.getText();
                String body = newBodyField.getText();
                String date = newDateField.getText();

                presenter.addNote(title, body, date);
            }
        });
        saveNoteToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.saveNoteToFile();
                presenter.showNotesList();
            }
        });
        sortNotesByDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.sortNotesByDate();
            }
        });
        sortNotesByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.sortNotesById();
            }
        });
        searchForDailyNotesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = searchForDailyNotesDateField.getText();
                presenter.searchForDailyNotes(date);
            }
        });
    }

    @Override
    public void printAnswer(String text) {
        listNotesArea.setText(text);
    }
}
