package data;

import app.SCFunctionTypes;

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

    private static final String TABLE_OBSCURE = "transactions";
    private static final String COLUMN_OBSCURE_ID = "_id";
    private static final String COLUMN_OBSCURE_TYPE = "type";
    private static final String COLUMN_OBSCURE_INPUT_TEXT = "inputText";
    private static final String COLUMN_OBSCURE_OUTPUT_TEXT = "outputText";
    private static final String COLUMN_OBSCURE_DATE = "date";

    //DB Transactions

    private static final String CREATE_TABLE_OBSCURE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_OBSCURE + "("
                    + COLUMN_OBSCURE_ID + " int PRIMARY KEY, "
                    + COLUMN_OBSCURE_INPUT_TEXT + " text, "
                    + COLUMN_OBSCURE_OUTPUT_TEXT + " text, "
                    + COLUMN_OBSCURE_DATE + " text" + ")";

    private static final String INSERT_NEW_ROW_START =
            "INSERT INTO " + TABLE_OBSCURE
                    + " (" + COLUMN_OBSCURE_TYPE + ", "
                    + COLUMN_OBSCURE_INPUT_TEXT + ", "
                    + COLUMN_OBSCURE_DATE + ") "
                    + "VALUES (";

    private static final String INSERT_NEW_ROW_END = ")";

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_OBSCURE;

    /**
     * Interface to clients. Parameters are used to build an entry which is then added
     * to the database.
     */
    public void addEntry(String input, String output, SCFunctionTypes type) {

        insert(constructEntry(input, output, type));

    }

    /**
     * Builds an entry for the db.
     * */
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

            //TODO add error to logs
        }

    }

    /**
     * Returns all entries from the obscure table
     */
    private List<Entry> selectAllEntries() {

        try (Connection connection = new DataSource().open();
             Statement statement = connection.createStatement()){
            statement.execute(SELECT_ALL);

        } catch (SQLException e) {}

        //TODO add error to Logs

        return null;
    }

    //TODO check where to position and when to execute
    private void createDB(Statement statement) {
        try {
            statement.execute(CREATE_TABLE_OBSCURE);
        } catch (SQLException e) {
            //TODO log error
            return;
        }

    }
}
