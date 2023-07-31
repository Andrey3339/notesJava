package model;
public class Note {
    private static int nextId = 1;
    private int id;
    private String title;
    private String body;
    private String date;
    public Note(String title, String body, String date) {
        id = nextId++;
        this.title = title;
        this.body = body;
        this.date = date;
    }
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
    public String getId() {
        return String.valueOf(id);
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }
}
