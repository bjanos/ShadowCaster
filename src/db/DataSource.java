package db;

import java.sql.*;

/**
 * DB Manager, contacts the SCController to initiate db changes
 */
public class DataSource {

    private static final String DB_NAME = "shadow_caster.db";
    private static final String CONNECTION = "jdbc:sqlite:src\\db\\" + DB_NAME;

    private SCController scController;

    public DataSource() {
        this.scController = new SCController();
    }

    public void executeQuery() {
        System.out.println(open());

        //TODO implement query
    }

    /**
     * Creates the db if not already created
     * */
    private void createDB() {

        //TODO implement db creation logic

    }

    /**
     * Second call after making sure, that the db exists.
     * */
    private Statement open() {

        try (Connection connection = DriverManager.getConnection(CONNECTION);
             Statement statement = connection.createStatement()) {


            return statement;
        } catch (SQLException e) {
            //TODO add error logging
            return null;
        }


    }

}
