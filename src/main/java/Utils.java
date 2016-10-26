/**
 * Created by Yevhenii on 25.10.16.
 */
public class Utils {
    public static String convertArrayToString(char[][] array) {
        StringBuilder sb = new StringBuilder();
        String s = "";
        sb.append("  ");

        for (int i = 0; i < array[0].length; i++) {
            sb.append(i);
            sb.append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < array.length; i++) {
            sb.append(i);
            sb.append("|");

            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] != 0) {
                    sb.append(array[i][j]).append(" ");
                } else {
                    sb.append("_ ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
