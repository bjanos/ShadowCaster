package data;

import app.SCFunctionTypes;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * DB Manager, contacts the dbController to initiate data changes
 */
public class DataSource {

    //TODO move db to Default/ShadowCaster folder

    private static final String DB_NAME = "shadow_caster.db";
    private static final String CONNECTION = "jdbc:sqlite:src\\data\\" + DB_NAME;

    //TODO add data constants
    private Connection connection;
    private Statement statement;
    private DBManager dbController;

    /**
     *
     *
     * */
    public void addEntry(String input, String output, SCFunctionTypes type) {
        var calendar = Calendar.getInstance().getTime();
        var sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm");

        Entry entry = new Entry();
        dbController = new DBManager();
        entry.setType(type.toString());
        entry.setInputText(input);
        entry.setOutputText(output);
        entry.setDate(sdf.format(calendar));

        open();

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            //TODO add error to logs
        }

        dbController.insert(statement, entry);

        close();
    }

    private void open() {

        try {
            connection = DriverManager.getConnection(CONNECTION);

        } catch (SQLException e) {
            //TODO add error logging
            return;
        }
    }

    private void close() {

        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            //TODO add error logging
            return;
        }


    }


}
