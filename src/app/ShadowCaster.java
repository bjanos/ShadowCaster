package app;

import log.Log;
import log.LogTypes;

/**
 * Obscures a string or reveals one. Errors are logged.
 * Successful translations are added to shadow_caster.db.
 */
public class ShadowCaster {

    private Log log;

    public ShadowCaster() {
        log = new Log();
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
            stringBuilder.append(LogTypes.ERROR);
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

}
