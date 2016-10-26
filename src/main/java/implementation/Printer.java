package implementation;

import interfaces.iPrinter;

/**
 * Created by Yevhenii on 25.10.16.
 */
public class Printer implements iPrinter {

    public void print(String string) {
        System.out.println(string);
    }
}
