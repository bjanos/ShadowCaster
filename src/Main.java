import app.ShadowCaster;
import db.DataSource;

import static app.SCFunctionTypes.*;

/**
 * @author Janos Benyovszki
 */
public class Main {

    public static void main(String[] args) {

        var dataSource = new DataSource();
        var shadowCaster = new ShadowCaster();
        var word = "Password2018ABC!%&$";
        String obscured;

        obscured = shadowCaster.execute(word, OBSCURE);

        System.out.println(obscured);
        System.out.println(shadowCaster.execute(obscured, REVEAL));

    }


}
