import db.DataSource;

/**
 * @author Janos Benyovszki
 */
public class Main {


    private static String WORD = "PasswordIsHard12";

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        dataSource.executeQuery();

    }



}
