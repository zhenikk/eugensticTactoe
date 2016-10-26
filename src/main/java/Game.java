import interfaces.iInput;
import interfaces.iPrinter;

/**
 * Created by Yevhenii on 24.10.16.
 */
public class Game {

    private static final int cellsCount = 3;
    private char[][] mGameArray = new char[cellsCount][cellsCount];

    private int mActiveUser;

    private iPrinter mPrinter;
    private iInput mInput;
    private boolean mGameRunning;

    public Game(iInput mInput, iPrinter mPrinter) {
        this.mPrinter = mPrinter;
        this.mInput = mInput;
        mActiveUser = 1;
    }

    void play() {
        mGameRunning = true;
        while (mGameRunning) {
            try {

                mPrinter.print("row:");
                int x = Integer.valueOf(mInput.getInput());

                if (x == 1111) mGameRunning = false;
                if (!mGameRunning) break;

                mPrinter.print("col:");
                int y = Integer.valueOf(mInput.getInput());
                makeMove(x, y);

            } catch (NumberFormatException e) {
                mPrinter.print("Wrong format of coordinates");
            }
        }

    }

    private void makeMove(int x, int y) {
        if (getCellStatus(x, y) == 0) {

            //cell is empty can make move;

            mGameArray[x][y] = getAppropriateSymbol();
            mPrinter.print(Utils.convertArrayToString(mGameArray));
            if (checkStop()) {
                mGameRunning = false;
            }
            changeEmptyUser();

        } else mPrinter.print("Cell is already used");


    }

    private void changeEmptyUser() {
        if (mActiveUser == 1) {
            mActiveUser = 2;
        } else if (mActiveUser == 2) mActiveUser = 1;
    }

    private char getAppropriateSymbol() {
        if (mActiveUser == 1) {
            return 'X';
        } else if (mActiveUser == 2) {
            return '0';
        }
        return ' ';
    }

    //check if out of bounds.
    private int getCellStatus(int x, int y) {
        //status  =1 if busy
        //status = 0 if empty
        //status = -1 if out OfBounds

        int status = 0;

        if (x >= cellsCount || y >= cellsCount || x < 0 || y < 0) {
            status = -1;

        } else if (mGameArray[x][y] != 0) {
            status = 1;
        }
        return status;

    }


    private boolean checkStop() {
        for (int i = 1; i <= 7; i++) {
            if (recursiveCheckWin(i)) {
                mPrinter.print("User#" + mActiveUser + " won");
                return true;
            }
        }
        return false;
    }

    private boolean recursiveCheckWin(int cellCombination) {

    // for every cell there are max 3 combinations
    //
    //    |___|___|___|
    //    |___|___|___|
    //    |___|___|___|


        switch (cellCombination) {
            case 1:
                // 0,0

                if (checkRight(0, 0, 0)) {
                    return true;
                } else if (checkDown(0, 0, 0)) {
                    return true;
                } else if (checkLeftTopRightBottom(0, 0, 0)) {
                    return true;
                } else return false;

            case 2:
                //right-last cell

                if (checkRight(0, 0, 0)) {
                    return true;
                } else if (checkDown(0, cellsCount - 1, 0)) {
                    return true;
                } else if (checkLastRightBottomLeft(0, cellsCount - 1, 0)) {
                    return true;
                } else return false;
            case 3:
                //left down-last cell

                if (checkRight(cellsCount - 1, 0, 0)) {
                    return true;
                } else if (checkDown(0, 0, 0)) {
                    return true;
                }
                else return false;
            case 4:

                //check medium cells
                //left down-last cell

                for (int i = 1; i < cellsCount - 1; i++) {
                    if (checkDown(0, i, 0)) {
                        return true;
                    }
                }
                return false;
            case 5:

                //check medium row cells
                //left down-last cell

                for (int i = 1; i < cellsCount - 1; i++) {
                    if (checkRight(i, 0, 0)) {
                        return true;
                    }
                }
                return false;

            default:
                return false;
        }

    }

    private boolean checkRight(int x, int y, int sameCellsCount) {
        if (getCellStatus(x, y + 1) == 1) { //cell is inside bounds, we can check it
            if (mGameArray[x][y + 1] == getAppropriateSymbol() && mGameArray[x][y] == getAppropriateSymbol()) {
                sameCellsCount = sameCellsCount + 1;
                if (sameCellsCount == cellsCount - 1) {
                    return true;//user win
                } else {
                    return checkRight(x, y + 1, sameCellsCount);
                }
            }

        }

        return false;
    }

    private boolean checkDown(int x, int y, int sameCellsCount) {
        if (getCellStatus(x + 1, y) == 1) { //cell is inside bounds, we can check it
            if (mGameArray[x + 1][y] == getAppropriateSymbol() && mGameArray[x][y] == getAppropriateSymbol()) {
                sameCellsCount = sameCellsCount + 1;

                if (sameCellsCount == cellsCount - 1) {
                    return true;//user win
                } else {
                    return checkDown(x + 1, y, sameCellsCount);
                }
            }

        }

        return false;
    }


    private boolean checkLastRightBottomLeft(int x, int y, int sameCellsCount) {
        if (getCellStatus(x + 1, y - 1) == 1) { //cell is inside bounds, we can check it
            if (mGameArray[x + 1][y - 1] == getAppropriateSymbol() && mGameArray[x][y] == getAppropriateSymbol()) {
                sameCellsCount = sameCellsCount + 1;
                if (sameCellsCount == cellsCount - 1) {
                    return true;//user win
                } else {
                    return checkLastRightBottomLeft(x + 1, y - 1, sameCellsCount);
                }
            }
        }
        return false;
    }


    private boolean checkLeftTopRightBottom(int x, int y, int sameCellsCount) {
        if (getCellStatus(x + 1, y + 1) == 1) { //cell is inside bounds, we can check it
            if (mGameArray[x + 1][y + 1] == getAppropriateSymbol() && mGameArray[x][y] == getAppropriateSymbol()) {
                sameCellsCount = sameCellsCount + 1;
                if (sameCellsCount == cellsCount - 1) {
                    return true;//user win
                } else {
                    return checkLeftTopRightBottom(x + 1, y + 1, sameCellsCount);
                }
            }
        } else {
            mPrinter.print("not valid statement");
        }
        return false;
    }


}