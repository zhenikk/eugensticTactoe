import interfaces.iInput;
import interfaces.iPrinter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Yevhenii on 25.10.16.
 */
@RunWith(JUnit4.class)
public class GameTest {


    @Mock
    iInput mInput;
    @Mock
    iPrinter mPrinter;

    private Game game;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        game = new Game(mInput, mPrinter);

    }

    @Test
    public void movesDown1stGamerWinTest() {
        Mockito.when(mInput.getInput())
                .thenReturn("0")
                .thenReturn("0")

                .thenReturn("1")
                .thenReturn("1")

                .thenReturn("1")
                .thenReturn("0")

                .thenReturn("2")
                .thenReturn("2")

                .thenReturn("2")
                .thenReturn("0")

                .thenReturn("1111");


        game.play();
        Mockito.verify(mPrinter).print("User#1 won");
    }


    @Test
    public void movesRightTest() {
        Mockito.when(mInput.getInput())

                .thenReturn("1")
                .thenReturn("1")

                .thenReturn("0")
                .thenReturn("2")

                .thenReturn("2")
                .thenReturn("2")

                .thenReturn("0")
                .thenReturn("1")

                .thenReturn("1")
                .thenReturn("2")

                .thenReturn("0")
                .thenReturn("0")

                .thenReturn("1111");

        game.play();
        Mockito.verify(mPrinter).print("User#2 won");


    }

    @Test

    public void movesFromLeftTopCornerTillDownTest() {
        Mockito.when(mInput.getInput())

                .thenReturn("2")
                .thenReturn("2")


                .thenReturn("1")
                .thenReturn("0")

                .thenReturn("1")
                .thenReturn("1")

                .thenReturn("1")
                .thenReturn("2")

                .thenReturn("0")
                .thenReturn("0")

                .thenReturn("1111");

        game.play();
        Mockito.verify(mPrinter).print("User#1 won");

    }
    @Test
    public void movesFromRightTopCornerTillDownTest() {
        Mockito.when(mInput.getInput())


                .thenReturn("2")
                .thenReturn("0")

                .thenReturn("1")
                .thenReturn("0")

                .thenReturn("1")
                .thenReturn("1")

                .thenReturn("1")
                .thenReturn("2")

                .thenReturn("0")
                .thenReturn("2")
                .thenReturn("1111");

        game.play();
        Mockito.verify(mPrinter).print("User#1 won");

    }
@Test
    public void movesLastRowTest() {
        Mockito.when(mInput.getInput())

                .thenReturn("1")
                .thenReturn("1")

                .thenReturn("2")
                .thenReturn("2")

                .thenReturn("0")
                .thenReturn("0")

                .thenReturn("2")
                .thenReturn("1")

                .thenReturn("1")
                .thenReturn("2")

                .thenReturn("2")
                .thenReturn("0")

                .thenReturn("1111");

        game.play();
        Mockito.verify(mPrinter).print("User#2 won");

    }
    @Test
    public void movesAverageRightTest() {
        Mockito.when(mInput.getInput())

                .thenReturn("0")
                .thenReturn("1")

                .thenReturn("1")
                .thenReturn("2")

                .thenReturn("2")
                .thenReturn("2")

                .thenReturn("1")
                .thenReturn("1")

                .thenReturn("0")
                .thenReturn("2")

                .thenReturn("1")
                .thenReturn("0")

                .thenReturn("1111");

        game.play();
        Mockito.verify(mPrinter).print("User#2 won");


    }@Test
    public void movesAverageBottomTest() {
        Mockito.when(mInput.getInput())

                .thenReturn("0")
                .thenReturn("1")

                .thenReturn("1")
                .thenReturn("2")

                .thenReturn("1")
                .thenReturn("1")

                .thenReturn("2")
                .thenReturn("2")

                .thenReturn("2")
                .thenReturn("1")


                .thenReturn("1111");

        game.play();
        Mockito.verify(mPrinter).print("User#1 won");


    }

}