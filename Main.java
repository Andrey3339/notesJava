import view.ConsoleUI;
import view.DesktopUI;
import view.View;

public class Main {
    public static void main(String[] args) {
        //View view = new ConsoleUI();
        //view.start();
        View view = new DesktopUI();
        view.start();
    }
}