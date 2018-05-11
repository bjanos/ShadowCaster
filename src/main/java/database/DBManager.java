package database;

import app.SCFunctionTypes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Contains and manages queries to the database.
 *
 * @author Janos Benyovszki
 */
public class DBManager {

    public static final String TABLE_OBSCURE = "transactions";
    private static final String COLUMN_OBSCURE_ID = "_id";
    private static final String COLUMN_OBSCURE_TYPE = "type";
    private static final String COLUMN_OBSCURE_INPUT_TEXT = "inputText";
    private static final String COLUMN_OBSCURE_DATE = "date";

    //DB Transactions

    private static final String CREATE_TABLE_OBSCURE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_OBSCURE + "("
                    + COLUMN_OBSCURE_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_OBSCURE_TYPE + " TEXT,"
                    + COLUMN_OBSCURE_INPUT_TEXT + " TEXT, "
                    + COLUMN_OBSCURE_DATE + " TEXT" + ")";

    private static final String INSERT_NEW_ROW_START =
            "INSERT INTO " + TABLE_OBSCURE
                    + " (" + COLUMN_OBSCURE_TYPE + ", "
                    + COLUMN_OBSCURE_INPUT_TEXT + ", "
                    + COLUMN_OBSCURE_DATE + ") "
                    + "VALUES (";

    private static final String INSERT_NEW_ROW_END = ")";

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_OBSCURE;

    public DBManager() {

        if (!checkHomeFolder()) {

            //TODO log error
        }
    }

    /**
     * Interface to clients. Parameters are used to build an entry which is then added
     * to the database.
     */
    public void addEntry(String input, String output, SCFunctionTypes type) {

        insert(constructEntry(input, output, type));

    }

    /**
     * Check if db exists, if not create it.
     */
    private boolean checkHomeFolder() {
        String home = System.getProperty("user.home");
        File dbFile = new File(home + "\\AppData\\Local\\ShadowCaster\\db\\shadow_caster.db");
        File dbFolder = new File(dbFile.getParent());
        File scFolder = new File(dbFolder.getParent());
        var toReturn = false;

        if (Files.notExists(scFolder.toPath())) {
            System.out.println("SC folder not found");
            toReturn = scFolder.mkdir();
        }

        if (Files.notExists(dbFolder.toPath())) {
            System.out.println("DB folder not found");
            toReturn = dbFolder.mkdir();
        }

        if (Files.notExists(dbFile.toPath())) {
            try {
                toReturn = dbFile.createNewFile();
            } catch (IOException e) {
                System.out.println("error creating file " + e.getMessage());
            }

            try (Connection connection = new DataSource().open();
                 Statement statement = connection.createStatement()) {
                createDB(statement);
            } catch (SQLException e) {

            }
        }

        return toReturn;

    }

    //TODO check where to position and when to execute
    private void createDB(Statement statement) {
        try {
            statement.execute(CREATE_TABLE_OBSCURE);
        } catch (SQLException e) {
            //TODO log error
            System.out.println("DB created");
        }

    }

    /**
     * Builds an entry for the db.
     */
    private Entry constructEntry(String input, String output, SCFunctionTypes type) {
        var calendar = Calendar.getInstance().getTime();
        var sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");

        return new Entry(type.toString(), input, output, sdf.format(calendar));
    }

    private void insert(Entry entry) {

        StringBuilder stringBuilder = new StringBuilder(INSERT_NEW_ROW_START);
        stringBuilder.append("'").append(entry.getType()).append("'").append(", ");
        stringBuilder.append("'").append(entry.getInputText()).append("'").append(", ");
        stringBuilder.append("'").append(entry.getDate()).append("'").append(INSERT_NEW_ROW_END);

        try (Connection connection = new DataSource().open();
             Statement statement = connection.createStatement()
        ) {
            statement.execute(stringBuilder.toString());
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            //TODO add error to logs
        }

    }

    /**
     * Returns all entries from the obscure table
     */
    private List<Entry> selectAllEntries() {

        try (Connection connection = new DataSource().open();
             Statement statement = connection.createStatement()) {
            statement.execute(SELECT_ALL);

        } catch (SQLException e) {
        }

        //TODO add error to Logs

        return null;
    }


}
