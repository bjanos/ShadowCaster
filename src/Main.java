/**
 * @author Janos Benyovszki
 */
public class Main {


    private static String WORD = "PasswordIsHard12";

    public static void main(String[] args) {

        var obscured = obscure(WORD);

        System.out.println(obscured);
        System.out.println(reveal(obscured));

    }

    private static String obscure(String toObscure) {

        char[] chars = toObscure.toCharArray();
        var builder = new StringBuilder();

        for (char c : chars) {

            char newC = (char) (c + 6);
            builder.append(newC);

        }

        return builder.toString();

    }

    private static String reveal(String toReveal) {

        char[] chars = toReveal.toCharArray();
        var builder = new StringBuilder();

        for (char c : chars) {

            char newC = (char) (c - 6);
            builder.append(newC);

        }

        return builder.toString();

    }
}
