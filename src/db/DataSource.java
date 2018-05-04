package db;

import app.SCFunctionTypes;

import java.sql.*;

/**
 * DB Manager, contacts the dbController to initiate db changes
 */
public class DataSource {

    private static final String DB_NAME = "shadow_caster.db";
    private static final String CONNECTION = "jdbc:sqlite:src\\db\\" + DB_NAME;

    //TODO add db constants
    Connection connection;
    Statement statement;
    private DBController dbController;

    public void addEntry(String input, String output, SCFunctionTypes type) {
        Entry entry = new Entry();
        dbController = new DBController();
        entry.setType(type.toString());
        entry.setInputText(input);
        entry.setOutputText(output);

        open();

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            //TODO add error to logs
        }

        //TODO add date to the entry


        dbController.insert(statement, entry);

        close();
    }

    private void open() {

        try {
            connection = DriverManager.getConnection(CONNECTION);
            statement = connection.createStatement();

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
