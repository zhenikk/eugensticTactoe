package implementation;

import interfaces.iInput;

import java.util.Scanner;

/**
 * Created by Yevhenii on 25.10.16.
 */
public class Input implements iInput {
    public String getInput() {
        return new Scanner(System.in).nextLine();
    }
}
