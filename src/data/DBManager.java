package data;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Contains and manages queries to the data.
 */
class DBManager {

    //TODO add query constants

    private static final String TABLE_OBSCURE = "obscure";
    private static final String COLUMN_OBSCURE_ID = "_id";
    private static final String COLUMN_OBSCURE_TYPE = "type";
    private static final String COLUMN_OBSCURE_INPUT_TEXT = "inputText";
    private static final String COLUMN_OBSCURE_OUTPUT_TEXT = "outputText";
    private static final String COLUMN_OBSCURE_DATE = "date";

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

    private Statement statement;

    public void insert(Statement statement, Entry entry) {

        StringBuilder stringBuilder = new StringBuilder(INSERT_NEW_ROW_START);
        stringBuilder.append("'").append(entry.getType()).append("'").append(", ");
        stringBuilder.append("'").append(entry.getInputText()).append("'").append(", ");
        stringBuilder.append("'").append(entry.getDate()).append("'").append(INSERT_NEW_ROW_END);

        try {
            statement.execute(stringBuilder.toString());
        } catch (SQLException e) {

            //TODO add error to logs
        }

    }

    /**
     * Returns entries from the obscure table
     */
    private List<Entry> selectEntries(Statement statement) {

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
