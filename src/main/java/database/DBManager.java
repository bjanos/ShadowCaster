package database;

import app.SCFunctionTypes;
import log.Log;
import log.LogMessage;
import log.LogTypes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

    private static final String DB_FILE = System.getProperty("user.home") +
            "\\AppData\\Local\\ShadowCaster\\db\\shadow_caster.db";

    private static final String TABLE_OBSCURE = "transactions";
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

        if (Files.notExists(Paths.get(DB_FILE))) {
            createHomeFolders();

            new Log().write(new LogMessage(LogTypes.INFO, "DataBase not found. Database recreated."));
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
    private void createHomeFolders() {
        File dbFile = new File(DB_FILE);
        File dbFolder = new File(dbFile.getParent());
        File scFolder = new File(dbFolder.getParent());
        Log log = new Log();

        if (Files.notExists(scFolder.toPath())) {
            //TODO handle return value of mkdir
            scFolder.mkdir();
            log.write(new LogMessage(LogTypes.INFO, "Main folder not found. Main folder recreated."));
        }

        if (Files.notExists(dbFolder.toPath())) {
            dbFolder.mkdir();
            log.write(new LogMessage(LogTypes.INFO, "DB folder not found. DB folder recreated."));
        }

        if (Files.notExists(dbFile.toPath())) {
            try {
                dbFile.createNewFile();
            } catch (IOException e) {
                log.write(new LogMessage(LogTypes.ERROR, "Error creating .db file: " + e.getMessage()));
            }

            try (Connection connection = new DataSource().open();
                 Statement statement = connection.createStatement()) {
                createTable(statement);
            } catch (SQLException e) {
                log.write(new LogMessage(LogTypes.ERROR, "Error creating table: " + e.getMessage()));
            }
        }

    }

    //TODO check where to position and when to execute
    private void createTable(Statement statement) {
        try {
            statement.execute(CREATE_TABLE_OBSCURE);
        } catch (SQLException e) {
            new Log().write(new LogMessage(LogTypes.ERROR, "DataBase table could not be created"));
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

        try {
            Connection connection = new DataSource().open();
            if (connection == null) {

                new Log().write(
                        new LogMessage(
                                LogTypes.ERROR,
                                "Connection could not be established with the DataBase")
                );
                return;
            }
            Statement statement = connection.createStatement();
            statement.execute(stringBuilder.toString());
        } catch (SQLException e) {
            new Log().write(new LogMessage(LogTypes.ERROR, "Inserting entry to database failed: " + e.getMessage()));
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
            new Log().write(new LogMessage(LogTypes.ERROR, "Select entries failed"));

        }

        return null;
    }


}
