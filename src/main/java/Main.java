import implementation.Input;
import implementation.Printer;
import interfaces.iInput;
import interfaces.iPrinter;

/**
 * Created by Yevhenii on 24.10.16.
 */
public class Main {

    public static void main(String[] args) {
        iPrinter printer = new Printer();
        iInput iInput = new Input();
        Game game = new Game(iInput, printer);
        game.play();
    }
}
