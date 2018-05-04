package app;

import db.DataSource;
import log.Log;

import static app.SCFunctionTypes.*;

/**
 * Obscures a string or reveals one. Errors are logged.
 * Successful translations are added to shadow_caster.db.
 */
public class ShadowCaster {

    private Log log;
    private DataSource dataSource;

    /**
     * Runs either obscure or reveal. Sends the initial and
     * translated string to the db.
     */
    //TODO come up with a better name for "item"
    public String execute(String item, SCFunctionTypes type) {
        String output = null;

        switch (type) {
            case OBSCURE:
                output = obscure(item);
                addToDB(item, output, OBSCURE);

                break;

            case REVEAL:
                output = reveal(item);
                addToDB(item, output, REVEAL);

                break;
        }

        return output;

    }


    /**
     * String obscurer.
     *
     * @param toObscure the string to obfuscate
     */
    private String obscure(String toObscure) {

        char[] chars = toObscure.toCharArray();
        var builder = new StringBuilder();

        for (char c : chars) {

            char newC = (char) (c + 6);
            builder.append(newC);

        }

        return builder.toString();

    }

    /**
     * Reveals an obscured string.
     *
     * @param toReveal obscured string to reveal
     */
    private String reveal(String toReveal) {

        if (toReveal == null) {
            var stringBuilder = new StringBuilder();
            //TODO complete error message

            log.write("Error in " + getClass());
            return null;
        }

        char[] chars = toReveal.toCharArray();
        var builder = new StringBuilder();

        for (char c : chars) {

            char newC = (char) (c - 6);
            builder.append(newC);
        }

        return builder.toString();

    }

    /**
     * Updates the db with the translated entry;
     *
     * @param input  the input string
     * @param output result of the translation
     * @param type   type of the transaction (reveal or obscure)
     */
    private void addToDB(String input, String output, SCFunctionTypes type) {
        dataSource = new DataSource();
        dataSource.addEntry(input, output, type);
    }

}